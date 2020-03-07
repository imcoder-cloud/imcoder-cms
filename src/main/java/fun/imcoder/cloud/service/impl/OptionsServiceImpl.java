package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.OptionsMapper;
import fun.imcoder.cloud.model.Options;
import fun.imcoder.cloud.service.OptionsService;
import org.springframework.stereotype.Service;

@Service
public class OptionsServiceImpl extends BaseServiceImpl<OptionsMapper, Options> implements OptionsService {
}
