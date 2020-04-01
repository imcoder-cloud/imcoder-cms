package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.Visit;

import java.util.List;
import java.util.Map;

public interface VisitService extends BaseService<Visit> {

    Map<String, Object> count7Day();

    List<Map<String, Object>> terminalCount();

    List<Map<String, Object>> oSCount();

    Map<String, Object> countVisit();

    List<Map<String, Object>> countTodayCityVisit();
}
