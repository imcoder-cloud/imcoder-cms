package fun.imcoder.cloud.controller.content;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.service.CategoryService;
import fun.imcoder.cloud.service.ContentService;
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
    private ContentService contentService;

    @GetMapping("/")
    public String content(Model model, HttpServletRequest request) {
        model.addAttribute("title", "coder的自我修养");
        Map<String, String> testMap = new HashMap<>();
        testMap.put("name", "imcoder");
        model.addAttribute("test", testMap);
        String uri = request.getRequestURI();
        if ("/".equals(uri)) {
            return "index";
        }
        return uri;
    }

    @GetMapping("/{path}")
    public String category(Model model, @PathVariable String path, HttpServletRequest request) {
        Category param = new Category();
        param.setPath(path);
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>(param);
        Category category = categoryService.getOne(queryWrapper);
        model.addAttribute("categoryId", category.getId());
        model.addAttribute("categoryName", category.getName());
        model.addAttribute("modelId", category.getModelId());
        return category.getListPage();
    }

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
        return content.getTemplate();
    }

}
