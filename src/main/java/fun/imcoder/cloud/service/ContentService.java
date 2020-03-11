package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.Content;

public interface ContentService extends BaseService<Content> {
    Boolean saveContent(Content content);
}
