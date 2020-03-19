package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ContentExt;

import java.util.Map;

public interface ContentExtService extends BaseService<ContentExt> {
    Map<String,String> getByContentId(Content content);
}
