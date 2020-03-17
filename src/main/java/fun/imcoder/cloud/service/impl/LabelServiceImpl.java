package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import freemarker.template.TemplateModelException;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.mapper.LabelMapper;
import fun.imcoder.cloud.model.Label;
import fun.imcoder.cloud.service.LabelService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LabelServiceImpl extends BaseServiceImpl<LabelMapper, Label> implements LabelService {

    @Resource
    private freemarker.template.Configuration configuration;

    @Override
    public Label saveLabel(Label label) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("field", label.getField());
        List<Label> list = this.baseMapper.selectByMap(map);
        if (!list.isEmpty()) {
            throw new Exception("字段[" + label.getField() + "]已经存在");
        } else {
            this.baseMapper.insert(label);
        }
        setTemplateLabels();
        return label;
    }

    @Override
    public Label updateLabel(Label label) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("field", label.getField());
        List<Label> list = this.baseMapper.selectByMap(map);
        if (!list.isEmpty()) {
            map.put("id", label.getId());
            list = this.baseMapper.selectByMap(map);
            if (list.isEmpty()) {
                throw new Exception("字段[" + label.getField() + "]已经存在");
            }
        }
        this.baseMapper.updateById(label);
        setTemplateLabels();
        return label;
    }

    @SneakyThrows
    @Override
    public boolean removeById(Serializable id) {
        this.baseMapper.deleteById(id);
        setTemplateLabels();
        return true;
    }

    private void setTemplateLabels() throws TemplateModelException {
        List<Label> labels = this.baseMapper.selectList(new QueryWrapper<>());
        ImcoderConfig.labels = labels.stream().collect(Collectors.toMap(Label::getField, Label::getValue));
        configuration.setSharedVariable("labels", ImcoderConfig.labels);
    }
}
