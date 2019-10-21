package com.example.demo.controller;

import com.example.demo.util.HttpUtil;
import com.example.demo.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HttpController {
    @GetMapping("/testHttp")
    @ResponseBody
    public String testHttp(){
        String key = "";
        String privateKey = "sdasdasd";
        String time = "2019/10/21";
        String userID = "123456";
        String result = "";
        String url = "http://127.0.0.1:8080/test2";
        try {
            Map paramMap = new HashMap<>();
            key = MD5Util.md5(time+userID+privateKey);
            paramMap.put("key",key);
            paramMap.put("time",time);
            paramMap.put("userID",userID);
            result = HttpUtil.get(url,paramMap,2000,2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
