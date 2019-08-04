package org.item.jurisdiction.controller;

import org.item.jurisdiction.util.Constants;
import org.item.jurisdiction.util.JsonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@CrossOrigin
@RestController
public class FileController {

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public JsonResult fileUpload2(@RequestParam("userHeadimg") MultipartFile file) throws IOException {
        JsonResult js;
        if(file.isEmpty()){
            js = new JsonResult(Constants.STATUS_NOT_FOUND,"上传失败，未选择文件！");
            return js;
        }
        try {
                //获取文件名
                String fileName = file.getOriginalFilename();
                //获取后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));

                String uuid= UUID.randomUUID().toString().replace("-","");
                //重命名
                String newFilename = uuid + suffixName;
                //保存路径
                String path="F:\\image\\";
                //通过MultipartFile的方法直接写文件（注意这个时候）
                File newFile=new File(path+newFilename);
                file.transferTo(newFile);
                js = new JsonResult(Constants.STATUS_SUCCESS, "上传成功", newFilename);

        }catch (Exception e){
            e.printStackTrace();
            js = new JsonResult(Constants.STATUS_FAIL, "上传异常");
        }

        return js;
    }
}
