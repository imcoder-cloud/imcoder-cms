package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

@Data
public class User extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String avatar;
    private String description;
}
