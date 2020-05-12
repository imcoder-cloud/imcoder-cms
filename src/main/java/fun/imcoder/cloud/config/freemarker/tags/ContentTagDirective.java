package fun.imcoder.cloud.config.freemarker.tags;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;
import fun.imcoder.cloud.annotation.FreemarkerTag;
import fun.imcoder.cloud.common.PageRequest;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.model.CategoryContent;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.service.CategoryContentService;
import fun.imcoder.cloud.service.ContentExtService;
import fun.imcoder.cloud.service.ContentService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FreemarkerTag("content")
public class ContentTagDirective implements ImcoderFreemarkerTag {
    @Resource
    private ContentService contentService;
    @Resource
    private ContentExtService contentExtService;

    @Override
    public Object getData(int page, int size, Map params, Environment environment) throws TemplateModelException {
        CategoryContent cc = new CategoryContent();
        Integer categoryId;
        QueryWrapper<CategoryContent> ccWrapper = new QueryWrapper<>(cc);
        if (getInt(params, "categoryId") != null) {
            categoryId = getInt(params, "categoryId");
        } else {
            categoryId = Integer.valueOf(environment.__getitem__("categoryId").toString());
        }
        Content content = new Content();
        content.setCategoryId(categoryId);
        if (!StringUtils.isEmpty(params.get("ext"))) {
            String extStr = params.get("ext").toString();
            Map<String, Object> map = JSON.parseObject(extStr, Map.class);
            content.setExtFields(map);
        }
        PageRequest<Content> pageRequest = new PageRequest<>();
        pageRequest.setPageNum(page);
        pageRequest.setPageSize(size);
        pageRequest.setParams(content);
        IPage<Content> result = contentService.customPage(pageRequest);
        List<Content> list = result.getRecords();
        list.forEach(o -> {
            o.setLink(ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_SITE_URL) + "/archives/" + o.getPath());
            if (params.get("showExtField") != null && getInt(params, "showExtField") == 1) {
                Map<String, Object> extMap = ImcoderUtils.setExtFields(null, contentService.findExtField(o), contentExtService.getByContentId(o));
                o.setExtFields(extMap);
            }
        });
//        try {
//            environment.__setitem__("page", result.getCurrent());
//            environment.__setitem__("size", result.getSize());
//            environment.__setitem__("totalSize", result.getTotal());
//            environment.__setitem__("totalPage", result.getPages());
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
        return result;
    }

}
