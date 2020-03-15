package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.model.ImcoderFile;
import fun.imcoder.cloud.model.Template;
import fun.imcoder.cloud.service.TemplateService;
import fun.imcoder.cloud.utils.FileUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/template")
public class TemplateController extends BaseController<Template, TemplateService> {

    @GetMapping("/directory")
    private ResponseData<List<ImcoderFile>> directory(@RequestParam String name) throws IOException {
        if (StringUtils.isEmpty(name)) {
            name = ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE);
        }
        String dir = ImcoderConfig.TEMPLATES_DIR + name;
        return ResponseData.success(FileUtils.getFiles(dir));
    }

    @GetMapping("/content")
    private ResponseData<String> content(@RequestParam String path) throws Exception {
        return ResponseData.success(FileUtils.getFileContent(path));
    }

    @PostMapping("/directory/create")
    private ResponseData createDirectory(@RequestBody ImcoderFile file) {
        return ResponseData.success(FileUtils.mkdir(file.getPath()));
    }

    @PostMapping("/create")
    private ResponseData createFile(@RequestBody ImcoderFile file) {
        return ResponseData.success(FileUtils.newFile(file.getPath()));
    }

    @PutMapping("/write")
    private ResponseData writeFile(@RequestBody ImcoderFile file) {
        return ResponseData.success(FileUtils.writeFile(file.getPath(), file.getContent()));
    }

    @DeleteMapping("/file/delete")
    private ResponseData delete(@RequestBody ImcoderFile file) {
        return ResponseData.success(FileUtils.deleteFile(file.getPath()));
    }

    @PostMapping("/file/copy")
    private ResponseData copyFile(@RequestBody Map<String, String> map) throws IOException {
        String src = map.get("src");
        File srcFile = FileUtils.newFile(src);
        String dest = map.get("dest");
        if (StringUtils.isEmpty(dest)) {
            dest = ImcoderConfig.TEMPLATES_DIR.replace("file:///", "") + ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE);
            dest += "/"+ srcFile.getName();
        }
        File destFile = FileUtils.newFile(dest);
        if (destFile.exists()) {
            destFile = FileUtils.newFile(destFile.getParent() + "/" + (new Date()).getTime() + "-" + destFile.getName());
        }
        FileUtils.copyFile(map.get("src"), dest);
        Map<String, String> rtn = new HashMap<>();
        rtn.put("path", destFile.getPath());
        rtn.put("name", destFile.getName());
        return ResponseData.success(rtn);
    }

}
