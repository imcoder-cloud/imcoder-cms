package fun.imcoder.cloud.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.common.PageRequest;
import fun.imcoder.cloud.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> getParentList(Integer categoryId);

    List<Category> getChildrenList(Integer categoryId);

    Boolean insertExt(Map<String, Object> map);

    Boolean updateExt(Map<String, Object> map);

    Map getExtByCategoryId(Map<String, Object> map);
}
