package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.annotation.ModelParam;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.enums.ResponseEnum;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.Permission;
import fun.imcoder.cloud.model.User;
import fun.imcoder.cloud.service.UserService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import fun.imcoder.cloud.utils.MD5Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/user")
public class UserController extends BaseController<User, UserService> {
    @PostMapping("/save")
    private ResponseData save(@RequestBody User user) {
        return ResponseData.success(service.save(user));
    }

    /**
     * 暂时使用session登录
     *
     * @param user
     * @param request
     * @return
     */
    @GetMapping("/login")
    private ResponseData login(@ModelParam User user, HttpServletRequest request) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return ResponseData.error(ResponseEnum.USER_NOT_FOUND);
        }
        user.setPassword(MD5Utils.md5Str(user.getPassword()));
        QueryWrapper queryWrapper = new QueryWrapper(user);
        User res = this.service.getOne(queryWrapper);
        if (res == null) {
            return ResponseData.error(ResponseEnum.USER_NOT_FOUND);
        }
        String token = UUID.randomUUID().toString();
        request.getSession().setAttribute(token, res);
        request.getSession().setMaxInactiveInterval(60 * 60 * 24);
        return ResponseData.success(token);
    }

    @GetMapping("/permission")
    private ResponseData<List<Permission>> permission(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(token);
        List<Permission> permissionList = this.service.getPermission(user);
        List<Permission> MenuList = permissionList.stream().filter(permission -> "menu".equals(permission.getType()) && permission.getStatus() == 1).collect(Collectors.toList());
        user.setPermissions(permissionList);
        MenuList.forEach(m -> {
            if (m.getFixed() == 1) {
                m.setMeta(new HashMap() {{
                    put("fixed", true);
                }});
            }
        });
        return ResponseData.success(ImcoderUtils.convertPermissionToTree(MenuList, 0));
    }

    @GetMapping("/info")
    private ResponseData<User> info(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(token);
        return ResponseData.success(user);
    }
}
