package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * PostCategory model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class CategoryContent extends BaseModel {
    private Integer id;
    private Integer categoryId;
    private Integer contentId;
}
