package com.ws.mapper;

import com.ws.bean.Kecheng;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface KechengMapper {

    //查询总条数
    @Select("select count(*)  from t_kecheng")
    /*@Select("<script>"
            + "SELECT count(*)  from t_kecheng "
            + "WHERE 1=1"
            + "<if test='kecheng.lteacher!=null'>"
            + "and lteacher like '%${kecheng.lteacher}%'"
            + "</if>"
            + "</script>")*/
    long queryTotak(@Param("kecheng") Kecheng kecheng);



    //查询
  @Select("SELECT * FROM t_kecheng LIMIT #{start},#{rows}")
   /* @Select("<script>"
            + "SELECT * from t_kecheng"
            + "WHERE 1=1"
            + "<if test='kecheng.lteacher!=null'>"
            + "and lteacher like '%${kecheng.lteacher}%'"
            + "LIMIT #{start},#{rows}"
            + "</if>"
            + "</script>")*/
    /*@Select("<script>"
            + "SELECT * from s_webuser "
            + "WHERE 1=1"
            + " <if test='webuser.name!=null'>"
            + " and name like '%${webuser.name}%'"
            + " LIMIT #{start},#{rows}"
            + " </if>"
            + " </script>")*/
    List<Kecheng> queryPageKecheng(@Param("start")int start, @Param("rows")int rows, @Param("kecheng")Kecheng kecheng);

    //删除
    @Delete("delete from t_kecheng where id=#{s}")
    void deleteAll(String s);
//新增

    @Insert("INSERT into t_kecheng(kname,kss,lls,lteacher,oktime,ktype,kdesc,kurl) VALUES(#{kname},#{kss},#{lls},#{lteacher},#{oktime},#{ktype},#{kdesc},#{kurl})")
    void addKecheng(Kecheng kecheng);
    //修改
    @Update("UPDATE t_kecheng  SET kname=#{kname} ,kss=#{kss},lls=#{lls},lteacher=#{lteacher},oktime=#{oktime},ktype=#{ktype},kdesc=#{kdesc},kurl=#{kurl} where id=#{id}")
    void updateKecheng(Kecheng kecheng);
    //回显
    @Select("SELECT * FROM t_kecheng c where c.id=#{id}")
    Kecheng queryKechengById(Integer id);

    @Select("SELECT * FROM t_kecheng")
    List<Kecheng> querykechen3();
}
