package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Content model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Content extends BaseModel {
    @TableId
    private Integer id;
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
    private String template;
    private String keywords;
    private String description;
    private String thumbnail;
    private Integer visits;
    private Integer status;
    private String password;
    private Integer top;
    private Integer recommend;
    private Integer likes;
    private String editTime;

    @TableField(exist = false)
    private Integer categoryId;
}
