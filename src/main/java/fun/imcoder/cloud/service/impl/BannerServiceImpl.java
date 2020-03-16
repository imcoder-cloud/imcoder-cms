package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.BannerMapper;
import fun.imcoder.cloud.model.Banner;
import fun.imcoder.cloud.service.BannerService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BannerServiceImpl extends BaseServiceImpl<BannerMapper, Banner> implements BannerService {
    @Override
    public boolean saveBatch(Collection<Banner> entityList) {
        entityList.forEach(o -> {
            if (o.getGroupId() == 0) {
                QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
                queryWrapper.select("max(group_id) groupId");
                Banner banner = this.baseMapper.selectOne(queryWrapper);
                if (banner == null) {
                    o.setGroupId(1);
                } else {
                    o.setGroupId(banner.getGroupId() + 1);
                }
                this.baseMapper.insert(o);
            }
        });
        return true;
    }
}
