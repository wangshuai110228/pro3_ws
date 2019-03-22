package com.ws.service;

import com.ws.bean.Kecheng;
import com.ws.bean.Ketype;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface KechengService {
    HashMap<String, Object> querykechen(int page, int rows, Kecheng kecheng);

    void deleteAll(String id);

    void addKecheng(Kecheng kecheng);

    void updateKecheng(Kecheng kecheng);

    Kecheng queryKechengById(Integer id);

    List<Kecheng> querykechen3(String ty,String type,String kname,String lteacher);

    List<Kecheng> querykechenId();

    void updatekechenId(Integer id);

    String updateHead(MultipartFile file, int i);

    List<Ketype> QuerykeType();

    void addkeType(Ketype ketype);




    List<Kecheng> querykechen4();

    List<Kecheng> querykechen6(int page,int rows);

}