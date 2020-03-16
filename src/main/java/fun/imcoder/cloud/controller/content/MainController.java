package fun.imcoder.cloud.controller.content;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.Tag;
import fun.imcoder.cloud.service.CategoryService;
import fun.imcoder.cloud.service.ContentService;
import fun.imcoder.cloud.service.TagService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class MainController {

    @Resource
    private CategoryService categoryService;
    @Resource
    private TagService tagService;
    @Resource
    private ContentService contentService;

    @GetMapping("/")
    public String content(Model model) {
        return ImcoderUtils.renderTemplate("index");
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin/index";
    }

    /**
     * 所有栏目分类
     * 模板为 categories.html
     *
     * @param model
     * @return
     */
    @GetMapping("/categories")
    public String categories(Model model) {
        return ImcoderUtils.renderTemplate("categories");
    }

    /**
     * 所有标签
     * 模板为 tags.html
     *
     * @param model
     * @return
     */
    @GetMapping("/tags")
    public String tags(Model model) {
        return ImcoderUtils.renderTemplate("tags");
    }

    /**
     * 栏目内容
     *
     * @param model
     * @param path
     * @return
     */
    @GetMapping("/categories/{path}")
    public String category(Model model, @PathVariable String path) {
        Category param = new Category();
        param.setPath(path);
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>(param);
        Category category = categoryService.getOne(queryWrapper);
        model.addAttribute("categoryId", category.getId());
        model.addAttribute("categoryName", category.getName());
        return ImcoderUtils.renderTemplate(category.getListPage());
    }

    /**
     * 标签内容
     *
     * @param model
     * @param path
     * @return
     */
    @GetMapping("/tags/{path}")
    public String tag(Model model, @PathVariable String path) {
        Tag param = new Tag();
        param.setPath(path);
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>(param);
        Tag tag = tagService.getOne(queryWrapper);
        model.addAttribute("tagId", tag.getId());
        model.addAttribute("tagName", tag.getName());
        return ImcoderUtils.renderTemplate(tag.getPage());
    }

    /**
     * 归档内容
     *
     * @param model
     * @param path
     * @return
     * @throws IllegalAccessException
     */
    @GetMapping("/archives/{path}")
    public String archives(Model model, @PathVariable String path) throws IllegalAccessException {
        Content param = new Content();
        param.setPath(path);
        QueryWrapper<Content> queryWrapper = new QueryWrapper<>(param);
        Content content = contentService.getOne(queryWrapper);
        for (Field field : content.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            model.addAttribute(field.getName(), field.get(content));
        }
        return ImcoderUtils.renderTemplate(content.getPage());
    }

}
