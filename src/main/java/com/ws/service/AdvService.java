package com.ws.service;

import com.ws.bean.Advertisement;
import com.ws.bean.WebUser;


import java.util.HashMap;
import java.util.List;

public interface AdvService {



    HashMap<String, Object> queryAdv(int page, int rows, Advertisement adv);

    List<Advertisement> queryAdvList2();

    void deleteAll(String id);


    Advertisement queryById(Integer id);

    void updateAdv(Advertisement adv);

    void addAdv(Advertisement adv);
}
