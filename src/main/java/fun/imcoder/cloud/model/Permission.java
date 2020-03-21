package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Permission model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Permission extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer parentId;
    private String path;
    private String enName;
    private String icon;
    private String component;
    private String type;
    private Integer sort;
    private Integer fixed;
    private Integer status;
    private String redirect;

    @TableField(exist = false)
    private List<Permission> children;
    @TableField(exist = false)
    private Map<String, Options> meta;
}
