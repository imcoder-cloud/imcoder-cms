package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.model.FormField;
import fun.imcoder.cloud.service.FormFieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/formField")
public class FormFieldController extends BaseController<FormField, FormFieldService> {

}
