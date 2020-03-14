package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * PostTag model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class ContentExt extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer contentId;
}
