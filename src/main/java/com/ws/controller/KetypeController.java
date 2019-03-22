package com.ws.controller;


import com.ws.bean.Ketype;
import com.ws.service.KetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KetypeController {

    @Autowired
    private KetypeService ketypeService;


    //查询课程类型
    @RequestMapping("queryType")
    @ResponseBody
    public List<Ketype> QuerykeType(){

        return ketypeService.QuerykeType();
    }

    //新增课程类型
    @RequestMapping("addkeType")
    @ResponseBody
    public void addkeType(Ketype ketype){
        ketypeService.addkeType(ketype);
    }
}