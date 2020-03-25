/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.base.dto.productTypeList;

import mm.com.dat.presto.main.common.dao.bean.DaoType;
import mm.com.dat.presto.main.common.dao.bean.IReqServiceDto;
import mm.com.dat.presto.main.core.dao.controller.MyBatisMapper;

@MyBatisMapper(namespace = "ProductTypeInfo")
public class ProductTypeSelectListReqDto implements IReqServiceDto {

    /**
     * 
     */
    private static final long serialVersionUID = -787984534431564776L;

    private Boolean delFlag;

    private Integer fromInterval;

    private Integer toInterval;

    @Override
    public DaoType getDaoType() {
        return DaoType.SELECT_LIST;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
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
