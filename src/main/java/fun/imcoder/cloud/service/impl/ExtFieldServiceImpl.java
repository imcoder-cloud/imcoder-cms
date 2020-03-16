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
    public boolean saveBatch(Collection<ExtField> entityList) {
        entityList.forEach(extField -> {
            if (StringUtils.isEmpty(extField.getId())) {
                extField.setField(extField.getField()+"_"+extField.getType());
                this.baseMapper.addColumn(extField);
            }
            this.baseMapper.insert(extField);
        });
        return true;
    }

    @Override
    public boolean removeById(Serializable id) {
        ExtField extField = this.baseMapper.selectById(id);
        this.baseMapper.delColumn(extField);
        this.baseMapper.deleteById(id);
        return true;
    }
}
