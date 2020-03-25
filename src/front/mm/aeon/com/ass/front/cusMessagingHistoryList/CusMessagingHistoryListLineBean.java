/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.front.cusMessagingHistoryList;

import java.io.Serializable;
import java.sql.Timestamp;

public class CusMessagingHistoryListLineBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6233824527357141029L;

    private Integer chatMessageId;
    private Integer customerId;
    private Integer productTypeId;
    private Integer brandId;
    private String messageContent;
    private String customerLocation;
    private Timestamp textedTime;
    private String customerName;

    public Integer getChatMessageId() {
        return chatMessageId;
    }

    public void setChatMessageId(Integer chatMessageId) {
        this.chatMessageId = chatMessageId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    public Timestamp getTextedTime() {
        return textedTime;
    }

    public void setTextedTime(Timestamp textedTime) {
        this.textedTime = textedTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
