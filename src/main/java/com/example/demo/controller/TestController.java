package com.example.demo.controller;

import com.example.demo.util.MD5Util;
import com.example.demo.util.ReadFromFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

@Controller
public class TestController extends BaseController{
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "测试成功";
    }
    @GetMapping("/test2")
    @ResponseBody
    public String test2(String key,String time,String userID){
        String privateKey = "sdasdasd";
        if(!key.equals(MD5Util.md5(time+userID+privateKey))){
            return "验证失败！";
        }
        String test = "";
        try {
            File file = new File("D:/test.json");
            // 读取文件内容 (输入流)
            FileInputStream out = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(out);
            int ch = 0;
            while ((ch = isr.read()) != -1) {
                System.out.print((char) ch);
                test += (char) ch;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return test;
    }
}
