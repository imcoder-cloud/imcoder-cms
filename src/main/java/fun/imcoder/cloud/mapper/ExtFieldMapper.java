package fun.imcoder.cloud.mapper;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.ExtField;

import java.util.List;
import java.util.Map;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
public interface ExtFieldMapper extends BaseMapper<ExtField> {
    boolean addCategoryColumn(ExtField params);

    boolean delCategoryColumn(ExtField params);

    boolean addContentColumn(ExtField params);

    boolean delContentColumn(ExtField params);

    List<Map<String, String>> getAllContentExt(Map<String, String> params);
}
