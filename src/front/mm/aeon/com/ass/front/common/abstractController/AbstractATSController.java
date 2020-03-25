/**************************************************************************
 * $Date: 2018-06-20$
 * $Author: Khin Yadanar Thein $
 * $Rev:  $
 * 2018 AEON Microfinance (Myanmar) Company Limited. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.front.common.abstractController;

import java.util.ArrayList;

import javax.faces.model.SelectItem;

import mm.aeon.com.ass.base.dto.brandList.BrandSelectListReqDto;
import mm.aeon.com.ass.base.dto.brandList.BrandSelectListResDto;
import mm.aeon.com.ass.base.dto.productTypeList.ProductTypeSelectListReqDto;
import mm.aeon.com.ass.base.dto.productTypeList.ProductTypeSelectListResDto;
import mm.aeon.com.ass.base.dto.scheduleInfoRefer.ScheduleInfoReferReqDto;
import mm.aeon.com.ass.base.dto.scheduleInfoRefer.ScheduleInfoReferResDto;
import mm.aeon.com.ass.front.common.constants.VCSCommon;
import mm.aeon.com.ass.front.common.util.CommonUtil;
import mm.aeon.com.ass.log.ASSLogger;
import mm.com.dat.presto.main.core.front.controller.AbstractController;
import mm.com.dat.presto.main.exception.BaseException;
import mm.com.dat.presto.main.exception.DaoSqlException;
import mm.com.dat.presto.main.exception.PrestoDBException;
import mm.com.dat.presto.main.log.ApplicationLogger;
import mm.com.dat.presto.main.log.LogLevel;

/**
 * AbstractProjectController Class.
 * <p>
 * 
 * <pre>
 * 
 * </pre>
 * 
 * </p>
 */
public abstract class AbstractATSController extends AbstractController {

    private ASSLogger logger = new ASSLogger();

    private ApplicationLogger applicationLogger = new ApplicationLogger();

    protected ArrayList<SelectItem> getEmptyList() {

        applicationLogger.log("User Search Process started.", LogLevel.INFO);

        ArrayList<SelectItem> emptyList = new ArrayList<SelectItem>();

        SelectItem item = new SelectItem();
        item.setLabel(VCSCommon.SPACE);
        item.setValue(null);
        emptyList.add(item);

        return emptyList;
    }

    protected ArrayList<SelectItem> getGenderSelectList() {
        ArrayList<SelectItem> genderSelectList = new ArrayList<>();

        genderSelectList.add(new SelectItem(new Integer(1), "Male"));
        genderSelectList.add(new SelectItem(new Integer(2), "Female"));

        return genderSelectList;
    }

    protected ArrayList<SelectItem> getOperatorRoleSelectList() {
        ArrayList<SelectItem> roleOperatorSelectList = new ArrayList<>();

        roleOperatorSelectList.add(new SelectItem(new Integer(1), "Mobile"));
        roleOperatorSelectList.add(new SelectItem(new Integer(2), "Non-Mobile"));
        roleOperatorSelectList.add(new SelectItem(new Integer(3), "Personal-Loan"));
        roleOperatorSelectList.add(new SelectItem(new Integer(4), "Motorcycle-Loan"));

        return roleOperatorSelectList;
    }

}
