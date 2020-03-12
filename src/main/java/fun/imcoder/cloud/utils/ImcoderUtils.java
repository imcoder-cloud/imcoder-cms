package fun.imcoder.cloud.utils;

import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.model.Category;

import java.util.ArrayList;
import java.util.List;

public class ImcoderUtils {

    /**
     * @param list
     * @param parentId
     * @return
     * @desc 将List转为树状结构
     * @author chendongdong
     * 2020年03月09日
     */
    public static List<Category> convertToTree(List<Category> list, Integer parentId) {
        List<Category> rtnList = new ArrayList<>();
        List<Category> temp;
        for (Category o : list) {
            if (parentId.equals(o.getParentId())) {
                temp = convertToTree(list, o.getId());
                if (temp.size() > 0) {
                    o.setChildren(temp);
                }
                rtnList.add(o);
            }
        }
        return rtnList;
    }

    /**
     * 渲染模板
     * cdd
     *
     * @param path
     * @return
     */
    public static String renderTemplate(String path) {
        return ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE) + "/" + path;
    }
}
