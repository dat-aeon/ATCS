/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.base.dto.brandList;

import mm.com.dat.presto.main.common.dao.bean.DaoType;
import mm.com.dat.presto.main.common.dao.bean.IReqServiceDto;
import mm.com.dat.presto.main.core.dao.controller.MyBatisMapper;

@MyBatisMapper(namespace = "BrandInfo")
public class BrandSelectListReqDto implements IReqServiceDto {

    /**
     * 
     */
    private static final long serialVersionUID = -787984534431564776L;

    private Integer delFlag;

    private Integer fromInterval;

    private Integer toInterval;

    @Override
    public DaoType getDaoType() {
        return DaoType.SELECT_LIST;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
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
