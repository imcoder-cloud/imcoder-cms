package fun.imcoder.cloud.config.imcoder;

import fun.imcoder.cloud.config.WebMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ImcoderConfig extends WebMvcConfig {

    public final static String AUTH_HEADER = "Authorization";

    // 所有配置选项
    public static Map<String, String> options = new HashMap<>();
    // 所有自定义标签
    public static Map<String, String> labels = new HashMap<>();

    public final static String IMCODER_FOLDER = "imcoder";
    //    public final static String WORK_DIR = System.getProperty("user.dir") + "/";
    public final static String WORK_DIR = "D:/imcoder/";
    public final static String TEMPLATES_FOLDER = "templates";
    public final static String TEMPLATES_DIR = WORK_DIR + TEMPLATES_FOLDER + "/";
    public final static String UPLOAD_FOLDER = "upload";
    public final static String UPLOAD_DIR = WORK_DIR + UPLOAD_FOLDER + "/";
    public final static String STATIC_FOLDER = "static";

    public final static String OPTIONS_KEY_TEMPLATE = "template";
    public final static String OPTIONS_KEY_SITE_URL = "site_url";
    public final static String OPTIONS_KEY_KEYWORDS = "keywords";


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String staticPath = "file:" + TEMPLATES_DIR + options.get(OPTIONS_KEY_TEMPLATE) + "/";
        registry.addResourceHandler("/" + UPLOAD_FOLDER + "/**", "/" + STATIC_FOLDER + "/**", "/**")
                .addResourceLocations("file:" + UPLOAD_DIR, staticPath + STATIC_FOLDER + "/", staticPath, "classpath:/admin/static/");
    }


}
