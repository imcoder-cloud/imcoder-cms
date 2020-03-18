package fun.imcoder.cloud.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.Form;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
public interface FormMapper extends BaseMapper<Form> {
    Boolean createFormTable(Form form);

    Boolean dropFormTable(Form form);

    List<Map<String, Object>> getFormData(Page page, @Param("params") Form form);
}
