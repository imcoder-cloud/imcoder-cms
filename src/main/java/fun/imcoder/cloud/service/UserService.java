package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.Permission;
import fun.imcoder.cloud.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<Permission> getPermission(User user);
}
