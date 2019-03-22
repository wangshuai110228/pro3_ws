package com.ws.mapper;

import com.ws.bean.Kecheng;
import com.ws.bean.Ketype;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface KechengMapper {

    //查询总条数
   @Select("select count(*)  from t_kecheng")
   /* @Select("<script>"
            + "select count(*)  from t_kecheng "
            + "WHERE 1=1"
            + "<if test='kecheng.kname!=null'>"
            + "and kname like '%${kecheng.kname}%'"
            + "</if>"
            + "</script>")*/
    long queryTotak(@Param("kecheng") Kecheng kecheng);



    //查询
  @Select("SELECT * FROM t_kecheng LIMIT #{start},#{rows}")
   /*    @Select("<script>"
            + "select *  from t_kecheng"
            + "WHERE 1=1"
            + "<if test='kecheng.kname!=null'>"
            + "and kname like '%${kecheng.kname}%'"
            + "LIMIT #{start},#{rows}"
            + "</if>"
            + "</script>")*/
    List<Kecheng> queryPageKecheng(@Param("start") int start, @Param("rows") int rows, @Param("kecheng") Kecheng kecheng);

    //删除
    @Delete("delete from t_kecheng where id=#{s}")
    void deleteAll(String s);
//新增
@Insert("INSERT into t_kecheng(kname,kss,lls,lteacher,oktime,ktype,kdesc,kurl,ttid) VALUES(#{kname},#{kss},#{lls},#{lteacher},#{oktime},#{ktype},#{kdesc},#{kurl},0)")
    void addKecheng(Kecheng kecheng);
    //修改

    @Update("UPDATE t_kecheng  SET kname=#{kname} ,kss=#{kss},lls=#{lls},lteacher=#{lteacher},oktime=#{oktime},ktype=#{ktype},kdesc=#{kdesc},kurl=#{kurl},ttid=1  where id=#{id}")
    void updateKecheng(Kecheng kecheng);
    //回显
    @Select("SELECT * FROM t_kecheng c where c.id=#{id}")
    Kecheng queryKechengById(Integer id);

    //查询课程不分页
    @Select("SELECT * FROM t_kecheng k LEFT JOIN t_ketype ty on k.id=ty.kid where k.ttid=1 and k.ktype =#{ty} or k.ktype =#{type} or ty.kename=#{kname} or k.lteacher=#{lteacher} ")
    List<Kecheng> querykechen3(@Param("ty")String ty,@Param("type")String type,@Param("kname")String kname,@Param("lteacher")String lteacher);

    //查询没有审核的
    @Select("SELECT * FROM t_kecheng k WHERE k.ttid=0")
    List<Kecheng> querykechenId();

    //通过审核
    @Update("UPDATE t_kecheng k set k.ttid=1 WHERE k.id =#{id}")
    void updatekechenId(Integer id);


    //课程类型查询
    @Select("select * from t_ketype  k GROUP BY k.kename")
    List<Ketype> QuerykeType();
    //新增课程类型
    @Insert("INSERT INTO t_ketype(kename,kid)VALUES(#{kename},#{kid})")
    void addkeType(Ketype ketype);

    @Select("SELECT * FROM t_kecheng k where k.ttid=1")
    List<Kecheng> querykechen4();

    @Select("SELECT * FROM t_kecheng k where k.ttid=1 LIMIT #{page},#{rows}")
    List<Kecheng> querykechen6(@Param("page")int page,@Param("rows")int rows);
}
