package fun.imcoder.cloud.mapper;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.FormField;

import java.util.List;
import java.util.Map;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
public interface FormFieldMapper extends BaseMapper<FormField> {
    boolean addColumn(FormField params);

    boolean delColumn(FormField params);
}
