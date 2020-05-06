package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.model.ExtField;
import fun.imcoder.cloud.service.ExtFieldService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/extField")
public class ExtFieldController extends BaseController<ExtField, ExtFieldService> {

    @GetMapping("/getByCategoryIds")
    private ResponseData extFields(@RequestParam String categoryIds, @RequestParam String struct) {
        QueryWrapper<ExtField> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_id", categoryIds.split(","));
        queryWrapper.eq("struct", struct);
        return ResponseData.success(service.list(queryWrapper));
    }

    @DeleteMapping("/delete")
    private ResponseData<Boolean> deleteExtField(@RequestBody ExtField extField) {
        return ResponseData.success(service.deleteExtField(extField));
    }

}
