package org.item.jurisdiction.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.item.jurisdiction.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = {"/file/upload"}, method = {RequestMethod.POST})
    public JsonResult fileUpload2(@RequestParam("userHeadimg") MultipartFile file) throws IOException {
        JsonResult js;
        if (file.isEmpty()) {
            return new JsonResult("404", "上传失败，未选择文件！");
        }
        try {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String newFilename = uuid + suffixName;
            String path = "C:\\image\\";
            File newFile = new File(path + newFilename);
            file.transferTo(newFile);
            js = new JsonResult("200", "上传成功", newFilename);
        } catch (Exception e) {
            e.printStackTrace();
            js = new JsonResult("500", "上传异常");
        }
        return js;
    }
}