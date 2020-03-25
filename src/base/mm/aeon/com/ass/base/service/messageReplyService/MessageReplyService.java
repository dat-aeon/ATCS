/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.base.service.messageReplyService;

import mm.aeon.com.ass.base.dto.messageReply.MessageReplyReqDto;
import mm.aeon.com.ass.front.common.constants.VCSCommon;
import mm.aeon.com.ass.front.common.util.CommonUtil;
import mm.aeon.com.ass.log.ASSLogger;
import mm.com.dat.presto.main.common.service.bean.AbstractService;
import mm.com.dat.presto.main.common.service.bean.IService;
import mm.com.dat.presto.main.common.service.bean.ServiceStatusCode;
import mm.com.dat.presto.main.exception.BaseException;
import mm.com.dat.presto.main.exception.DaoSqlException;
import mm.com.dat.presto.main.exception.RecordDuplicatedException;
import mm.com.dat.presto.main.log.LogLevel;

public class MessageReplyService extends AbstractService
        implements IService<MessageReplyServiceReqBean, MessageReplyServiceResBean> {

    private ASSLogger logger = new ASSLogger();

    @Override
    public MessageReplyServiceResBean execute(MessageReplyServiceReqBean reqBean) {

        MessageReplyReqDto reqDto = new MessageReplyReqDto();
        MessageReplyServiceResBean resBean = new MessageReplyServiceResBean();

        reqDto.setCustomerId(reqBean.getCustomerId());
        reqDto.setCategoryId(reqBean.getCategoryId());
        reqDto.setBrandId(reqBean.getBrandId());
        reqDto.setPrice(reqBean.getPrice());
        reqDto.setPhoneNumber(reqBean.getPhoneNumber());
        reqDto.setAdditionalText(reqBean.getAdditionalText());
        reqDto.setUrl(reqBean.getUrl());
        reqDto.setSendTime(CommonUtil.getCurrentTimeStamp());
        reqDto.setOpSendFlag(VCSCommon.ONE_INTEGER);
        reqDto.setAgentLevelId(CommonUtil.getLoginUserInfo().getAgentId());
        reqDto.setSender(CommonUtil.getLoginUserInfo().getAgentName());
        reqDto.setReadFlag(VCSCommon.ZERO_INTEGER);

        try {
            this.getDaoServiceInvoker().execute(reqDto);
            resBean.setServiceStatus(ServiceStatusCode.OK);
        } catch (Exception e) {
            if (e instanceof RecordDuplicatedException) {
                resBean.setServiceStatus(ServiceStatusCode.RECORD_DUPLICATED_ERROR);

            } else if (e instanceof DaoSqlException) {
                logger.log(e.getCause().getMessage(), e.getCause(), LogLevel.ERROR);
                resBean.setServiceStatus(ServiceStatusCode.SQL_ERROR);

            } else {
                logger.log(e.getCause().getMessage(), e.getCause(), LogLevel.ERROR);
                throw new BaseException(e.getCause());
            }
        }

        return resBean;
    }

}
