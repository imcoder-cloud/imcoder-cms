package fun.imcoder.cloud.config.freemarker.tags;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

public interface ImcoderFreemarkerTag extends TemplateDirectiveModel {
    String DEFAULT_KEY_IMCODER = "imcoder";

    @Override
    default void execute(Environment environment, Map params, TemplateModel[] model, TemplateDirectiveBody body) throws TemplateException, IOException {
        // 子类处理业务逻辑
        int page = params.get("page") != null ? getInt(params, "page") : 1;
        int size = params.get("size") != null ? getInt(params, "size") : 10;
        Object data = getData(page, size, params, environment);
        // 把得到的值 wrap 输出前端
        TemplateModel templateModel = new BeansWrapperBuilder(Configuration.VERSION_2_3_28).build().wrap(data);
        // 若没有定义返回key 则用默认key
        Object resultKey = params.get("result");
        environment.setVariable(resultKey != null ? resultKey.toString() : DEFAULT_KEY_IMCODER, templateModel);
        if (body != null) {
            body.render(environment.getOut());
        }
    }

    /**
     * 委派下去让子类实现，并且返回加工后的返回值
     * 可返回业务对象，或者集合
     *
     * @param params
     * @return
     */
    Object getData(int page, int size, Map params, Environment environment) throws TemplateModelException;

    /**
     * 获取 long 参数
     *
     * @param params 前端提交来的参数<Key,Value>
     * @param key    key
     * @return
     */
    default Long getLong(Map params, String key) {
        return new Long(getString(params, key));
    }

    /**
     * 获取 String 参数
     *
     * @param params 前端提交来的参数<Key,Value>
     * @param key    key
     * @return
     */
    default String getString(Map params, String key) {
        Object element = params.get(key);
        String value;
        if (element instanceof SimpleScalar) {
            value = ((SimpleScalar) element).getAsString();
        } else {
            value = element.toString();
        }
        return value;
    }

    /**
     * 获取 int 参数
     *
     * @param params 前端提交来的参数<Key,Value>
     * @param key    key
     * @return
     */
    default Integer getInt(Map params, String key) {
        return new Integer(getString(params, key));
    }
}
