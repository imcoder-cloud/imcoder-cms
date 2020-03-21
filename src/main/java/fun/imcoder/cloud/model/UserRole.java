package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class UserRole extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer roleId;
}
