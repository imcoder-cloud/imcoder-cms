package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.mapper.CategoryContentMapper;
import fun.imcoder.cloud.mapper.ContentExtMapper;
import fun.imcoder.cloud.mapper.ContentMapper;
import fun.imcoder.cloud.mapper.ContentTagMapper;
import fun.imcoder.cloud.model.CategoryContent;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ContentTag;
import fun.imcoder.cloud.model.ExtField;
import fun.imcoder.cloud.service.ContentService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl extends BaseServiceImpl<ContentMapper, Content> implements ContentService {
    @Resource
    private CategoryContentMapper categoryContentMapper;
    @Resource
    private ContentTagMapper contentTagMapper;
    @Resource
    private ContentExtMapper contentExtMapper;

    @Transactional
    @Override
    public Boolean saveContent(Content content) throws ImcoderException.PathAlreadyExists {
        ImcoderUtils.pathMustUnique(this.baseMapper, content.getId(), content.getPath());
        return saveContentInfo(content, "insert");
    }

    @Override
    @Transactional
    public Boolean updateContent(Content content) throws ImcoderException.PathAlreadyExists {
        Integer contentId = content.getId();
        ImcoderUtils.pathMustUnique(this.baseMapper, contentId, content.getPath());
        Map<String, Object> params = new HashMap<>();
        params.put("content_id", contentId);
        categoryContentMapper.deleteByMap(params);
        contentTagMapper.deleteByMap(params);

        return saveContentInfo(content, "update");
    }

    @Transactional
    boolean saveContentInfo(Content content, String type) {
        List<CategoryContent> categoryContents = content.getCategoryContents();
        List<ContentTag> contentTags = content.getContentTags();
        if ("insert".equals(type)) {
            this.save(content);
            this.insertContentExt(content);
            this.updateContentExt(content);
        } else {
            this.updateById(content);
            this.updateContentExt(content);
        }
        categoryContents.forEach(o -> {
            o.setContentId(content.getId());
        });
        contentTags.forEach(o -> {
            o.setContentId(content.getId());
        });
        if (!categoryContents.isEmpty()) {
            categoryContentMapper.insertBatch(categoryContents);
        }
        if (!contentTags.isEmpty()) {
            contentTagMapper.insertBatch(contentTags);
        }
        return true;
    }

    @Override
    public Content getById(Serializable id) {
        Map<String, Object> params = new HashMap<>();
        params.put("contentId", id);
        Map<String, Object> map = baseMapper.getContentExtByContentId(params);
        Content content = this.baseMapper.getById(id);
        content.setExtFields(map);
        return content;
    }

    private boolean insertContentExt(Content content) {
        Map<String, Object> contentExt = new HashMap<>();
        contentExt.put("contentId", content.getId());
        return this.baseMapper.insertContentExt(contentExt);
    }

    private boolean updateContentExt(Content content) {
        Map<String, Object> contentExt = new HashMap<>();
        Map<String, Object> extFields = content.getExtFields();
        extFields.keySet().removeIf(key -> key.equals("create_time") || key.equals("modify_time"));
        contentExt.put("contentId", content.getId());
        contentExt.put("fields", extFields);
        return this.baseMapper.updateContentExt(contentExt);
    }

}
