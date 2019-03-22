package com.ws.controller;


import com.alibaba.fastjson.JSONObject;
import com.ws.bean.EsModel;
import com.ws.bean.Kecheng;
import com.ws.service.KechengService;
import com.ws.utils.ElasticsearchUtil;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class EsController {


    @Autowired
    private KechengService kechengService;
    /**
     * 测试索引
     */
    private String indexName = "test_index";

    /**
     * 类型
     */
    private String esType = "external";


    /**
     * http://127.0.0.1:8080/es/createIndex
     * 创建索引
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/createIndex")
    public String createIndex(HttpServletRequest request, HttpServletResponse response) {
        if (!ElasticsearchUtil.isIndexExist(indexName)) {
            ElasticsearchUtil.createIndex(indexName);
        } else {
            return "索引已经存在";
        }
        return "索引创建成功";
    }


    /**
     * 插入记录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertModel")
    public String insertModel() {

        List<Kecheng> kecheng=  kechengService.querykechen4();

        for(int i = 0 ; i < kecheng.size() ; i++) {

            System.out.println(kecheng.get(i).getId());
            EsModel esModel = new EsModel();
            esModel.setId(kecheng.get(i).getId().toString());
            esModel.setKname(kecheng.get(i).getKname());
            esModel.setKss(kecheng.get(i).getKss());
            esModel.setLls(kecheng.get(i).getLls());
            esModel.setLteacher(kecheng.get(i).getLteacher());
            esModel.setOktime(kecheng.get(i).getOktime());
            esModel.setKtype(kecheng.get(i).getKtype());
            esModel.setKdesc(kecheng.get(i).getKdesc());
            esModel.setKurl(kecheng.get(i).getKurl());
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(esModel);
            String id = ElasticsearchUtil.addData(jsonObject, indexName, esType, jsonObject.getString("id"));

        }

        return "es添加成功";
    }

}
