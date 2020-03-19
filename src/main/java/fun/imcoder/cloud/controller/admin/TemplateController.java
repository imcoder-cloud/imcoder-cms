package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.annotation.ModelParam;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/template")
public class TemplateController extends BaseController<Template, TemplateService> {

    /**
     * 所有文件夹和文件
     *
     * @param name
     * @return
     * @throws IOException
     */
    @GetMapping("/directory")
    private ResponseData<List<ImcoderFile>> directory(@RequestParam String name) throws IOException {
        if (StringUtils.isEmpty(name)) {
            name = ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE);
        }
        String dir = ImcoderConfig.TEMPLATES_DIR + name;
        return ResponseData.success(FileUtils.getFiles(dir));
    }

    /**
     * 只获取html
     *
     * @return
     * @throws IOException
     */
    @GetMapping("/file-list")
    private ResponseData<List<ImcoderFile>> fileList() throws IOException {
        String dir = ImcoderConfig.TEMPLATES_DIR + ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE);
        List<ImcoderFile> list = FileUtils.getFiles(dir).stream().filter(file -> file.getIsFile()).collect(Collectors.toList());
        return ResponseData.success(list);
    }

    @GetMapping("/content")
    private ResponseData<String> content(@RequestParam String path) throws Exception {
        return ResponseData.success(FileUtils.getFileContent(path));
    }

    @PostMapping("/directory/create")
    private ResponseData createDirectory(@RequestBody ImcoderFile file) {
        if (StringUtils.isEmpty(file.getPath())) {
            file.setPath(ImcoderConfig.TEMPLATES_DIR + ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE));
        }
        File rtnFile = new File(file.getPath() + "/" + file.getName());
        FileUtils.mkdir(rtnFile);
        return ResponseData.success(rtnFile);
    }

    @PostMapping("/create")
    private ResponseData createFile(@RequestBody ImcoderFile file) {
        if (StringUtils.isEmpty(file.getPath())) {
            String dir = ImcoderConfig.TEMPLATES_DIR + ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE) + "/" + file.getName();
            file.setPath(dir);
        }
        return ResponseData.success(FileUtils.newFile(file.getPath()));
    }

    @PutMapping("/write")
    private ResponseData writeFile(@RequestBody ImcoderFile file) {
        return ResponseData.success(FileUtils.writeFile(file.getPath(), file.getContent()));
    }

    @DeleteMapping("/file/delete")
    private ResponseData delete(@RequestBody ImcoderFile file) {
        if (file.getIsFile()) {
            FileUtils.deleteFile(file.getPath());
        } else {
            FileUtils.remove(new File(file.getPath()));
        }
        return ResponseData.success();
    }

    @PutMapping("/rename")
    private ResponseData rename(@RequestParam String srcPath, @RequestParam String targetPath) {
        File src = new File(srcPath);
        File target = new File(targetPath);
        src.renameTo(target);
        return ResponseData.success();
    }

    @PostMapping("/file/copy")
    private ResponseData copyFile(@RequestBody Map<String, String> map) throws IOException {
        String src = map.get("src");
        File srcFile = FileUtils.newFile(src);
        String dest = map.get("dest");
        if (StringUtils.isEmpty(dest)) {
            dest = ImcoderConfig.TEMPLATES_DIR.replace("file:///", "") + ImcoderConfig.options.get(ImcoderConfig.OPTIONS_KEY_TEMPLATE);
            dest += "/" + srcFile.getName();
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

    @PutMapping("/setActive")
    private ResponseData setActive(@RequestBody Template template) {
        this.service.setActive(template);
        return ResponseData.success();
    }

}
