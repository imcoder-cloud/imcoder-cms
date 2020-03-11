package fun.imcoder.cloud.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Log model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Log extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String logKey;
    private String content;
    private String ip;
}
