package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Tag;
import fun.imcoder.cloud.service.TagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/tag")
public class TagController extends BaseController<Tag, TagService> {

    @PostMapping("/save")
    private ResponseData<Tag> save(@RequestBody Tag tag) throws ImcoderException.PathAlreadyExists {
        return ResponseData.success(service.saveTag(tag));
    }

    @PutMapping("/update")
    private ResponseData<Tag> modify(@RequestBody Tag tag) throws ImcoderException.PathAlreadyExists {
        return ResponseData.success(service.updateTag(tag));
    }

}
