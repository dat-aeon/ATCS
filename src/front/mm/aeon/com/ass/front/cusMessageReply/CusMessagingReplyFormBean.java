/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.front.cusMessageReply;

import java.util.List;

import javax.faces.model.SelectItem;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;

import mm.aeon.com.ass.base.dto.cusMessagingHistorySearch.CusMessagingHistorySearchReqDto;
import mm.aeon.com.ass.front.common.constants.LinkTarget;
import mm.aeon.com.ass.front.cusMessagingHistoryList.CusMessagingHistoryListFormBean;
import mm.com.dat.presto.main.core.front.controller.AbstractFormBean;
import mm.com.dat.presto.main.core.front.controller.Action;
import mm.com.dat.presto.main.core.front.controller.FormBean;
import mm.com.dat.presto.main.core.front.controller.IRequest;
import mm.com.dat.presto.main.core.front.controller.IResponse;
import mm.com.dat.presto.main.front.message.MessageType;

@Name("cusMessagingReplyFormBean")
@Scope(ScopeType.CONVERSATION)
@FormBean
public class CusMessagingReplyFormBean extends AbstractFormBean implements IRequest, IResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 2963684102186598349L;

    private CusMessagingHistorySearchReqDto messagingHistorySearchReqDto;

    private CusMessagingReplyHeaderBean replyHeaderBean;

    private List<SelectItem> brandStatusSelectItemList;

    private List<SelectItem> productTypeStatusSelectItemList;

    private boolean init = true;

    @In(required = false, value = "doReload")
    @Out(required = false, value = "doReload")
    private Boolean doReload;

    @In(required = false, value = "replyHeaderBean")
    @Out(required = false, value = "replyHeaderBean")
    private CusMessagingReplyHeaderBean replyParam;

    @In(required = false, value = "messageId")
    @Out(required = false, value = "messageId")
    private Integer messageId;

    private int pageFirst;

    @Begin(nested = true)
    public void init() {
        getMessageContainer().clearAllMessages(true);
        replyHeaderBean = new CusMessagingReplyHeaderBean();
        doReload = new Boolean(true);
        init = false;
        this.replyHeaderBean.setChatMessageId(replyParam.getChatMessageId());
        this.replyHeaderBean.setCustomerId(replyParam.getCustomerId());
        this.replyHeaderBean.setCustomerName(replyParam.getCustomerName());
        this.replyHeaderBean.setCategoryId(replyParam.getCategoryId());
        this.replyHeaderBean.setBrandId(replyParam.getBrandId());
        this.replyHeaderBean.setBrand(replyParam.getBrand());
        this.replyHeaderBean.setCategory(replyParam.getCategory());
    }

    @Action
    public String reply() {
        if (getMessageContainer().checkMessage(MessageType.ERROR)) {
            return LinkTarget.ERROR;
        } else {
            messageId = replyHeaderBean.getChatMessageId();
            replyHeaderBean = new CusMessagingReplyHeaderBean();
            init = true;
            doReload = new Boolean(true);            
            return LinkTarget.OK;
        }

    }

    public String back() {
        this.getMessageContainer().clearAllMessages(true);
        this.init = true;
        this.replyHeaderBean = null;

        return LinkTarget.SEARCH;
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

    public CusMessagingHistorySearchReqDto getMessagingHistorySearchReqDto() {
        return messagingHistorySearchReqDto;
    }

    public void setMessagingHistorySearchReqDto(CusMessagingHistorySearchReqDto messagingHistorySearchReqDto) {
        this.messagingHistorySearchReqDto = messagingHistorySearchReqDto;
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

    public CusMessagingReplyHeaderBean getReplyParam() {
        return replyParam;
    }

    public void setReplyParam(CusMessagingReplyHeaderBean replyParam) {
        this.replyParam = replyParam;
    }

}
