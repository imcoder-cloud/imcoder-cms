package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Category model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Category extends BaseModel {
    private Integer id;
    private String name;
    private String alias;
    private String description;
    private String thumbnail;
    private Integer parentId;
    private Integer sort;
}
