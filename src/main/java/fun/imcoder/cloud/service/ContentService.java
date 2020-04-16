package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ExtField;

import java.util.List;

public interface ContentService extends BaseService<Content> {
    Boolean saveContent(Content content) throws ImcoderException.PathAlreadyExists;

    Boolean updateContent(Content content) throws ImcoderException.PathAlreadyExists;

    Boolean addVisits(Content content);

    List<ExtField> findExtField(Content content);

    Content getPrevious(String editTime);

    Content getNext(String editTime);
}
