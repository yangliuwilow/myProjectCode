package com.willow.web.core;

import com.willow.core.system.model.ItcastUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/5.
 */

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {
    /**
     * 请求新增页面
     */
    @RequestMapping(value="/new")
    public String toAdd(Model model){
        model.addAttribute("_method", "post");
        return "upload/upload_edit";
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        net.sf.json.JSONObject member = new net.sf.json.JSONObject();
        try{
            String path="D:/upload/"+new Date().getTime()+file.getOriginalFilename();
            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            //构建series所需参数
            member.put("success", "ok"); //对应series.name
        }catch (Exception e){
            member.put("success", "error"); //对应series.name
        }
        return member.toString();
    }
    /**
     * 保存信息
     */
    @RequestMapping(value = "/save",method= RequestMethod.POST)
    public String saveHuman(Model model,ItcastUser itcastUser){

        return redirectOuter("/user");
    }
}
