package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.UserMapper;
import fun.imcoder.cloud.mapper.UserRoleMapper;
import fun.imcoder.cloud.model.FormField;
import fun.imcoder.cloud.model.Permission;
import fun.imcoder.cloud.model.User;
import fun.imcoder.cloud.model.UserRole;
import fun.imcoder.cloud.service.UserRoleService;
import fun.imcoder.cloud.service.UserService;
import fun.imcoder.cloud.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserRoleService userRoleService;
    @Resource
    private UserRoleMapper userRoleMapper;

    public boolean save(User entity) {
        if (entity.getId() != null) {
            Map<String, Object> param = new HashMap<>();
            param.put("user_id", entity.getId());
            userRoleMapper.deleteByMap(param);
            this.baseMapper.updateById(entity);
        } else {
            // 默认密码123456
            entity.setPassword(MD5Utils.md5Str("123456"));
            this.baseMapper.insert(entity);
        }
        List<Integer> roleIds = entity.getRoleIds();
        List<UserRole> urList = new ArrayList<>();
        roleIds.forEach(o -> {
            UserRole ur = new UserRole();
            ur.setUserId(entity.getId());
            ur.setRoleId(o);
            ur.setUserId(entity.getId());
            urList.add(ur);
        });
        userRoleService.saveBatch(urList);
        return true;
    }

    @Override
    public boolean removeById(Serializable id) {
        Map<String, Object> param = new HashMap<>();
        param.put("user_id", id);
        userRoleMapper.deleteByMap(param);
        this.baseMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Permission> getPermission(User user) {
        return this.baseMapper.getPermission(user);
    }
}
