/**************************************************************************
 * $Date: 2018-06-20$
 * $Author: Swe Hsu Mon $
 * $Rev:  $
 * 2018 AEON Microfinance (Myanmar) Company Limited. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.base.dto.loginInfoRefer;

import mm.com.dat.presto.main.common.dao.bean.IResServiceDto;

public class LoginInfoReferResDto implements IResServiceDto {

    /**
     * 
     */
    private static final long serialVersionUID = -8085767478555013466L;

    private Integer agentId;

    private String agentName;

    private Integer timeInterval;

    private String agentLevelCode;

    private String atAgentLevelTypeName;

    public String getAtAgentLevelTypeName() {
        return atAgentLevelTypeName;
    }

    public void setAtAgentLevelTypeName(String atAgentLevelTypeName) {
        this.atAgentLevelTypeName = atAgentLevelTypeName;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getAgentLevelCode() {
        return agentLevelCode;
    }

    public void setAgentLevelCode(String agentLevelCode) {
        this.agentLevelCode = agentLevelCode;
    }

}
