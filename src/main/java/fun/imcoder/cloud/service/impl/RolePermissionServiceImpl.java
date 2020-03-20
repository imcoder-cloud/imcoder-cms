package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.RolePermissionMapper;
import fun.imcoder.cloud.model.RolePermission;
import fun.imcoder.cloud.service.RolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
    @Override
    public Boolean saveBatchRolePermission(List<RolePermission> list) {
        Integer roleId = list.get(0).getRoleId();
        Map<String, Object> params = new HashMap<>();
        params.put("role_id", roleId);
        this.baseMapper.deleteByMap(params);
        super.saveBatch(list);
        return true;
    }
}
