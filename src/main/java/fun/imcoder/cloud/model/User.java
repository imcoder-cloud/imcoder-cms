package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

import java.util.List;

@Data
public class User extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String avatar;
    private String description;

    @TableField(exist = false)
    private List<Integer> roleIds;
    @TableField(exist = false)
    private String roleIdStr;
    @TableField(exist = false)
    private String roleNames;
    @TableField(exist = false)
    private List<Permission> permissions;
}
