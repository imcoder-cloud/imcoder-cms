package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.model.Banner;
import fun.imcoder.cloud.service.BannerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/banner")
public class BannerController extends BaseController<Banner, BannerService> {

}
