package fun.imcoder.cloud.mapper;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.Visit;

import java.util.List;
import java.util.Map;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
public interface VisitMapper extends BaseMapper<Visit> {
    List<Map<String, Object>> count7Day(String startDate, String endDate, String type);

    List<Map<String, Object>> count7DayIP(String startDate, String endDate);

    List<Map<String, Object>> terminalCount();

    List<Map<String, Object>> oSCount(String date);

    Map<String, Object> countTotalVisit(String type);

    Map<String, Object> countDayVisit(String date, String type);

    List<Map<String, Object>> countTodayCityVisit(String date);
}
