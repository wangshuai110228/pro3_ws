package com.ws.bean;





import java.io.Serializable;

public class Section implements Serializable {
    private static final long serialVersionUID = -6456521837836620288L;
    private Integer id;
    private String mlname;
    private String zame;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMlname() {
        return mlname;
    }

    public void setMlname(String mlname) {
        this.mlname = mlname;
    }

    public String getZame() {
        return zame;
    }

    public void setZame(String zame) {
        this.zame = zame;
    }
}
