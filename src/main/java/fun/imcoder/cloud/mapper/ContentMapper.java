package fun.imcoder.cloud.mapper;

import fun.imcoder.cloud.base.BaseMapper;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ExtField;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author cdd
 * @Date 2020-03-06
 */
public interface ContentMapper extends BaseMapper<Content> {

    Content getById(Serializable id);

    Boolean insertContentExt(Map<String, Object> map);

    Boolean updateContentExt(Map<String, Object> map);

    Map getContentExtByContentId(Map<String, Object> map);

    List<ExtField> findExtField(Content content);

    Boolean addVisits(Content content);

    Content getPrevious(String editTime);

    Content getNext(String editTime);

}
