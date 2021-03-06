/**************************************************************************
 * $Date: 2018-06-20$
 * $Author: Khin Yadanar Thein$
 * $Rev:  $
 * 2018 AEON Microfinance (Myanmar) Company Limited. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.front.sessions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.primefaces.model.menu.MenuModel;

import mm.aeon.com.ass.front.common.exception.ASSFrontException;

/**
 * PMWUserInfo Session Bean. In this, login user information, menu tree list are stored.
 * <p>
 * 
 * <pre>
 * </pre>
 * 
 * <p>
 * 
 */
@Name("userInfo")
@Scope(ScopeType.SESSION)
public class LoginUserInfo {

    private Integer agentId;

    private Integer teleAgentId;

    private String agentName;

    private String agentCode;

    private String agentLevel;

    private Integer timeInterval;

    private String lastOperationDateTime;

    private boolean isLoggedIn;

    private MenuModel menuModel;

    private String updatedBy;

    private String updatedTime;

    private Timestamp loginTime;

    private String atAgentLevelTypeName;

    /**
     * Set lastOperationDateTime.
     * 
     * @param lastOperationDateTime
     *            set lastOperationDateTime
     */
    public void setLastOperationDateTime(String lastOperationDateTime) {
        this.lastOperationDateTime = lastOperationDateTime;
    }

    public String getLastOperationDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        lastOperationDateTime = dateFormat.format(cal.getTime());
        return lastOperationDateTime;
    }

    public void isSessionValid() {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("/view/Login.xhtml");
        } catch (Exception e) {
            throw new ASSFrontException();
        }
    }

    public String getAtAgentLevelTypeName() {
        return atAgentLevelTypeName;
    }

    public void setAtAgentLevelTypeName(String atAgentLevelTypeName) {
        this.atAgentLevelTypeName = atAgentLevelTypeName;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getTeleAgentId() {
        return teleAgentId;
    }

    public void setTeleAgentId(Integer teleAgentId) {
        this.teleAgentId = teleAgentId;
    }

    public String getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(String agentLevel) {
        this.agentLevel = agentLevel;
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

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
}
