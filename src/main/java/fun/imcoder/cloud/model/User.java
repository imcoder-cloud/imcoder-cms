package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

@Data
public class User extends BaseModel {
    private Integer userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String avatar;
    private String description;
}
