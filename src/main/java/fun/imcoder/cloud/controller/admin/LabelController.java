package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.model.Label;
import fun.imcoder.cloud.service.LabelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/label")
public class LabelController extends BaseController<Label, LabelService> {

    @PostMapping("/save")
    public ResponseData<Label> save(@RequestBody Label label) throws Exception {
        service.saveLabel(label);
        return ResponseData.success(label);
    }

    @PutMapping("/update")
    public ResponseData<Label> modify(@RequestBody Label label) throws Exception {
        service.updateLabel(label);
        return ResponseData.success(label);
    }

}
