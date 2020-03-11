package fun.imcoder.cloud.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.imcoder.cloud.annotation.ModelParam;
import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.PageRequest;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.enums.ModelParamType;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.service.CategoryService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryController extends BaseController<Category, CategoryService> {

    @GetMapping("/tree")
    public ResponseData<List<Category>> treePage() {
        List<Category> list = service.customList(new HashMap<>());
        return ResponseData.success(ImcoderUtils.convertToTree(list, 0));
    }

}
