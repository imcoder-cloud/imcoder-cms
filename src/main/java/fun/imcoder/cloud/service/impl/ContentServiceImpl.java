package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.ContentMapper;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.service.ContentService;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl extends BaseServiceImpl<ContentMapper, Content> implements ContentService {
}
