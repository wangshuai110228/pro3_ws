package com.ws.mapper;

import com.ws.bean.Ketype;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KetypeMapper {

    @Select("select * from t_ketype  k GROUP BY k.kename")
    List<Ketype> QuerykeType();

    @Insert("INSERT INTO t_ketype(kename,kid)VALUES(#{kename},#{kid})")
    void addkeType(Ketype ketype);
}
