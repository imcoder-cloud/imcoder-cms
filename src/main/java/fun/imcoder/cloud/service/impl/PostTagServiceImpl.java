package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.PostTagMapper;
import fun.imcoder.cloud.model.PostTag;
import fun.imcoder.cloud.service.PostTagService;
import org.springframework.stereotype.Service;

@Service
public class PostTagServiceImpl extends BaseServiceImpl<PostTagMapper, PostTag> implements PostTagService {
}
