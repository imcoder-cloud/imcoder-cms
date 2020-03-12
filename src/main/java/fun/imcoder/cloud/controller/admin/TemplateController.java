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

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/template")
public class TemplateController extends BaseController<Template, TemplateService> {

    @GetMapping("/directory")
    private ResponseData<List<ImcoderFile>> directory(@RequestParam String name) throws IOException {
        if (StringUtils.isEmpty(name)) {
            name = ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE);
        }
        String dir = ImcoderConfig.TEMPLATES_DIR.replace("file:///", "") + name;
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

    @DeleteMapping("/delete")
    private ResponseData delete(@RequestBody ImcoderFile file) {
        return ResponseData.success(FileUtils.deleteFile(file.getPath()));
    }

}
