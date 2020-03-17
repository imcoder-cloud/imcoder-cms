package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import freemarker.template.TemplateModelException;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.mapper.OptionsMapper;
import fun.imcoder.cloud.model.Options;
import fun.imcoder.cloud.service.OptionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionsServiceImpl extends BaseServiceImpl<OptionsMapper, Options> implements OptionsService {
    @Resource
    private freemarker.template.Configuration configuration;
    @Override
    public Boolean save(List<Options> list) {
        this.baseMapper.delete(new QueryWrapper<>());
        this.saveBatch(list);
        ImcoderConfig.options = list.stream().collect(Collectors.toMap(Options::getOptionKey, Options::getOptionValue));
        try {
            // 更新freemarker模板变量
            configuration.setSharedVariable("options", ImcoderConfig.options);
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
        return true;
    }
}
