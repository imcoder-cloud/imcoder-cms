package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.common.PageRequest;
import fun.imcoder.cloud.mapper.FormMapper;
import fun.imcoder.cloud.model.Form;
import fun.imcoder.cloud.model.Label;
import fun.imcoder.cloud.service.FormService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FormServiceImpl extends BaseServiceImpl<FormMapper, Form> implements FormService {
    @Override
    public Form saveForm(Form form) throws Exception {
        form.setTableName("diy_" + form.getTableName());
        Map<String, Object> map = new HashMap<>();
        map.put("table_name", form.getTableName());
        List<Form> list = this.baseMapper.selectByMap(map);
        if (!list.isEmpty()) {
            throw new Exception("表[" + form.getTableName() + "]已经存在");
        } else {
            this.baseMapper.insert(form);
            this.baseMapper.createFormTable(form);
        }
        return form;
    }

    @Override
    public Form updateForm(Form form) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("table_name", form.getTableName());
        List<Form> list = this.baseMapper.selectByMap(map);
        if (!list.isEmpty()) {
            map.put("id", form.getId());
            list = this.baseMapper.selectByMap(map);
            if (list.isEmpty()) {
                throw new Exception("表[" + form.getTableName() + "]已经存在");
            }
        }
        this.baseMapper.updateById(form);
        return form;
    }

    @Override
    public IPage<Map<String, Object>> getFormData(PageRequest<Form> pageRequest) {
        Page page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Map<String, Object>> list = this.baseMapper.getFormData(page, pageRequest.getParams());
        return page.setRecords(list);
    }

    @SneakyThrows
    @Override
    public boolean removeById(Serializable id) {
        Form form = this.baseMapper.selectById(id);
        this.baseMapper.deleteById(id);
        this.baseMapper.dropFormTable(form);
        return true;
    }
}
