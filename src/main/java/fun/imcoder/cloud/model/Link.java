package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Link model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Link extends BaseModel {
    private Integer id;
    private String name;
    private String url;
    private String logo;
    private String description;
    private String team;
    private Integer priority;
}
