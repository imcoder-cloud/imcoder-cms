package fun.imcoder.cloud.config.freemarker.tags;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import freemarker.core.Environment;
import freemarker.template.TemplateModelException;
import fun.imcoder.cloud.annotation.FreemarkerTag;
import fun.imcoder.cloud.model.Post;
import fun.imcoder.cloud.service.PostService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
@FreemarkerTag("post")
public class PostTagDirective implements ImcoderFreemarkerTag {
    @Resource
    private PostService postService;

    @Override
    public Object getData(Map params, Environment environment) throws TemplateModelException {
        Object obj = environment.__getitem__("test");
        Object res = null;
        String type = getString(params, "type");
        int page = getInt(params, "page");
        int size = getInt(params, "size");
        switch (type) {
            case "list":
                break;
            case "page":
                Page<Post> p = new Page<>();
                p.setSize(size);
                p.setCurrent(page);
                res = postService.page(p);
                break;
        }
        return res;
    }

    @Override
    public String getAttrKey() {
        return "postData";
    }
}
