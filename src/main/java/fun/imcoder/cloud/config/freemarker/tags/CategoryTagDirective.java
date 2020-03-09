package fun.imcoder.cloud.config.freemarker.tags;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import freemarker.core.Environment;
import fun.imcoder.cloud.annotation.FreemarkerTag;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.service.CategoryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@FreemarkerTag("category")
public class CategoryTagDirective implements ImcoderFreemarkerTag {
    @Resource
    private CategoryService categoryService;

    @Override
    public Object getData(int page, int size, Map params, Environment environment) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<Category> list = categoryService.list(queryWrapper);
        return convertToTree(list, 0);
    }

    /**
     * @param list
     * @param parentId
     * @return
     * @desc 将List转为树状结构
     * @author chendongdong
     * 2020年03月09日
     */
    private List<Category> convertToTree(List<Category> list, Integer parentId) {
        List<Category> rtnList = new ArrayList<>();
        List<Category> temp;
        for (Category o : list) {
            if (parentId.equals(o.getParentId())) {
                temp = this.convertToTree(list, o.getId());
                if (temp.size() > 0) {
                    o.setChildren(temp);
                }
                rtnList.add(o);
            }
        }
        return rtnList;
    }


}
