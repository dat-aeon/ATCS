/**************************************************************************
 * $Date : $
 * $Author : $
 * $Rev : $
 * Copyright (c) 2014 DIR-ACE Technology Ltd. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.front.agentLogin;

import java.io.Serializable;

public class AgentLoginHeaderBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4998619738834744521L;

    private String teleAgentName;

    public String getTeleAgentName() {
        return teleAgentName;
    }

    public void setTeleAgentName(String teleAgentName) {
        this.teleAgentName = teleAgentName;
    }

}
