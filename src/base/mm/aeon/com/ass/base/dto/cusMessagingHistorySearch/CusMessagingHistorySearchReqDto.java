/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.base.dto.cusMessagingHistorySearch;

import mm.com.dat.presto.main.common.dao.bean.DaoType;
import mm.com.dat.presto.main.common.dao.bean.IReqServiceDto;
import mm.com.dat.presto.main.core.dao.controller.MyBatisMapper;

@MyBatisMapper(namespace = "MessagingHistory")
public class CusMessagingHistorySearchReqDto implements IReqServiceDto {

    /**
     * 
     */
    private static final long serialVersionUID = 5505678970426406498L;

    private String customerName;

    private Integer categoryId;

    private Integer brandId;

    private Integer fromInterval;

    private Integer toInterval;

    private Integer limit;

    private Integer offset;

    private String sortField;

    private String sortOrder;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getFromInterval() {
        return fromInterval;
    }

    public void setFromInterval(Integer fromInterval) {
        this.fromInterval = fromInterval;
    }

    public Integer getToInterval() {
        return toInterval;
    }

    public void setToInterval(Integer toInterval) {
        this.toInterval = toInterval;
    }

    @Override
    public DaoType getDaoType() {
        return DaoType.SELECT_LIST;
    }

}
