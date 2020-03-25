/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.front.cusMessagingHistoryList;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import mm.aeon.com.ass.base.dto.brandList.BrandSelectListReqDto;
import mm.aeon.com.ass.base.dto.brandList.BrandSelectListResDto;
import mm.aeon.com.ass.base.dto.cusMessagingHistorySearch.CusMessagingHistorySearchReqDto;
import mm.aeon.com.ass.base.dto.cusMessagingHistorySearch.CusMessagingHistorySearchResDto;
import mm.aeon.com.ass.base.dto.productTypeList.ProductTypeSelectListReqDto;
import mm.aeon.com.ass.base.dto.productTypeList.ProductTypeSelectListResDto;
import mm.aeon.com.ass.base.dto.scheduleInfoRefer.ScheduleInfoReferReqDto;
import mm.aeon.com.ass.base.dto.scheduleInfoRefer.ScheduleInfoReferResDto;
import mm.aeon.com.ass.front.common.constants.MessageId;
import mm.aeon.com.ass.front.common.util.CommonUtil;
import mm.aeon.com.ass.log.ASSLogger;
import mm.com.dat.presto.main.core.front.controller.AbstractController;
import mm.com.dat.presto.main.core.front.controller.IControllerAccessor;
import mm.com.dat.presto.main.exception.BaseException;
import mm.com.dat.presto.main.exception.DaoSqlException;
import mm.com.dat.presto.main.exception.PrestoDBException;
import mm.com.dat.presto.main.front.message.MessageBean;
import mm.com.dat.presto.main.front.message.MessageType;
import mm.com.dat.presto.main.log.ApplicationLogger;
import mm.com.dat.presto.main.log.LogLevel;

