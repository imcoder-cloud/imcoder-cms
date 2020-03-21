package fun.imcoder.cloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import fun.imcoder.cloud.base.BaseModel;
import lombok.Data;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
@Data
public class Visit extends BaseModel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(condition = SqlCondition.LIKE)
    private String ip;
    private String country;
    @TableField(condition = SqlCondition.LIKE)
    private String province;
    @TableField(condition = SqlCondition.LIKE)
    private String city;
    private String isp;
    private String os;
    private String browser;
    private String terminal;
    private String source;
    private String url;
    private String keyword;
    private String type;

    @TableField(exist = false)
    private String startDate;
    @TableField(exist = false)
    private String endDate;
}
