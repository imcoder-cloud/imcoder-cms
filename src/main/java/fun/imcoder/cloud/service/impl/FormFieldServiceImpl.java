package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.FormFieldMapper;
import fun.imcoder.cloud.model.FormField;
import fun.imcoder.cloud.service.FormFieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Collection;

@Service
@Transactional
public class FormFieldServiceImpl extends BaseServiceImpl<FormFieldMapper, FormField> implements FormFieldService {

    @Override
    public boolean saveBatch(Collection<FormField> entityList) {
        entityList.forEach(formField -> {
            if (StringUtils.isEmpty(formField.getId())) {
                this.baseMapper.addColumn(formField);
            }
            this.baseMapper.insert(formField);
        });
        return true;
    }

    @Override
    public boolean removeById(Serializable id) {
        FormField formField = this.baseMapper.selectById(id);
        this.baseMapper.delColumn(formField);
        this.baseMapper.deleteById(id);
        return true;
    }
}
