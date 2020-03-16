package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Tag;

public interface TagService extends BaseService<Tag> {
    Tag saveTag(Tag tag) throws ImcoderException.PathAlreadyExists;

    Tag updateTag(Tag tag) throws ImcoderException.PathAlreadyExists;
}
