package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.model.RolePermission;
import fun.imcoder.cloud.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rolePermission")
public class RolePermissionController extends BaseController<RolePermission, RolePermissionService> {

    @PutMapping("/save")
    public ResponseData<Boolean> save(@RequestBody List<RolePermission> list) {
        return ResponseData.success(service.saveBatchRolePermission(list));
    }

}
