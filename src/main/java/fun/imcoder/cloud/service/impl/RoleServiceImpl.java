package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.RoleMapper;
import fun.imcoder.cloud.mapper.RolePermissionMapper;
import fun.imcoder.cloud.model.Role;
import fun.imcoder.cloud.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public boolean removeById(Serializable id) {
        Map<String, Object> param = new HashMap<>();
        param.put("role_id", id);
        rolePermissionMapper.deleteByMap(param);
        this.baseMapper.deleteById(id);
        return true;
    }
}
