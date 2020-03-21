package fun.imcoder.cloud.mapper;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.Permission;
import fun.imcoder.cloud.model.User;

import java.util.List;

/**
 *
 * @Author cdd
 * @Date 2020-03-06
 */
public interface UserMapper extends BaseMapper<User> {
    List<Permission> getPermission(User user);
}
