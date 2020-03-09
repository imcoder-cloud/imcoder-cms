package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.ContentTagMapper;
import fun.imcoder.cloud.model.ContentTag;
import fun.imcoder.cloud.service.ContentTagService;
import org.springframework.stereotype.Service;

@Service
public class ContentTagServiceImpl extends BaseServiceImpl<ContentTagMapper, ContentTag> implements ContentTagService {
}
