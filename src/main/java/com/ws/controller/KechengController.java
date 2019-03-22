package com.ws.controller;

import com.alibaba.fastjson.JSONObject;
import com.ws.bean.EsModel;
import com.ws.bean.Kecheng;
import com.ws.bean.Ketype;
import com.ws.service.KechengService;
import com.ws.utils.ElasticsearchUtil;
import com.ws.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class KechengController {

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
     * 插入记录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertKe")
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







    //查询用户表
    @RequestMapping("querykechen2")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Kecheng kecheng){
        HashMap<String,Object> list = kechengService.querykechen(page,rows, kecheng);

        return list;
    }



    //查询审核后的
    @RequestMapping("querykecheneeee")
    @ResponseBody
    public List<Kecheng> querykechen3(String ty,String type,String kname,String lteacher){

        if (type!=""){

            return kechengService.querykechen3(ty,type,kname,lteacher);
        }

        List<Kecheng> knam=  kechengService.querykechen4();
        return knam;


    }

    //查询审核前的
    @RequestMapping("querykechenId")
    @ResponseBody
    public List<Kecheng> querykechenId(){

        return kechengService.querykechenId();
    }

    //审核通过
    @RequestMapping("updatekechenId")
    @ResponseBody
    public String  updatekechenId(Integer id){
        kechengService.updatekechenId(id);
        return "审核通过";
    }

    //批量删除
    @RequestMapping("deleteKechenAll")
    @ResponseBody
    public  void  deleteAll(String id){

        kechengService.deleteAll(id);
    }

    //修改回显
   @RequestMapping("queryKechengById")
    @ResponseBody
    public Kecheng queryKechengById(Integer id){

       Kecheng  kecheng   = kechengService.queryKechengById(id);
        return kecheng;
    }



    //上传图片
    @RequestMapping("uploadImg2")
    @ResponseBody
    public String upload(HttpServletRequest request, @RequestParam(value="picFile",required=false) MultipartFile picFile) {
        String path = null;
        try {
            path = FileUtil.FileUpload(picFile, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(path.contains("null")) {
            return null;
        }else {
            System.out.println(path);
            return path;

        }
    }


    //oss 测试上传图片
    @RequestMapping(value = "/headImgUpload1.json", method = RequestMethod.POST)
    @ResponseBody
    public String headImgUpload(HttpServletRequest request,@RequestParam(value="picFile",required=false) MultipartFile file) throws IOException {


        //Map<String, Object> value = new HashMap<String, Object>();
        //value.put("success", true);
        //value.put("errorCode", 0);
        //value.put("errorMsg", "");
        String head = kechengService.updateHead(file, 4);//此处是调用上传服务接口，4是需要更新的userId 测试数据。
        System.out.println(head);
        //value.put("data", head);

        return head;
    }




    //修改 ： 新增
    @RequestMapping("addKechen")
    @ResponseBody
    public void  addAnswer(Kecheng kecheng){

        Integer id = kecheng.getId();
        if (id!=null){
            //修改

            kechengService.updateKecheng(kecheng);
        }else {
            //新增


            kecheng.setLls(0);
            kechengService.addKecheng(kecheng);
        }

    }




    //查询课程类型
    @RequestMapping("queryType1")
    @ResponseBody
    public List<Ketype> QuerykeType(){

        return kechengService.QuerykeType();
    }

    //新增课程类型
    @RequestMapping("addkeType1")
    @ResponseBody
    public void addkeType(Ketype ketype){
        kechengService.addkeType(ketype);
    }

}
