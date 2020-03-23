package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.CategoryContent;

import java.util.List;

public interface CategoryContentService extends BaseService<CategoryContent> {

    List<CategoryContent> getByParentCategoryId(Integer categoryId);

}
