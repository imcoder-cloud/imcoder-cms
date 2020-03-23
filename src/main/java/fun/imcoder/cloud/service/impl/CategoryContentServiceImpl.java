package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.CategoryContentMapper;
import fun.imcoder.cloud.model.CategoryContent;
import fun.imcoder.cloud.service.CategoryContentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryContentServiceImpl extends BaseServiceImpl<CategoryContentMapper, CategoryContent> implements CategoryContentService {
    @Override
    public List<CategoryContent> getByParentCategoryId(Integer categoryId) {
        return this.baseMapper.getByParentCategoryId(categoryId);
    }
}
