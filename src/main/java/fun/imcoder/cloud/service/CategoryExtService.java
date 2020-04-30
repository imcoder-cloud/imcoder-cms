package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.CategoryExt;

import java.util.Map;

public interface CategoryExtService extends BaseService<CategoryExt> {
    Map<String,String> getByCategoryId(Category Category);
}
