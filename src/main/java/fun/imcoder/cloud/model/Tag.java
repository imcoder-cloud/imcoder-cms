package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Tag model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Tag extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    private String alias;
    private String path;
    private String page;
    private String icon;
    private Integer userId;
    private String createSource;
}
