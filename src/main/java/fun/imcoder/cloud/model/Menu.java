package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Menu model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Menu extends BaseModel {
    private Integer id;
    private String name;
    private String url;
    private Integer priority;
    private String target;
    private String icon;
    private Integer parentId;
    private String team;
}
