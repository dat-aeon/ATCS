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

@MyBatisMapper(namespace = "MessagingHistoryCount")
public class CusMessagingHistorySelectCountReqDto implements IReqServiceDto {

    /**
     * 
     */
    private static final long serialVersionUID = -5376898487674767104L;

    private String customerName;

    private Integer categoryId;

    private Integer brandId;

    private Integer fromInterval;

    private Integer toInterval;

    @Override
    public DaoType getDaoType() {
        return DaoType.SELECT_LIST;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

}
