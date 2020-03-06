package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.PostMapper;
import fun.imcoder.cloud.model.Post;
import fun.imcoder.cloud.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends BaseServiceImpl<PostMapper, Post> implements PostService {
}
