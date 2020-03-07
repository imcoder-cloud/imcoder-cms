package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Post model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Post extends BaseModel {
    private Integer id;
    private String title;
    private String status;
    private String url;
    private String originalContent;
    private String formatContent;
    private String editorType;
    private String summary;
    private String keyword;
    private String thumbnail;
    private Integer visits;
    private Integer disallowComment;
    private String password;
    private String template;
    private Integer top;
    private Integer createFrom;
    private Integer likes;
    private String editTime;
}
