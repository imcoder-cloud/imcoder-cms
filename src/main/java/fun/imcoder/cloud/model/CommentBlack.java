package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.*;

/**
 * CommentBlack model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class CommentBlack extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(condition = SqlCondition.LIKE)
    private String ip;
}
