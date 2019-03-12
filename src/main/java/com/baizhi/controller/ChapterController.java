package com.baizhi.controller;

import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/add")
    @ResponseBody
    public void addChapter(MultipartFile curl, HttpServletRequest req) throws IllegalStateException, IOException {
      if(!curl.isEmpty()) {
          String realPath = req.getSession().getServletContext().getRealPath("/music");
          String originalFilename = curl.getOriginalFilename();
          File file = new File(realPath);
          if (!file.exists()) {
              file.mkdir();
          }
          curl.transferTo(new File(realPath, originalFilename));
      }

    }




    @RequestMapping("/download")
    @ResponseBody
    public void  download(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String title="001.jpg";
       //获取文件路径
       String realPath=request.getSession().getServletContext().getRealPath("/music");
       //获取文件
        File file=new File(realPath,title);
        //根据文件后缀设置响应类型
        int i = title.lastIndexOf(".");
        String substring = title.substring(i);
        response.setContentType(request.getSession().getServletContext().getMimeType(substring));
        //设置响应头
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(title,"utf-8"));
        //设置响应
        FileInputStream fileInputStream = new FileInputStream(file);
        FileCopyUtils.copy(fileInputStream,response.getOutputStream());



    }


}
