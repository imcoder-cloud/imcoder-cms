package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Meta model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Meta extends BaseModel {
    private Integer id;
    private Integer postId;
    private String key;
    private String value;
}
