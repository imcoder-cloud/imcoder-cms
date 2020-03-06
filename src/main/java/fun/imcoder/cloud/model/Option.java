package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Option model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Option extends BaseModel {
    private Integer id;
    private String key;
    private String value;
}
