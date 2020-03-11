package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Meta model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Meta extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer contentId;
    @TableField(condition = SqlCondition.LIKE)
    private String key;
    private String value;
}
