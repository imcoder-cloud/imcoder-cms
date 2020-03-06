package fun.imcoder.cloud.model;

import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
@Data
public class Visit extends BaseModel {
    private Integer id;
    private String ip;
    private String country;
    private String province;
    private String city;
    private String isp;
    private String os;
    private String browser;
    private String terminal;
    private String engine;
    private String uri;
    private String keyword;
    private String type;
}
