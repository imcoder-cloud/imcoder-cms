package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Category model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Category extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer parentId;
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    private String alias;
    private Integer sort;
    private Integer status;
    private String listPage;
    private String detailPage;
    private String path;
    private String outLink;
    private String icon;
    private String img;
    private String imgs;
    private Integer type;
    private Integer showChildren;
    private String keywords;
    private String description;
    private Integer userId;
    private String createSource;

    @TableField(exist = false)
    private List<Category> children;
    @TableField(exist = false)
    private List<Category> parentList;
    @TableField(exist = false)
    private Category top;
    @TableField(exist = false)
    private Category parent;
    @TableField(exist = false)
    private String[] multiImg;
    @TableField(exist = false)
    private String link;
    @TableField(exist = false)
    private Map<String, Object> extFields;
    @TableField(exist = false)
    private List<ExtField> extFieldList;

}
