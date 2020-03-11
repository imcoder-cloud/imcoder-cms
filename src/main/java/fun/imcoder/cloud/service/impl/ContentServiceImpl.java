package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.ContentMapper;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.CategoryContent;
import fun.imcoder.cloud.model.Content;
import fun.imcoder.cloud.model.ContentTag;
import fun.imcoder.cloud.service.CategoryContentService;
import fun.imcoder.cloud.service.ContentService;
import fun.imcoder.cloud.service.ContentTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentServiceImpl extends BaseServiceImpl<ContentMapper, Content> implements ContentService {
    @Resource
    private CategoryContentService categoryContentService;
    @Resource
    private ContentTagService contentTagService;

    @Transactional
    @Override
    public Boolean saveContent(Content content) {
        List<CategoryContent> categoryContents = content.getCategoryContents();
        List<ContentTag> contentTags = content.getContentTags();
        this.save(content);
        categoryContents.forEach(o -> {
            o.setContentId(content.getId());
        });
        contentTags.forEach(o -> {
            o.setContentId(content.getId());
        });
        categoryContentService.saveBatch(categoryContents);
        contentTagService.saveBatch(contentTags);
        return true;
    }
}
