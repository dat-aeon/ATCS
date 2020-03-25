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

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.primefaces.model.LazyDataModel;

import mm.aeon.com.ass.base.dto.cusMessagingHistorySearch.CusMessagingHistorySearchReqDto;
import mm.aeon.com.ass.front.common.constants.LinkTarget;
import mm.aeon.com.ass.front.cusMessageReply.CusMessagingReplyHeaderBean;
import mm.com.dat.presto.main.core.front.controller.AbstractFormBean;
import mm.com.dat.presto.main.core.front.controller.Action;
import mm.com.dat.presto.main.core.front.controller.FormBean;
import mm.com.dat.presto.main.core.front.controller.IRequest;
import mm.com.dat.presto.main.core.front.controller.IResponse;
import mm.com.dat.presto.main.front.message.MessageType;

@Name("cusMessagingHistoryListFormBean")
@Scope(ScopeType.CONVERSATION)
@FormBean
public class CusMessagingHistoryListFormBean extends AbstractFormBean implements IRequest, IResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 2963684102186598349L;

    private CusMessagingHistorySearchReqDto messagingHistorySearchReqDto;

    private List<CusMessagingHistoryListLineBean> messagingHistoryListLineBeanList;

    private LazyDataModel<CusMessagingHistoryListLineBean> messagingHistoryListLineBeanLazyModel;

    private CusMessagingHistoryListHeaderBean messagingHistoryListHeaderBean;

    private CusMessagingHistoryListLineBean lineBean;

    private int totalCount;

    private List<Integer> hideMessages = new ArrayList<>();

    private List<SelectItem> brandStatusSelectItemList;

    private List<SelectItem> productTypeStatusSelectItemList;

    private boolean init = true;

    @In(required = false, value = "doReload")
    @Out(required = false, value = "doReload")
    private Boolean doReload;

    @In(required = false, value = "replyHeaderBean")
    @Out(required = false, value = "replyHeaderBean")
    private CusMessagingReplyHeaderBean replyHeaderBean;

    @In(required = false, value = "messageId")
    @Out(required = false, value = "messageId")
    private Integer messageId;

    private int pageFirst;

    @Begin(nested = true)
    public void init() {
        getMessageContainer().clearAllMessages(true);
        messagingHistoryListHeaderBean = new CusMessagingHistoryListHeaderBean();
        doReload = new Boolean(true);
        init = false;
    }

    @Action
    public String search() {
        doReload = new Boolean(false);
        messagingHistoryListLineBeanLazyModel = null;

        if (!this.getMessageContainer().checkMessage(MessageType.ERROR)
                && messagingHistoryListLineBeanList.size() != 0) {
            messagingHistoryListLineBeanLazyModel = new CusMessagingPaginationController(
                    messagingHistoryListLineBeanList.size(), messagingHistoryListLineBeanList);
        }

        return LinkTarget.OK;
    }

    @Begin(join = true)
    public String viewReplyForm(CusMessagingHistoryListLineBean lineBean) {
        getMessageContainer().clearAllMessages(true);
        this.lineBean = lineBean;
        this.replyHeaderBean = new CusMessagingReplyHeaderBean();
        this.replyHeaderBean.setChatMessageId(lineBean.getChatMessageId());
        this.replyHeaderBean.setCustomerId(lineBean.getCustomerId());
        this.replyHeaderBean.setCustomerName(lineBean.getCustomerName());
        this.replyHeaderBean.setCategoryId(lineBean.getProductTypeId());
        this.replyHeaderBean.setCategory(getProductTypeStatusValue(lineBean.getProductTypeId()));
        this.replyHeaderBean.setBrandId(lineBean.getBrandId());
        this.replyHeaderBean.setBrand(getBrandStatusValue(lineBean.getBrandId()));
        return LinkTarget.REGISTER;
    }

    public void reset() {
        messagingHistoryListHeaderBean = new CusMessagingHistoryListHeaderBean();
    }

    public String hide(CusMessagingHistoryListLineBean lineBean) {
        getMessageContainer().clearAllMessages(true);
        init = true;
        Boolean isHideExist = false;
        for (Integer i : this.hideMessages) {
            if (i == lineBean.getChatMessageId()) {
                isHideExist = true;
            }
        }
        if (isHideExist == false)
            this.hideMessages.add(lineBean.getChatMessageId());
        return LinkTarget.SEARCH;
    }

    public String getBrandStatusValue(Integer i) {
        if (i != null) {
            for (SelectItem selectItem : brandStatusSelectItemList) {
                if (i.equals(selectItem.getValue())) {
                    return selectItem.getLabel();
                }
            }
        }
        return "";
    }

    public String getProductTypeStatusValue(Integer i) {
        if (i != null) {
            for (SelectItem selectItem : productTypeStatusSelectItemList) {
                if (i.equals(selectItem.getValue())) {
                    return selectItem.getLabel();
                }
            }
        }
        return "";
    }

    public List<CusMessagingHistoryListLineBean> getMessagingHistoryListLineBeanList() {
        return messagingHistoryListLineBeanList;
    }

    public void setMessagingHistoryListLineBeanList(
            List<CusMessagingHistoryListLineBean> messagingHistoryListLineBeanList) {
        this.messagingHistoryListLineBeanList = messagingHistoryListLineBeanList;
    }

    public LazyDataModel<CusMessagingHistoryListLineBean> getMessagingHistoryListLineBeanLazyModel() {
        return messagingHistoryListLineBeanLazyModel;
    }

    public void setMessagingHistoryListLineBeanLazyModel(
            LazyDataModel<CusMessagingHistoryListLineBean> messagingHistoryListLineBeanLazyModel) {
        this.messagingHistoryListLineBeanLazyModel = messagingHistoryListLineBeanLazyModel;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public Boolean getDoReload() {
        return doReload;
    }

    public void setDoReload(Boolean doReload) {
        this.doReload = doReload;
    }

    public int getPageFirst() {
        return pageFirst;
    }

    public void setPageFirst(int pageFirst) {
        this.pageFirst = pageFirst;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public CusMessagingHistorySearchReqDto getMessagingHistorySearchReqDto() {
        return messagingHistorySearchReqDto;
    }

    public void setMessagingHistorySearchReqDto(CusMessagingHistorySearchReqDto messagingHistorySearchReqDto) {
        this.messagingHistorySearchReqDto = messagingHistorySearchReqDto;
    }

    public CusMessagingHistoryListHeaderBean getMessagingHistoryListHeaderBean() {
        return messagingHistoryListHeaderBean;
    }

    public void setMessagingHistoryListHeaderBean(CusMessagingHistoryListHeaderBean messagingHistoryListHeaderBean) {
        this.messagingHistoryListHeaderBean = messagingHistoryListHeaderBean;
    }

    public List<SelectItem> getBrandStatusSelectItemList() {
        return brandStatusSelectItemList;
    }

    public void setBrandStatusSelectItemList(List<SelectItem> brandStatusSelectItemList) {
        this.brandStatusSelectItemList = brandStatusSelectItemList;
    }

    public List<SelectItem> getProductTypeStatusSelectItemList() {
        return productTypeStatusSelectItemList;
    }

    public void setProductTypeStatusSelectItemList(List<SelectItem> productTypeStatusSelectItemList) {
        this.productTypeStatusSelectItemList = productTypeStatusSelectItemList;
    }

    public CusMessagingHistoryListLineBean getLineBean() {
        return lineBean;
    }

    public void setLineBean(CusMessagingHistoryListLineBean lineBean) {
        this.lineBean = lineBean;
    }

    public CusMessagingReplyHeaderBean getReplyHeaderBean() {
        return replyHeaderBean;
    }

    public void setReplyHeaderBean(CusMessagingReplyHeaderBean replyHeaderBean) {
        this.replyHeaderBean = replyHeaderBean;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public List<Integer> getHideMessages() {
        return hideMessages;
    }

    public void setHideMessages(List<Integer> hideMessages) {
        this.hideMessages = hideMessages;
    }

}
