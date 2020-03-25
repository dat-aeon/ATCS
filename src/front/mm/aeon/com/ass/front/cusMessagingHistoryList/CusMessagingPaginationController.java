/**************************************************************************
 * $Date: 2018-09-05$
 * $Author: Arjun $
 * $Rev:  $
 * 2018 AEON Microfinance (Myanmar) Company Limited. All Rights Reserved.
 *************************************************************************/
package mm.aeon.com.ass.front.cusMessagingHistoryList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import mm.com.dat.presto.main.log.ApplicationLogger;
import mm.com.dat.presto.main.log.LogLevel;

public class CusMessagingPaginationController extends LazyDataModel<CusMessagingHistoryListLineBean> {

    /**
     * 
     */
    private static final long serialVersionUID = -8785598350999473739L;

    private int rowCount;

    private List<CusMessagingHistoryListLineBean> allDataList;

    private ApplicationLogger applicationLogger = new ApplicationLogger();

    public CusMessagingPaginationController(int rowCount, List<CusMessagingHistoryListLineBean> allDataList) {
        this.rowCount = rowCount;
        this.allDataList = allDataList;
    }

    @Override
    public Object getRowKey(CusMessagingHistoryListLineBean appListLineBean) {
        return appListLineBean.getChatMessageId();
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public List<CusMessagingHistoryListLineBean> load(int first, int pageSize, String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {

        applicationLogger.log("Index info search pagination process started.", LogLevel.INFO);

        List<CusMessagingHistoryListLineBean> resultList = new ArrayList<CusMessagingHistoryListLineBean>();
        int endIndex = first + pageSize;

        if (endIndex > allDataList.size()) {
            endIndex = allDataList.size();
        }

        if (sortField != null) {
            Collections.sort(allDataList, new CusMessagingHistoryListLazySorter(sortField, sortOrder));
        }

        resultList = allDataList.subList(first, endIndex);

        applicationLogger.log("Index info search pagination process finished.", LogLevel.INFO);
        return resultList;

    }
}
