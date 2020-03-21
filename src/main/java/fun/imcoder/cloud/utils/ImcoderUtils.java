package fun.imcoder.cloud.utils;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.Permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE) + "/" + path;
    }

    /**
     * 访问路径必须唯一
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
}
