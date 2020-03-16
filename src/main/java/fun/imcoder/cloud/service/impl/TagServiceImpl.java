package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.mapper.TagMapper;
import fun.imcoder.cloud.model.Tag;
import fun.imcoder.cloud.service.TagService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class TagServiceImpl extends BaseServiceImpl<TagMapper, Tag> implements TagService {

    @Override
    public Tag saveTag(Tag tag) throws ImcoderException.PathAlreadyExists {
        if (StringUtils.isEmpty(tag.getPath())) {
            tag.setPath(new Date().toString());
        }
        ImcoderUtils.pathMustUnique(this.baseMapper, tag.getId(), tag.getPath());
        this.baseMapper.insert(tag);
        return tag;
    }

    @Override
    public Tag updateTag(Tag tag) throws ImcoderException.PathAlreadyExists {
        if (StringUtils.isEmpty(tag.getPath())) {
            tag.setPath(new Date().toString());
        }
        ImcoderUtils.pathMustUnique(this.baseMapper, tag.getId(), tag.getPath());
        this.baseMapper.updateById(tag);
        return tag;
    }
}
