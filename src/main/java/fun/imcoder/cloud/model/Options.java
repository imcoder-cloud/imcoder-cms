package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.*;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Option model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Options extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String optionKey;
    private String optionValue;
}
