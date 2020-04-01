package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.imcoder.cloud.annotation.ModelParam;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.PageRequest;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.enums.ModelParamType;
import fun.imcoder.cloud.model.Visit;
import fun.imcoder.cloud.service.VisitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/visit")
public class VisitController extends BaseController<Visit, VisitService> {

    @Override
    public ResponseData<IPage<Visit>> page(@ModelParam(ModelParamType.PAGE) PageRequest<Visit> pageRequest) {
        Page<Visit> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        QueryWrapper<Visit> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(pageRequest.getParams().getOrder());
        Visit visit = pageRequest.getParams();
        queryWrapper.setEntity(pageRequest.getParams());
        queryWrapper.gt("create_time", visit.getStartDate());
        queryWrapper.lt("create_time", visit.getEndDate() + " 23:59:59");
        IPage rtn = service.page(page, queryWrapper);
        return ResponseData.success(rtn);
    }

    @GetMapping("/count7Day")
    @ApiOperation("访问统计")
    public ResponseData<Map<String, Object>> count7Day() {
        return ResponseData.success(service.count7Day());
    }

    @GetMapping("/terminalCount")
    @ApiOperation("终端统计")
    public ResponseData<List<Map<String, Object>>> terminalCount() {
        return ResponseData.success(service.terminalCount());
    }

    @GetMapping("/countVisit")
    @ApiOperation("浏览量、访问量统计")
    public ResponseData<Map<String, Object>> countVisit() {
        return ResponseData.success(service.countVisit());
    }

    @GetMapping("/countTodayCityVisit")
    @ApiOperation("今日访问城市来源")
    public ResponseData<List<Map<String, Object>>> countTodayCityVisit() {
        return ResponseData.success(service.countTodayCityVisit());
    }

    @GetMapping("/countOS")
    @ApiOperation("今日系统访问来源")
    public ResponseData<List<Map<String, Object>>> countOS() {
        return ResponseData.success(service.oSCount());
    }

}
