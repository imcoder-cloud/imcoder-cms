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
        Object data = getData(params, environment);
        // 把得到的值 wrap 输出前端
        TemplateModel templateModel = new BeansWrapperBuilder(Configuration.VERSION_2_3_28).build().wrap(data);
        // 若子类没有定义 则用默认key
        String attrKey = getAttrKey();
        environment.setVariable(attrKey != null ? attrKey : DEFAULT_KEY_IMCODER, templateModel);
        body.render(environment.getOut());
    }

    /**
     * 委派下去让子类实现，并且返回加工后的返回值
     * 可返回业务对象，或者集合
     *
     * @param params
     * @return
     */
    Object getData(Map params, Environment environment) throws TemplateModelException;

    /**
     * 获取modelAttr key
     *
     * @return
     */
    String getAttrKey();

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
