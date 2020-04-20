package fun.imcoder.cloud.controller.content;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ExtField;
import fun.imcoder.cloud.model.Tag;
import fun.imcoder.cloud.service.CategoryService;
import fun.imcoder.cloud.service.ContentExtService;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class MainController {

    @Resource
    private CategoryService categoryService;
    @Resource
    private TagService tagService;
    @Resource
    private ContentService contentService;
    @Resource
    private ContentExtService contentExtService;

    @GetMapping("/")
    public String content(Model model) {
        return ImcoderUtils.renderTemplate("index");
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin/index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        return ImcoderUtils.renderTemplate("test");
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
        return ImcoderUtils.renderTemplate(category.getListPage() != null ? category.getListPage() : category.getDetailPage());
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
        param.setImgs(null);
        QueryWrapper<Content> queryWrapper = new QueryWrapper<>(param);
        contentService.addVisits(param);
        Content content = contentService.getOne(queryWrapper);
        Content pre = contentService.getPrevious(content.getEditTime());
        if (pre != null) {
            pre.setLink(ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_SITE_URL) + "/archives/" + pre.getPath());
        }
        Content next = contentService.getNext(content.getEditTime());
        if (next != null) {
            next.setLink(ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_SITE_URL) + "/archives/" + next.getPath());
        }
        content.setMultiImg(content.getImgs().split("\\|\\|"));
        for (Field field : content.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            model.addAttribute(field.getName(), field.get(content));
        }
        model.addAttribute("previous", pre);
        model.addAttribute("next", next);
        List<ExtField> extList = contentService.findExtField(content);
        Map<String, String> extMap = extList.stream().collect(Collectors.toMap(ExtField::getField, a -> a.getType(), (k1, k2) -> k1));
        Map<String, String> extFields = contentExtService.getByContentId(content);
        Map<String, Object> extFieldMap = new HashMap<>();
        if (extFields != null) {
            extFields.keySet().forEach(k -> {
                String type = extMap.get(k);
                if ("checkbox".equals(type) || "image".equals(type) || "file".equals(type)) {
                    extFieldMap.put(k, extFields.get(k).split("\\|\\|"));
                } else {
                    extFieldMap.put(k, extFields.get(k));
                }
            });
            model.addAttribute("extFields", extFieldMap);
        }
        return ImcoderUtils.renderTemplate(content.getPage().split("\\.")[0]);
    }

}
