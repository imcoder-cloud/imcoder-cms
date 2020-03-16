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
public class Banner extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer groupId;
    private String img;
    private String link;
    private String title;
    private String alias;
    private String description;
    private Integer sort;
}
