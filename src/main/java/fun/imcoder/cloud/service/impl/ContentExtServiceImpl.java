package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.ContentExtMapper;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ContentExt;
import fun.imcoder.cloud.service.ContentExtService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ContentExtServiceImpl extends BaseServiceImpl<ContentExtMapper, ContentExt> implements ContentExtService {
    @Override
    public Map<String, String> getByContentId(Content content) {
        return this.baseMapper.getByContentId(content);
    }
}
