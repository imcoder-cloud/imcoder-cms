package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Attachment model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class ExtField extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    private String field;
    private Integer categoryId;
    private String value;
    private String type;
    private String size;
    private String description;
    private String struct;
    private Integer sort;

    @TableField(exist = false)
    private String categoryName;
}
