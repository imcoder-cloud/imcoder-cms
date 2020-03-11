package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.service.ContentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/content")
public class ContentController extends BaseController<Content, ContentService> {

    @PostMapping("/save")
    private ResponseData save(@RequestBody Content content) {
        return ResponseData.success(service.saveContent(content));
    }

}
