package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.CategoryExtMapper;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.CategoryExt;
import fun.imcoder.cloud.service.CategoryExtService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CategoryExtServiceImpl extends BaseServiceImpl<CategoryExtMapper, CategoryExt> implements CategoryExtService {
    @Override
    public Map<String, String> getByCategoryId(Category Category) {
        return this.baseMapper.getByCategoryId(Category);
    }
}
