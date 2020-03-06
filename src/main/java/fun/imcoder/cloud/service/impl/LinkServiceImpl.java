package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.LinkMapper;
import fun.imcoder.cloud.model.Link;
import fun.imcoder.cloud.service.LinkService;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl extends BaseServiceImpl<LinkMapper, Link> implements LinkService {
}
