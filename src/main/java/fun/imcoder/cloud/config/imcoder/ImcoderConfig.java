package fun.imcoder.cloud.config.imcoder;

import java.util.HashMap;
import java.util.Map;

public class ImcoderConfig {

    // 所有配置选项
    public static Map<String, String> options = new HashMap<>();

    public final static String IMCODER_FOLDER = "imcoder";
    //    public final static String WORK_DIR = System.getProperties().getProperty("user.home") + "/" + IMCODER_FOLDER + "/";
    public final static String WORK_DIR = "file:///D:/imcoder/";
    public final static String TEMPLATES_FOLDER = "templates";
    public final static String TEMPLATES_DIR = WORK_DIR + TEMPLATES_FOLDER + "/";
    public final static String UPLOAD_FOLDER = "upload";
    public final static String UPLOAD_DIR = WORK_DIR + UPLOAD_FOLDER + "/";

    public final static String OPTIONS_KEY_TEMPLATE = "template";

}
