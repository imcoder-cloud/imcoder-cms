package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.mapper.CategoryExtMapper;
import fun.imcoder.cloud.mapper.CategoryMapper;
import fun.imcoder.cloud.mapper.ExtFieldMapper;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.CategoryExt;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ExtField;
import fun.imcoder.cloud.service.CategoryService;
import fun.imcoder.cloud.service.ExtFieldService;
import fun.imcoder.cloud.utils.BeanUtils;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private ExtFieldMapper extFieldMapper;
    @Resource
    private ExtFieldService extFieldService;
    @Resource
    private CategoryExtMapper categoryExtMapper;

    @Override
    public Category saveCategory(Category category) throws Exception {
        replaceKeywords(category);
        if (StringUtils.isEmpty(category.getPath())) {
            category.setPath(new Date().getTime() + "");
        }
        ImcoderUtils.pathMustUnique(this.baseMapper, category.getId(), category.getPath());
        this.baseMapper.insert(category);

        setExtInfo(category, false);
        return category;
    }

    @Override
    public Category updateCategory(Category category) throws ImcoderException.PathAlreadyExists {
        replaceKeywords(category);
        if (StringUtils.isEmpty(category.getPath())) {
            category.setPath(new Date().getTime() + "");
        }
        ImcoderUtils.pathMustUnique(this.baseMapper, category.getId(), category.getPath());
        this.baseMapper.updateById(category);

        setExtInfo(category, true);

        return category;
    }

    @Override
    public List<Category> getParentList(Integer categoryId) {
        return this.baseMapper.getParentList(categoryId);
    }

    @Override
    public List<Category> getChildrenList(Integer categoryId) {
        return this.baseMapper.getChildrenList(categoryId);
    }

    private void replaceKeywords(Category category) {
        if (category.getKeywords() != null) {
            category.setKeywords(category.getKeywords().replaceAll("，", ","));
        }
    }

    @Override
    public boolean removeById(Serializable id) {
        Map<String, Object> params = new HashMap<>();
        params.put("category_id", id);
        List<ExtField> list = extFieldMapper.selectByMap(params);
        list.forEach(o -> extFieldMapper.delCategoryColumn(o));
        extFieldMapper.deleteByMap(params);
        categoryExtMapper.deleteByMap(params);
        return SqlHelper.retBool(this.baseMapper.deleteById(id));
    }

    private boolean setExtInfo(Category category, boolean ifDel) {
        List<ExtField> list = category.getExtFieldList();
        if (list != null && !list.isEmpty()) {
            list.forEach(o -> {
                o.setCategoryId(category.getId());
                if (ifDel) {
                    extFieldMapper.delCategoryColumn(o);
                }
                extFieldMapper.addCategoryColumn(o);
            });
            if (ifDel) {
                Map<String, Object> params = new HashMap<>();
                params.put("category_id", category.getId());
                extFieldMapper.deleteByMap(params);
            }
            extFieldService.saveBatch(list);
            // 新增
            if (!ifDel) {
                this.insertExt(category);
            }
            this.updateExt(category);
        }
        return true;
    }

    private boolean insertExt(Category category) {
        Map<String, Object> contentExt = new HashMap<>();
        contentExt.put("categoryId", category.getId());
        return this.baseMapper.insertExt(contentExt);
    }

    private boolean updateExt(Category category) {
        Map<String, Object> contentExt = new HashMap<>();
        Map<String, Object> extFields = category.getExtFields();
        extFields.keySet().removeIf(key -> key.equals("create_time") || key.equals("modify_time") || key.equals("id"));
        contentExt.put("categoryId", category.getId());
        contentExt.put("fields", extFields);
        return this.baseMapper.updateExt(contentExt);
    }

    @Override
    public Category getById(Serializable id) {
        Map<String, Object> params = new HashMap<>();
        params.put("category_id", id);
        Category category = this.baseMapper.selectById(id);
        List<ExtField> extList = extFieldMapper.selectByMap(params);
        category.setExtFieldList(extList);
        Map<String, Object> extMap = this.baseMapper.getExtByCategoryId(params);
        category.setExtFields(extMap);
        return category;
    }
}
