package fun.imcoder.cloud.controller;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.model.User;
import fun.imcoder.cloud.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, UserService> {

}
