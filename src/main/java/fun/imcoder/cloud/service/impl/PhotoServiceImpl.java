package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.PhotoMapper;
import fun.imcoder.cloud.model.Photo;
import fun.imcoder.cloud.service.PhotoService;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl extends BaseServiceImpl<PhotoMapper, Photo> implements PhotoService {
}
