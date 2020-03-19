package fun.imcoder.cloud.mapper;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ContentExt;

import java.util.Map;

/**
 *
 * @Author cdd
 * @Date 2020-03-06
 */
public interface ContentExtMapper extends BaseMapper<ContentExt> {
    Map<String,String> getByContentId(Content content);
}