public class CusMessagingHistoryListController extends AbstractController
        implements IControllerAccessor<CusMessagingHistoryListFormBean, CusMessagingHistoryListFormBean> {

    private ApplicationLogger applicationLogger = new ApplicationLogger();

    private ASSLogger logger = new ASSLogger();

    @Override
    public CusMessagingHistoryListFormBean process(CusMessagingHistoryListFormBean formBean) {

        formBean.getMessageContainer().clearAllMessages(!formBean.getDoReload());

        applicationLogger.log("Item Info searching process stared.", LogLevel.INFO);
        MessageBean messageBean;

        ScheduleInfoReferReqDto scheduleReqDto = new ScheduleInfoReferReqDto();

        ScheduleInfoReferResDto scheduleResDto;
        try {
            scheduleResDto = (ScheduleInfoReferResDto) this.getDaoServiceInvoker().execute(scheduleReqDto);

            // For Brand List

            List<SelectItem> brandTypeSelectList = new ArrayList<>();
            BrandSelectListReqDto brandReqDto = new BrandSelectListReqDto();

            scheduleResDto = (ScheduleInfoReferResDto) this.getDaoServiceInvoker().execute(scheduleReqDto);
            if (scheduleResDto.getDurationHour() != null) {
                brandReqDto.setToInterval(scheduleResDto.getDurationHour());
            }
            if (CommonUtil.getLoginUserInfo().getTimeInterval() != null) {
                /* String fromInteval = CommonUtil.getLoginUserInfo().getTimeInterval() + " minute"; */
                brandReqDto.setFromInterval(CommonUtil.getLoginUserInfo().getTimeInterval());
            }
            List<BrandSelectListResDto> resDtoList =
                    (List<BrandSelectListResDto>) CommonUtil.getDaoServiceInvoker().execute(brandReqDto);

            for (BrandSelectListResDto brandResDto : resDtoList) {
                SelectItem selectItem = new SelectItem();
                selectItem.setLabel(brandResDto.getBrandName());
                selectItem.setValue(brandResDto.getBrandId());

                brandTypeSelectList.add(selectItem);
            }

            formBean.setBrandStatusSelectItemList(brandTypeSelectList);

            // For Product Type

            List<SelectItem> productTypeSelectList = new ArrayList<>();
            ProductTypeSelectListReqDto productReqDto = new ProductTypeSelectListReqDto();
            scheduleResDto = (ScheduleInfoReferResDto) this.getDaoServiceInvoker().execute(scheduleReqDto);
            if (scheduleResDto.getDurationHour() != null) {
                productReqDto.setToInterval(scheduleResDto.getDurationHour());
            }
            if (CommonUtil.getLoginUserInfo().getTimeInterval() != null) {
                /* String fromInteval = CommonUtil.getLoginUserInfo().getTimeInterval() + " minute"; */
                productReqDto.setFromInterval(CommonUtil.getLoginUserInfo().getTimeInterval());
            }
            List<ProductTypeSelectListResDto> productTypeSelectListResDtoList =
                    (List<ProductTypeSelectListResDto>) CommonUtil.getDaoServiceInvoker().execute(productReqDto);

            for (ProductTypeSelectListResDto productResDto : productTypeSelectListResDtoList) {
                SelectItem selectItem = new SelectItem();
                selectItem.setLabel(productResDto.getProductName());
                selectItem.setValue(productResDto.getProductTypeId());

                productTypeSelectList.add(selectItem);
            }

            formBean.setProductTypeStatusSelectItemList(productTypeSelectList);
            /*
             * if (formBean.getProductTypeStatusSelectItemList().size() == 0) { messageBean = new
             * MessageBean(MessageId.ME1006, "BRAND"); messageBean.setMessageType(MessageType.ERROR);
             * formBean.getMessageContainer().addMessage(messageBean); applicationLogger.log(messageBean.getMessage(),
             * LogLevel.INFO); }
             */

            CusMessagingHistorySearchReqDto reqDto = new CusMessagingHistorySearchReqDto();

            if (scheduleResDto.getDurationHour() != null) {
                /* String toInterval = scheduleResDto.getDurationHour() + " hour"; */
                reqDto.setToInterval(scheduleResDto.getDurationHour());
            }
            if (CommonUtil.getLoginUserInfo().getTimeInterval() != null) {
                /* String fromInteval = CommonUtil.getLoginUserInfo().getTimeInterval() + " minute"; */
                reqDto.setFromInterval(CommonUtil.getLoginUserInfo().getTimeInterval());
            }
            if (formBean.getMessagingHistoryListHeaderBean().getBrandId() != null) {
                reqDto.setBrandId(formBean.getMessagingHistoryListHeaderBean().getBrandId());
            }
            if (formBean.getMessagingHistoryListHeaderBean().getCategoryId() != null) {
                reqDto.setCategoryId(formBean.getMessagingHistoryListHeaderBean().getCategoryId());
            }

            List<CusMessagingHistoryListLineBean> lineBeanList = new ArrayList<CusMessagingHistoryListLineBean>();
            List<CusMessagingHistorySearchResDto> cusMessagingHistorySearchResDtoList =
                    (List<CusMessagingHistorySearchResDto>) CommonUtil.getDaoServiceInvoker().execute(reqDto);

            if (formBean.getMessageId() != null) {
                Boolean isHideExist = false;
                for (Integer i : formBean.getHideMessages()) {
                    if (i == formBean.getMessageId()) {
                        isHideExist = true;
                    }
                }
                if (isHideExist == false)
                    formBean.getHideMessages().add(formBean.getMessageId());
            }

            for (CusMessagingHistorySearchResDto resDto : cusMessagingHistorySearchResDtoList) {
                if (formBean.getHideMessages().size() > 0) {
                    boolean isHideFlag = false;
                    for (Integer hideLineBean : formBean.getHideMessages()) {
                        if (hideLineBean.equals(resDto.getChatMessageId())) {
                            isHideFlag = true;
                        }
                    }
                    if (isHideFlag == false) {
                        CusMessagingHistoryListLineBean lineBean = new CusMessagingHistoryListLineBean();
                        lineBean.setChatMessageId(resDto.getChatMessageId());
                        lineBean.setCustomerId(resDto.getCustomerId());
                        lineBean.setProductTypeId(resDto.getProductTypeId());
                        lineBean.setBrandId(resDto.getBrandId());
                        lineBean.setMessageContent(resDto.getMessageContent());
                        lineBean.setCustomerLocation(resDto.getCustomerLocation());
                        lineBean.setTextedTime(resDto.getTextedTime());
                        lineBean.setCustomerName(resDto.getCustomerName());

                        lineBeanList.add(lineBean);
                    }
                } else {
                    CusMessagingHistoryListLineBean lineBean = new CusMessagingHistoryListLineBean();
                    lineBean.setChatMessageId(resDto.getChatMessageId());
                    lineBean.setCustomerId(resDto.getCustomerId());
                    lineBean.setProductTypeId(resDto.getProductTypeId());
                    lineBean.setBrandId(resDto.getBrandId());
                    lineBean.setMessageContent(resDto.getMessageContent());
                    lineBean.setCustomerLocation(resDto.getCustomerLocation());
                    lineBean.setTextedTime(resDto.getTextedTime());
                    lineBean.setCustomerName(resDto.getCustomerName());

                    lineBeanList.add(lineBean);
                }
            }

            formBean.setMessagingHistoryListLineBeanList(lineBeanList);

            if (lineBeanList.size() == 0) {
                messageBean = new MessageBean(MessageId.MI0008);
            } else {
                messageBean = new MessageBean(MessageId.MI0007, String.valueOf(lineBeanList.size()));
            }

            formBean.setTotalCount(lineBeanList.size());
            formBean.setMessagingHistorySearchReqDto(reqDto);
            messageBean.setMessageType(MessageType.INFO);
            formBean.getMessageContainer().addMessage(messageBean);
            applicationLogger.log(messageBean.getMessage(), LogLevel.INFO);
            applicationLogger.log("Item Info searching finished.", LogLevel.INFO);

        } catch (PrestoDBException e1) {
            if (e1 instanceof DaoSqlException) {
                logger.log(e1.getCause().getMessage(), e1.getCause(), LogLevel.ERROR);
                throw new BaseException(e1.getCause());
            }
        }

        return formBean;
    }

}
