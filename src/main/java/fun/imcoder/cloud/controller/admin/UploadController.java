package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/admin/upload")
public class UploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping("/{type}")
    public ResponseData<Map<String, String>> uploadFile(@PathVariable String type, @RequestParam("file") MultipartFile file) {
        Map<String, String> fileMap = new HashMap<>();
        String datePath = sdf.format(new Date()) + "/";
        String filePath = ImcoderConfig.UPLOAD_DIR + type + "/" + datePath;
        if (file.isEmpty()) {
            log.error("上传失败，文件为空");
        }
        String fileName = file.getOriginalFilename();
        fileMap.put("name", fileName);
        String newFileName = UUID.randomUUID() + "@@" + fileName;

        File dest = new File(filePath, newFileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            fileMap.put("url", "/" + ImcoderConfig.UPLOAD_FOLDER + "/" + type + "/" + datePath + newFileName);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return ResponseData.success(fileMap);
    }

    @PostMapping("/multiple/{type}")
    public ResponseData<List<Map<String, String>>> uploadMultipleFile(@PathVariable String type, HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        Map<String, String> fileMap = new HashMap<>();
        String datePath = sdf.format(new Date()) + "/";
        String filePath = ImcoderConfig.UPLOAD_DIR + type + "/" + datePath;
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                log.error("上传第" + (i++) + "个文件失败");
            }
            String fileName = file.getOriginalFilename();
            fileMap.put("name", fileName);
            String newFileName = UUID.randomUUID() + "@@" + fileName;

            File dest = new File(filePath, newFileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                fileMap.put("url", "/" + ImcoderConfig.UPLOAD_FOLDER + "/" + type + "/" + datePath + newFileName);
                list.add(fileMap);
                log.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                log.error(e.toString(), e);
                log.error("上传第" + (i++) + "个文件失败");
            }
        }
        return ResponseData.success(list);
    }

}
