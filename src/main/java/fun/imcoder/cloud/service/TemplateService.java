package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.Template;

public interface TemplateService extends BaseService<Template> {
    void setActive(Template template);
}
