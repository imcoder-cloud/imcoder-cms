package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.annotation.ModelParam;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.Permission;
import fun.imcoder.cloud.service.PermissionService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/permission")
public class PermissionController extends BaseController<Permission, PermissionService> {

    @GetMapping("/tree")
    public ResponseData<List<Permission>> tree(@ModelParam Permission permission) {
        List<Permission> list = service.list(new QueryWrapper<>(permission));
        return ResponseData.success(ImcoderUtils.convertPermissionToTree(list, 0));
    }

}
