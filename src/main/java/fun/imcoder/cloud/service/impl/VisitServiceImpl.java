package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.VisitMapper;
import fun.imcoder.cloud.model.Visit;
import fun.imcoder.cloud.service.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl extends BaseServiceImpl<VisitMapper, Visit> implements VisitService {
}
