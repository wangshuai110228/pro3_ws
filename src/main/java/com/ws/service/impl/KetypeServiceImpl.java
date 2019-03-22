package com.ws.service.impl;

import com.ws.bean.Ketype;
import com.ws.mapper.KetypeMapper;
import com.ws.service.KetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KetypeServiceImpl implements KetypeService {


    @Autowired
    private KetypeMapper ketypeMapper;

    @Override
    public List<Ketype> QuerykeType() {
        return ketypeMapper.QuerykeType();
    }

    @Override
    public void addkeType(Ketype ketype) {

        String   kids =   ketype.getKid();
        String[] kid = kids.split(",");
        for (int i = 0; i <kid.length; i++) {
            ketype.setKid(kid[i]);
            ketypeMapper.addkeType(ketype);

        }

    }
}
