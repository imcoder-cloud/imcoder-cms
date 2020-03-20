package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.model.Category;
import fun.imcoder.cloud.model.Permission;
import fun.imcoder.cloud.service.PermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/permission")
public class PermissionController extends BaseController<Permission, PermissionService> {

    @GetMapping("/tree")
    public ResponseData<List<Permission>> tree() {
        List<Permission> list = service.list();
        return ResponseData.success(convertToTree(list, 0));
    }

    public List<Permission> convertToTree(List<Permission> list, Integer parentId) {
        List<Permission> rtnList = new ArrayList<>();
        List<Permission> temp;
        for (Permission o : list) {
            if (parentId.equals(o.getParentId())) {
                temp = convertToTree(list, o.getId());
                if (temp.size() > 0) {
                    o.setChildren(temp);
                }
                rtnList.add(o);
            }
        }
        return rtnList;
    }

}
