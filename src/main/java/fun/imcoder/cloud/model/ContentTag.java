package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * PostTag model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class ContentTag extends BaseModel {
    private Integer id;
    private Integer contentId;
    private Integer tagId;
}
