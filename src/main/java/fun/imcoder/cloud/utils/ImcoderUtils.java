package fun.imcoder.cloud.utils;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ExtField;
import fun.imcoder.cloud.model.Permission;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImcoderUtils {

    /**
     * @param list
     * @param parentId
     * @return
     * @desc 将分类栏目转为树状结构
     * @author chendongdong
     * 2020年03月09日
     */
    public static List<Category> convertCategoryToTree(List<Category> list, Integer parentId) {
        List<Category> rtnList = new ArrayList<>();
        List<Category> temp;
        for (Category o : list) {
            if (parentId.equals(o.getParentId())) {
                temp = convertCategoryToTree(list, o.getId());
                if (temp.size() > 0) {
                    o.setChildren(temp);
                }
                rtnList.add(o);
            }
        }
        return rtnList;
    }

    /**
     * @param list
     * @param parentId
     * @return
     * @desc 将权限转为树状结构
     * @author chendongdong
     * 2020年03月09日
     */
    public static List<Permission> convertPermissionToTree(List<Permission> list, Integer parentId) {
        List<Permission> rtnList = new ArrayList<>();
        List<Permission> temp;
        for (Permission o : list) {
            if (parentId.equals(o.getParentId())) {
                temp = convertPermissionToTree(list, o.getId());
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
        path = path.split("\\.html")[0];
        String template = ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE);
        return "default".equals(template) ? path : template + "/" + path;
    }

    /**
     * 访问路径必须唯一
     *
     * @param mapper
     * @param id
     * @param path
     * @param <T>
     * @throws ImcoderException.PathAlreadyExists
     */
    public static <T> void pathMustUnique(BaseMapper<T> mapper, Integer id, String path) throws ImcoderException.PathAlreadyExists {
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        List<T> list = mapper.selectByMap(map);
        if (!list.isEmpty()) {
            map.put("id", id);
            list = mapper.selectByMap(map);
            if (list.isEmpty()) {
                throw new ImcoderException.PathAlreadyExists("访问路径[" + path + "]已经存在");
            }
        }
    }

    public static Map<String, Object> setExtFields(Model model, List<ExtField> extList, Map<String, String> extFields) {
        Map<String, String> extMap = extList.stream().collect(Collectors.toMap(ExtField::getField, a -> a.getType(), (k1, k2) -> k1));
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
            if (model != null) {
                model.addAttribute("extFields", extFieldMap);
            }
        }
        return extFieldMap;
    }
}
