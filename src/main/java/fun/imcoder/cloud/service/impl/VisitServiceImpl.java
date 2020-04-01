package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.VisitMapper;
import fun.imcoder.cloud.model.Visit;
import fun.imcoder.cloud.service.VisitService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VisitServiceImpl extends BaseServiceImpl<VisitMapper, Visit> implements VisitService {
    @Override
    public Map<String, Object> count7Day() {
        Map<String, Object> rtn = new HashMap<>();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(6);
        List<Map<String, Object>> count7DayPVList = this.baseMapper.count7Day(startDate.toString(), endDate.toString(), "PV");
        List<Map<String, Object>> count7DayUVList = this.baseMapper.count7Day(startDate.toString(), endDate.toString(), "UV");
        List<Map<String, Object>> count7DayIPList = this.baseMapper.count7DayIP(startDate.toString(), endDate.toString());
        rtn.put("count7DayPVList", count7DayPVList);
        rtn.put("count7DayUVList", count7DayUVList);
        rtn.put("count7DayIPList", count7DayIPList);
        return rtn;
    }

    @Override
    public List<Map<String, Object>> terminalCount() {
        return this.baseMapper.terminalCount();
    }

    @Override
    public List<Map<String, Object>> oSCount() {
        LocalDate today = LocalDate.now();
        return this.baseMapper.oSCount(today.toString());
    }

    @Override
    public Map<String, Object> countVisit() {
        Map<String, Object> rtnMap = new HashMap<>();
        LocalDate today = LocalDate.now();
        Map<String, Object> todayPV = this.baseMapper.countDayVisit(today.toString(), "PV");
        Map<String, Object> todayUV = this.baseMapper.countDayVisit(today.toString(), "UV");
        Map<String, Object> totalPV = this.baseMapper.countTotalVisit("PV");
        Map<String, Object> totalUV = this.baseMapper.countTotalVisit("UV");
        rtnMap.put("todayPV", todayPV.get("count"));
        rtnMap.put("todayUV", todayUV.get("count"));
        rtnMap.put("totalPV", totalPV.get("count"));
        rtnMap.put("totalUV", totalUV.get("count"));
        return rtnMap;
    }

    @Override
    public List<Map<String, Object>> countTodayCityVisit() {
        return this.baseMapper.countTodayCityVisit(LocalDate.now().toString());
    }
}
