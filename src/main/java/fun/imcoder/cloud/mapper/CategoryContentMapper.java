package fun.imcoder.cloud.mapper;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.CategoryContent;

import java.util.List;

/**
 *
 * @Author cdd
 * @Date 2020-03-06
 */
public interface CategoryContentMapper extends BaseMapper<CategoryContent> {

    List<CategoryContent> getByParentCategoryId(Integer categoryId);

}
