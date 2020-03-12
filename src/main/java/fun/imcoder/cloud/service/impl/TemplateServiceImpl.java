package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.TemplateMapper;
import fun.imcoder.cloud.model.Template;
import fun.imcoder.cloud.service.TemplateService;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl extends BaseServiceImpl<TemplateMapper, Template> implements TemplateService {
}
