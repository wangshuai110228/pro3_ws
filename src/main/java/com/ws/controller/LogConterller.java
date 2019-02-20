package com.ws.controller;

import com.ws.bean.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class LogConterller {

    @Autowired
    private MongoTemplate mongoTemplate;

    //查询用户 query
    @RequestMapping("findLog")
    @ResponseBody
    public HashMap<String, Object> query(int page, int rows, LogBean logBean){

        HashMap<String, Object>  hashMap = new HashMap<>();
        Query query = new Query();
        //总条数
        long count = mongoTemplate.count(query, LogBean.class);
        //每页条数
        query.skip((page-1)*rows);
        //
        query.limit(rows);
        //放数据
        List<LogBean> find = mongoTemplate.find(query, LogBean.class);
        hashMap.put("total", count);
        hashMap.put("rows", find);
        return hashMap;

    }

}
