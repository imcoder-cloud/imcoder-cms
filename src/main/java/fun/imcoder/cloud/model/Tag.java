package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Tag model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Tag extends BaseModel {
    private Integer id;
    private String name;
    private String alias;
    private String thumbnail;
}
