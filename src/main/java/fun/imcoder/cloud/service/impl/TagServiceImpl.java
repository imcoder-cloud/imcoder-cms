package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.TagMapper;
import fun.imcoder.cloud.model.Tag;
import fun.imcoder.cloud.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends BaseServiceImpl<TagMapper, Tag> implements TagService {
}
