package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.mapper.CategoryMapper;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.service.CategoryService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public Category saveCategory(Category category) throws ImcoderException.PathAlreadyExists {
        if (StringUtils.isEmpty(category.getPath())) {
            category.setPath(new Date().getTime() + "");
        }
        ImcoderUtils.pathMustUnique(this.baseMapper, category.getId(), category.getPath());
        this.baseMapper.insert(category);
        return category;
    }

    @Override
    public Category updateCategory(Category category) throws ImcoderException.PathAlreadyExists {
        if (StringUtils.isEmpty(category.getPath())) {
            category.setPath(new Date().getTime() + "");
        }
        ImcoderUtils.pathMustUnique(this.baseMapper, category.getId(), category.getPath());
        this.baseMapper.updateById(category);
        return category;
    }
}
