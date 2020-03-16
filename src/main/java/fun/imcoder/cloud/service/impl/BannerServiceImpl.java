package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.BannerMapper;
import fun.imcoder.cloud.model.Banner;
import fun.imcoder.cloud.service.BannerService;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl extends BaseServiceImpl<BannerMapper, Banner> implements BannerService {
}
