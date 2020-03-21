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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
