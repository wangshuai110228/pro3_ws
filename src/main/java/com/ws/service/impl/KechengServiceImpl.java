package com.ws.service.impl;

import com.ws.bean.Kecheng;
import com.ws.bean.Ketype;
import com.ws.mapper.KechengMapper;
import com.ws.service.KechengService;
import com.ws.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Service
public class KechengServiceImpl implements KechengService {

    @Autowired
    private KechengMapper kechengMapper;

    @Autowired
    private OSSClientUtil ossClient;

    @Override
    public HashMap<String, Object> querykechen(int page, int rows, Kecheng kecheng) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =kechengMapper.queryTotak(kecheng);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Kecheng> list  = kechengMapper.queryPageKecheng(start,rows, kecheng);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

    //删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            kechengMapper.deleteAll(sid[i]);
        }
    }

    //新增
    @Override
    public void addKecheng(Kecheng kecheng) {
        kechengMapper.addKecheng(kecheng);
    }
//修改
    @Override
    public void updateKecheng(Kecheng kecheng) {
        kechengMapper.updateKecheng(kecheng);
    }
//回显
    @Override
    public Kecheng queryKechengById(Integer id) {
        return kechengMapper.queryKechengById(id);
    }

    //不分页
    @Override
    public List<Kecheng> querykechen3(String ty,String type,String kname,String lteacher) {

        return kechengMapper.querykechen3(ty,type,kname,lteacher);

    }

    //查询没有审核的
    @Override
    public List<Kecheng> querykechenId() {
        return kechengMapper.querykechenId();
    }

    //通过审核
    @Override
    public void updatekechenId(Integer id) {
        kechengMapper.updatekechenId(id);
    }

    //上传图片
    @Override
    public String updateHead(MultipartFile file, int i) {
        if (file == null || file.getSize() <= 0) {
            System.out.println("头像不能为空");
        }
        String name = ossClient.uploadImg2Oss(file);

        String imgUrl = ossClient.getImgUrl(name);

        return imgUrl;
    }


    //课程类型查询
    @Override
    public List<Ketype> QuerykeType() {
        return kechengMapper.QuerykeType();
    }

    //新增课程类型
    @Override
    public void addkeType(Ketype ketype) {
        kechengMapper.addkeType(ketype);
    }

    @Override
    public List<Kecheng> querykechen4() {

        return kechengMapper.querykechen4();
    }

    @Override
    public List<Kecheng> querykechen6(int page,int rows) {
        return kechengMapper.querykechen6(page,rows);
    }


}
