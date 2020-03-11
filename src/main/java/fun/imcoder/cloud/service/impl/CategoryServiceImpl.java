package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.CategoryMapper;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category> implements CategoryService {
}
