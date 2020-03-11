package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.ModelMapper;
import fun.imcoder.cloud.model.Model;
import fun.imcoder.cloud.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl extends BaseServiceImpl<ModelMapper, Model> implements ModelService {
}
