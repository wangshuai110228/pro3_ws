package com.ws.mapper;

import com.ws.bean.WebUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WebUserMapper {

    //查询总条数
   //@Select("select count(*)  from s_webuser")
    /*@Select("<script>"
            + " select count(*)  from s_webuser"
            + " WHERE 1=1"
            + " <if test='webuser.name!=null'>"
            + " and name like '%${webuser.name}%'"
            + " </if>"
            + " </script>")*/
    @Select("<script>"
            + "select count(*)  from s_webuser WHERE 1=1"
            + "<if test='webuser.name!=null'>"
            + " and name like '%${webuser.name}%'"
            + "</if>"
            + "</script>")
    long queryTota(@Param("webuser") WebUser webuser);

    //查询
  //@Select("SELECT * FROM s_webuser LIMIT #{start},#{rows}")
    /*@Select("<script>"
            + " select count(*)  from s_webuser"
            + " WHERE 1=1"
            + " <if test='webuser.name!=null'>"
            + " and name like '%${webuser.name}%'"
            + " LIMIT #{start},#{rows}"
            + " </if>"
            + " </script>")*/
    @Select("<script>"
            + "SELECT * from s_webuser "
            + "WHERE 1=1"
            + " <if test='webuser.name!=null'>"
            + " and name like '%${webuser.name}%'"
            + " LIMIT #{start},#{rows}"
            + " </if>"
            + " </script>")
    List<WebUser> queryPageWebUser(@Param("start")int start, @Param("rows")int rows, @Param("webuser")WebUser webuser);


    //修改回显
    @Select("SELECT * FROM s_webuser c where c.id=#{id}")
    WebUser queryWebUserById(Integer id);
    //修改
    @Update("UPDATE s_webuser c SET c.name=#{name} ,c.pwd=#{pwd} ,c.email=#{email}, c.sex=#{sex} where c.id=#{id}")
    void updateWebUser(WebUser webuser);
    //新增
    @Insert("INSERT INTO s_webuser(name,pwd,email,sex,member,expiredate)VALUES(#{name},#{pwd},#{email},#{sex},#{member},#{expiredate})")
    void addWebUser(WebUser webuser);
    //删除
    @Delete("delete from s_webuser where id=#{s}")
    void deleteAll(String s);
}
