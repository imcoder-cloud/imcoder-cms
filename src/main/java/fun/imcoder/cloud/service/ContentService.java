package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Content;

public interface ContentService extends BaseService<Content> {
    Boolean saveContent(Content content) throws ImcoderException.PathAlreadyExists;

    Boolean updateContent(Content content) throws ImcoderException.PathAlreadyExists;

    Boolean addVisits(Content content);
}
