package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Applica;
import com.jk.model.CourseMin;
import com.jk.service.ApplicaService;
import com.jk.util.OSSClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("img")
public class ImgController {

    @Reference
    private ApplicaService applicaService;

    @RequestMapping("addApplica")
    @ResponseBody
    public void addApplica(Applica applica){
        applicaService.addApplica(applica);
    }

    @RequestMapping("addCourse")
    @ResponseBody
    public Integer addCourse(CourseMin cou){
        applicaService.addCourse(cou);
        Integer subId=applicaService.queryCourseId(cou.getSubName());
        return subId;
    }

    @RequestMapping("queryCourse")
    @ResponseBody
    public List<CourseMin> queryCourse(){
       return applicaService.queryCourse();
    }






    /**
     * OSS阿里云上传图片
     * @return
     */
    @RequestMapping("updaloadImg")
    @ResponseBody
    public Map uploadImg(MultipartFile img)throws IOException {
        if (img == null || img.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(img);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println("图片url："+split[0]);
        Map map = new HashMap();
        map.put("imgUrl",split[0]);
        return map;
    }
    @RequestMapping("updaloadcertification")
    @ResponseBody
    public Map updaloadcertification(MultipartFile img2)throws IOException {
        if (img2 == null || img2.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(img2);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println("图片url："+split[0]);
        Map map = new HashMap();
        map.put("imgUrl",split[0]);
        return map;
    }
    @RequestMapping("updaloadteacherimg")
    @ResponseBody
    public Map updaloadteacherimg(MultipartFile img3)throws IOException {
        if (img3 == null || img3.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(img3);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println("图片url："+split[0]);
        Map map = new HashMap();
        map.put("imgUrl",split[0]);
        return map;
    }
}
