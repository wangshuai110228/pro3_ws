package com.ws.mapper;

import com.ws.bean.Catalog;
import com.ws.bean.Section;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SectionMapper {

    @Select("select * from t_catalog")
    List<Catalog> querySection();

    @Select("select tc.* from t_catalog tc,t_kecheng tk where tc.kid = tk.id and tk.id = #{id}")
    List<Catalog> querySection2(Integer id);

    @Select("select tc.id,tc.mlname,GROUP_CONCAT(tz.zame) zame\n" +
            "from t_catalog tc,t_zhangjie tz\n" +
            "where tc.id = tz.mid\n" +
            "and tc.kid = #{kid}\n" +
            "group by tc.kid")
    List<Section> querySectionNode(Integer kid);

    @Update("update t_catalog set lls = lls+1 where id = #{kid}")
    void updateSectionNode(Integer kid);
}
