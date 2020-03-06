package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.LogMapper;
import fun.imcoder.cloud.model.Log;
import fun.imcoder.cloud.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends BaseServiceImpl<LogMapper, Log> implements LogService {
}
