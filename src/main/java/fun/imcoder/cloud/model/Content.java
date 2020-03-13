package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * Content model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Content extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(condition = SqlCondition.LIKE)
    private String title;
    private String summary;
    private String originalContent;
    private String formatContent;
    private String editorType;
    private String path;
    private String author;
    private String source;
    private Integer sort;
    private String outLink;
    private Integer comment;
    private String page;
    private String keywords;
    private String description;
    private String img;
    private Integer visits;
    private Integer status;
    private String password;
    private Integer top;
    private Integer recommend;
    private Integer likes;
    private String editTime;

    @TableField(exist = false)
    private Integer categoryId;
    @TableField(exist = false)
    private String categoryNames;
    @TableField(exist = false)
    private List<CategoryContent> categoryContents;
    @TableField(exist = false)
    private List<ContentTag> contentTags;
}
