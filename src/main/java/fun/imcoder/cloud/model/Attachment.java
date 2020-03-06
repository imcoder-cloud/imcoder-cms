package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * Attachment model
 *
 * @author cdd
 * @date 2020-03-06
 */
@Data
public class Attachment extends BaseModel {

    private Integer id;
    private String name;
    private String path;
    private String fileKey;
    private String thumbPath;
    private String mediaType;
    private String suffix;
    private Integer width;
    private Integer height;
    private Long size;

}
