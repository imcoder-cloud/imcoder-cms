package fun.imcoder.cloud.config.freemarker.tags;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import freemarker.core.Environment;
import fun.imcoder.cloud.annotation.FreemarkerTag;
import fun.imcoder.cloud.model.Banner;
import fun.imcoder.cloud.service.BannerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
@FreemarkerTag("slide")
public class SlideTagDirective implements ImcoderFreemarkerTag {
    @Resource
    private BannerService bannerService;

    @Override
    public Object getData(int page, int size, Map params, Environment environment) {
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        String groupId = params.get("group") != null ? params.get("group").toString() : "1"; // 默认是导航
        queryWrapper.eq("group_id", groupId);
        queryWrapper.orderByAsc("sort");
        List<Banner> list = bannerService.list(queryWrapper);
        return list;
    }

}
