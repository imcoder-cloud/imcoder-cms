package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Photo model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Photo extends BaseModel {
    private Integer id;
    private String name;
    private String description;
    private String takeTime;
    private String location;
    private String thumbnail;
    private String url;
    private String team;
}
