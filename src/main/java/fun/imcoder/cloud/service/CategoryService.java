package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Category;

import java.util.List;

public interface CategoryService extends BaseService<Category> {

    Category saveCategory(Category category) throws ImcoderException.PathAlreadyExists;

    Category updateCategory(Category category) throws ImcoderException.PathAlreadyExists;

    List<Category> getParentList(Integer categoryId);

    List<Category> getChildrenList(Integer categoryId);

}
