package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.OptionMapper;
import fun.imcoder.cloud.model.Option;
import fun.imcoder.cloud.service.OptionService;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl extends BaseServiceImpl<OptionMapper, Option> implements OptionService {
}
