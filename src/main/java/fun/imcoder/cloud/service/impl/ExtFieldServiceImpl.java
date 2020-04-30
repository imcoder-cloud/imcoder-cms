package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.ExtFieldMapper;
import fun.imcoder.cloud.model.ExtField;
import fun.imcoder.cloud.service.ExtFieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Collection;

@Service
@Transactional
public class ExtFieldServiceImpl extends BaseServiceImpl<ExtFieldMapper, ExtField> implements ExtFieldService {

    @Override
    public boolean save(ExtField extField) {
        if (StringUtils.isEmpty(extField.getId())) {
            if ("content".equals(extField.getStruct())) {
                this.baseMapper.addContentColumn(extField);
            } else if ("category".equals(extField.getStruct())) {
                this.baseMapper.addCategoryColumn(extField);
            }
        }
        if (extField.getValue() != null) {
            extField.setValue(extField.getValue().replaceAll("，", ","));
        }
        this.baseMapper.insert(extField);
        return true;
    }

    @Override
    public boolean removeById(Serializable id) {
        ExtField extField = this.baseMapper.selectById(id);
        if ("content".equals(extField.getStruct())) {
            this.baseMapper.delContentColumn(extField);
        } else if ("category".equals(extField.getStruct())) {
            this.baseMapper.delCategoryColumn(extField);
        }
        this.baseMapper.deleteById(id);
        return true;
    }
}
