package fun.imcoder.cloud.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.common.PageRequest;
import fun.imcoder.cloud.model.Category;
import org.apache.ibatis.annotations.Param;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
public interface CategoryMapper extends BaseMapper<Category> {
}
