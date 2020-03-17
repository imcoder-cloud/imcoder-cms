package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.mapper.OptionsMapper;
import fun.imcoder.cloud.mapper.TemplateMapper;
import fun.imcoder.cloud.model.Options;
import fun.imcoder.cloud.model.Template;
import fun.imcoder.cloud.service.OptionsService;
import fun.imcoder.cloud.service.TemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TemplateServiceImpl extends BaseServiceImpl<TemplateMapper, Template> implements TemplateService {
    @Resource
    private OptionsService optionsService;

    @Override
    @Transactional
    public void setActive(Template template) {
        UpdateWrapper<Template> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("active", 0);
        Template t = new Template();
        this.baseMapper.update(t, updateWrapper);
        Template template1 = new Template();
        template1.setId(template.getId());
        template1.setActive(1);
        this.baseMapper.updateById(template1);
        Options options = new Options();
        options.setOptionKey(ImcoderConfig.OPTIONS_KEY_TEMPLATE);
        UpdateWrapper<Options> optionsUpdateWrapper = new UpdateWrapper<>(options);
        optionsUpdateWrapper.set("option_value", template.getName());
        optionsService.update(optionsUpdateWrapper);
        ImcoderConfig.options.put(ImcoderConfig.OPTIONS_KEY_TEMPLATE, template.getName());
    }
}
