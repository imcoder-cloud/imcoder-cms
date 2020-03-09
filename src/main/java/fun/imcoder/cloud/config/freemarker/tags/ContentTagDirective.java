package fun.imcoder.cloud.config.freemarker.tags;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import freemarker.core.Environment;
import freemarker.template.TemplateModelException;
import fun.imcoder.cloud.annotation.FreemarkerTag;
import fun.imcoder.cloud.model.CategoryContent;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.service.CategoryContentService;
import fun.imcoder.cloud.service.ContentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@FreemarkerTag("content")
public class ContentTagDirective implements ImcoderFreemarkerTag {
    @Resource
    private ContentService contentService;
    @Resource
    private CategoryContentService categoryContentService;

    @Override
    public Object getData(int page, int size, Map params, Environment environment) throws TemplateModelException {
        Integer categoryId = Integer.valueOf(environment.__getitem__("categoryId").toString());
        CategoryContent cc = new CategoryContent();
        cc.setCategoryId(categoryId);
        QueryWrapper<CategoryContent> ccWrapper = new QueryWrapper<>(cc);
        List<CategoryContent> ccList = categoryContentService.list(ccWrapper);
        List<Integer> contentIds = ccList.stream().map(CategoryContent::getContentId).collect(Collectors.toList());
        Content content = new Content();
        QueryWrapper<Content> queryWrapper = new QueryWrapper<>(content);
        queryWrapper.in("id",contentIds);
        Page<Content> p = new Page<>();
        p.setSize(size);
        p.setCurrent(page);
        return contentService.page(p, queryWrapper);
    }

}
