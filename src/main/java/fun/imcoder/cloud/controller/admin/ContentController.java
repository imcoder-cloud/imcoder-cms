package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.User;
import fun.imcoder.cloud.service.ContentService;
import fun.imcoder.cloud.utils.AuthUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/admin/content")
public class ContentController extends BaseController<Content, ContentService> {

    @PostMapping("/save")
    private ResponseData save(@RequestBody Content content, HttpServletRequest request) throws ImcoderException.PathAlreadyExists {
        User user = AuthUtils.getUser(request);
        content.setUserId(user.getId());
        return ResponseData.success(service.saveContent(content));
    }

    @PutMapping("/update")
    private ResponseData modify(@RequestBody Content content) throws ImcoderException.PathAlreadyExists {
        return ResponseData.success(service.updateContent(content));
    }

}
