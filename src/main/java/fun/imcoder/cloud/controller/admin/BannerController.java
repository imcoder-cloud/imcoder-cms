package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.model.Banner;
import fun.imcoder.cloud.service.BannerService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/admin/banner")
public class BannerController extends BaseController<Banner, BannerService> {

    @GetMapping("/group")
    public ResponseData<List<Banner>> group() {
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("group_id");
        queryWrapper.groupBy("group_id");
        List<Banner> list = service.list(queryWrapper);
        return ResponseData.success(list);
    }

}
