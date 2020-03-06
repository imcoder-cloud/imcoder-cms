package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.PostCategoryMapper;
import fun.imcoder.cloud.model.PostCategory;
import fun.imcoder.cloud.service.PostCategoryService;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryServiceImpl extends BaseServiceImpl<PostCategoryMapper, PostCategory> implements PostCategoryService {
}
