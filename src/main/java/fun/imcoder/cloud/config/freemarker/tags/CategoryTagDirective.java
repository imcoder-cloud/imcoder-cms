package fun.imcoder.cloud.config.freemarker.tags;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import freemarker.core.Environment;
import freemarker.template.TemplateModelException;
import fun.imcoder.cloud.annotation.FreemarkerTag;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.service.CategoryService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@FreemarkerTag("category")
public class CategoryTagDirective implements ImcoderFreemarkerTag {
    @Resource
    private CategoryService categoryService;

    @Override
    public Object getData(int page, int size, Map params, Environment environment) throws TemplateModelException {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        String type = params.get("type") != null ? params.get("type").toString() : "1"; // 默认是导航
        Integer parentId = 0;
        if (!StringUtils.isEmpty(params.get("parentId"))) {
            parentId = Integer.valueOf(params.get("parentId").toString());
            queryWrapper.eq("parent_id", parentId);
        }
        queryWrapper.eq("type", type);
        queryWrapper.eq("status", 1);
        queryWrapper.orderByAsc("sort");
        List<Category> list = categoryService.list(queryWrapper);
        list.forEach(category -> category.setLink(ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_SITE_URL) + "/" + category.getPath()));
        return ImcoderUtils.convertCategoryToTree(list, parentId);
    }

}
