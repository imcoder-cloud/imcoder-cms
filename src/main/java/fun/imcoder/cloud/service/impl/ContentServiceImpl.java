package fun.imcoder.cloud.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.mapper.*;
import fun.imcoder.cloud.model.CategoryContent;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ContentTag;
import fun.imcoder.cloud.model.ExtField;
import fun.imcoder.cloud.service.ContentService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

@Service
@Transactional
public class ContentServiceImpl extends BaseServiceImpl<ContentMapper, Content> implements ContentService {
    @Resource
    private CategoryContentMapper categoryContentMapper;
    @Resource
    private ContentTagMapper contentTagMapper;
    @Resource
    private ContentExtMapper contentExtMapper;

    @Override
    public Boolean saveContent(Content content) throws ImcoderException.PathAlreadyExists {
        if (StringUtils.isEmpty(content.getPath())) {
            content.setPath(new Date().getTime() + "");
        }
        ImcoderUtils.pathMustUnique(this.baseMapper, content.getId(), content.getPath());
        return saveContentInfo(content, "insert");
    }

    @Override
    public Boolean updateContent(Content content) throws ImcoderException.PathAlreadyExists {
        Integer contentId = content.getId();
        if (StringUtils.isEmpty(content.getPath())) {
            content.setPath(new Date().getTime() + "");
        }
        ImcoderUtils.pathMustUnique(this.baseMapper, contentId, content.getPath());
        Map<String, Object> params = new HashMap<>();
        params.put("content_id", contentId);
        categoryContentMapper.deleteByMap(params);
        contentTagMapper.deleteByMap(params);

        return saveContentInfo(content, "update");
    }

    @Override
    public Boolean addVisits(Content content) {
        return this.baseMapper.addVisits(content);
    }

    @Override
    public List<ExtField> findExtField(Content content) {
        return this.baseMapper.findExtField(content);
    }

    @Override
    public Content getPrevious(Integer id) {
        return this.baseMapper.getPrevious(id);
    }

    @Override
    public Content getNext(Integer id) {
        return this.baseMapper.getNext(id);
    }

    boolean saveContentInfo(Content content, String type) {
        if (content.getKeywords() != null) {
            content.setKeywords(content.getKeywords().replaceAll("，", ","));
        }
        List<CategoryContent> categoryContents = content.getCategoryContents();
        List<ContentTag> contentTags = content.getContentTags();
        if ("insert".equals(type)) {
            this.save(content);
            this.insertContentExt(content);
            if (!content.getExtFields().isEmpty()) {
                this.updateContentExt(content);
            }
        } else {
            this.updateById(content);
            if (!content.getExtFields().isEmpty()) {
                this.updateContentExt(content);
            }
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
        List<ExtField> extList = this.baseMapper.findExtField(content);
        List<Map<String, Object>> list = new ArrayList<>();
        extList.forEach(extField -> {
            Map<String, Object> m = new HashMap<>();
            m.put("field", extField.getField());
            m.put("name", extField.getName());
            m.put("type", extField.getType());
            m.put("value", map.get(extField.getField()));
            list.add(m);
        });
        content.setExtFieldList(list);
        return content;
    }

    @Override
    public boolean removeById(Serializable id) {
        Map<String, Object> params = new HashMap<>();
        params.put("content_id", id);
        contentExtMapper.deleteByMap(params);
        return SqlHelper.retBool(this.baseMapper.deleteById(id));
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
