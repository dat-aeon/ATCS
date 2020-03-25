package mm.aeon.com.ass.front.agentLogin;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.springframework.util.StringUtils;

import mm.aeon.com.ass.front.common.constants.DisplayItem;
import mm.aeon.com.ass.front.common.constants.LinkTarget;
import mm.aeon.com.ass.front.common.constants.MessageId;
import mm.aeon.com.ass.front.common.util.DisplayItemBean;
import mm.aeon.com.ass.front.sessions.LoginUserInfo;
import mm.com.dat.presto.main.core.front.controller.AbstractFormBean;
import mm.com.dat.presto.main.core.front.controller.FormBean;
import mm.com.dat.presto.main.core.front.controller.IRequest;
import mm.com.dat.presto.main.core.front.controller.IResponse;
import mm.com.dat.presto.main.front.message.MessageBean;
import mm.com.dat.presto.main.front.message.MessageType;

@Name("agentSetupFormBean")
@Scope(ScopeType.CONVERSATION)
@FormBean
public class AgentLoginFormBean extends AbstractFormBean implements IRequest, IResponse {

    /**
     * 
     */
    private static final long serialVersionUID = -8559169100855571603L;

    private AgentLoginHeaderBean agentHeaderBean;

    @In(required = false, value = "userInfo")
    @Out(required = false, value = "userInfo")
    private LoginUserInfo loginUserInfo;

    private boolean init = true;

    @Begin(join = true)
    public void init() {
        getMessageContainer().clearAllMessages(true);
        agentHeaderBean = new AgentLoginHeaderBean();
        init = false;
    }

    public String register() {

        if (StringUtils.isEmpty(agentHeaderBean.getTeleAgentName())) {
            MessageBean msgBean =
                    new MessageBean(MessageId.ME0003, DisplayItemBean.getDisplayItemName(DisplayItem.AGENT_NAME));
            msgBean.addColumnId(DisplayItem.AGENT_NAME);
            msgBean.setMessageType(MessageType.ERROR);
            getMessageContainer().addMessage(msgBean);
            return LinkTarget.ERROR;
        }

        loginUserInfo.setAgentName(agentHeaderBean.getTeleAgentName());

        return LinkTarget.OK;
    }

    public String back() {
        getMessageContainer().clearAllMessages(true);
        init = true;
        return LinkTarget.BACK;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public AgentLoginHeaderBean getAgentHeaderBean() {
        return agentHeaderBean;
    }

    public void setAgentHeaderBean(AgentLoginHeaderBean agentHeaderBean) {
        this.agentHeaderBean = agentHeaderBean;
    }

    public LoginUserInfo getLoginUserInfo() {
        return loginUserInfo;
    }

    public void setLoginUserInfo(LoginUserInfo loginUserInfo) {
        this.loginUserInfo = loginUserInfo;
    }

}
