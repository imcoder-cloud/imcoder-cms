package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.RolePermission;

import java.util.List;

public interface RolePermissionService extends BaseService<RolePermission> {
    Boolean saveBatchRolePermission(List<RolePermission> list);
}
