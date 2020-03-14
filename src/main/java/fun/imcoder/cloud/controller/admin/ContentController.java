package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.service.ContentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/content")
public class ContentController extends BaseController<Content, ContentService> {

    @PostMapping("/save")
    private ResponseData save(@RequestBody Content content) throws ImcoderException.PathAlreadyExists {
        return ResponseData.success(service.saveContent(content));
    }

    @PutMapping("/update")
    private ResponseData update(@RequestBody Content content) throws ImcoderException.PathAlreadyExists {
        return ResponseData.success(service.updateContent(content));
    }

}
