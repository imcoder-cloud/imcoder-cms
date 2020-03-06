package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.MetaMapper;
import fun.imcoder.cloud.model.Meta;
import fun.imcoder.cloud.service.MetaService;
import org.springframework.stereotype.Service;

@Service
public class MetaServiceImpl extends BaseServiceImpl<MetaMapper, Meta> implements MetaService {
}
