package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import fun.imcoder.cloud.annotation.ModelParam;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.PageRequest;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.enums.ModelParamType;
import fun.imcoder.cloud.model.Form;
import fun.imcoder.cloud.service.FormService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/form")
public class FormController extends BaseController<Form, FormService> {

    @PostMapping("/save")
    public ResponseData<Form> save(@RequestBody Form form) throws Exception {
        service.saveForm(form);
        return ResponseData.success(form);
    }

    @PutMapping("/update")
    public ResponseData<Form> update(@RequestBody Form form) throws Exception {
        service.updateForm(form);
        return ResponseData.success(form);
    }

    @GetMapping("/data")
    public ResponseData<IPage<Map<String,Object>>> getFormData(@ModelParam(ModelParamType.PAGE) PageRequest pageRequest) throws Exception {
        IPage<Map<String,Object>> list = service.getFormData(pageRequest);
        return ResponseData.success(list);
    }

}
