package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Category;

public interface CategoryService extends BaseService<Category> {

    Category saveCategory(Category category) throws ImcoderException.PathAlreadyExists;

    Category updateCategory(Category category) throws ImcoderException.PathAlreadyExists;

}
