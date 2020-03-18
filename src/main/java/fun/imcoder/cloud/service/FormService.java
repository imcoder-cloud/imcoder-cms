package fun.imcoder.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.common.PageRequest;
import fun.imcoder.cloud.model.Form;

import java.util.Map;

public interface FormService extends BaseService<Form> {

    Form saveForm(Form form) throws Exception;

    Form updateForm(Form form) throws Exception;

    IPage<Map<String, Object>> getFormData(PageRequest<Form> pageRequest);
}
