package fun.imcoder.cloud.mapper;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.CategoryExt;

import java.util.Map;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
public interface CategoryExtMapper extends BaseMapper<CategoryExt> {
    Map<String, String> getByCategoryId(Category Category);
}
