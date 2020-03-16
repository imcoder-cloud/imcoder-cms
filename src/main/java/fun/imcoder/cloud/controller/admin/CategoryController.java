package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.exception.ImcoderException;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.service.CategoryService;
import fun.imcoder.cloud.utils.ImcoderUtils;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    private ResponseData<Category> save(@RequestBody Category category) throws ImcoderException.PathAlreadyExists {
        return ResponseData.success(service.saveCategory(category));
    }

    @PutMapping("/update")
    private ResponseData<Category> update(@RequestBody Category category) throws ImcoderException.PathAlreadyExists {
        return ResponseData.success(service.updateCategory(category));
    }

}
