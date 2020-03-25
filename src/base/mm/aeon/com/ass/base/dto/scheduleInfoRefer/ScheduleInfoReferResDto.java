/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.base.dto.scheduleInfoRefer;

import mm.com.dat.presto.main.common.dao.bean.IResServiceDto;

public class ScheduleInfoReferResDto implements IResServiceDto {

    /**
     * 
     */
    private static final long serialVersionUID = 4511546202956199291L;

    private Integer scheduleId;

    private Integer durationHour;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getDurationHour() {
        return durationHour;
    }

    public void setDurationHour(Integer durationHour) {
        this.durationHour = durationHour;
    }

}
