package com.ws.bean;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


public class Kecheng implements Serializable {

    private static final long serialVersionUID = -2974925595632283124L;
    private  Integer id;
    private  String kname;
    private  Integer kss;
    private  Integer lls;
    private  String lteacher;
    private  String oktime;
    private  String ktype;
    private  String kdesc;
    private  String kurl;

private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public Integer getKss() {
        return kss;
    }

    public void setKss(Integer kss) {
        this.kss = kss;
    }

    public Integer getLls() {
        return lls;
    }

    public void setLls(Integer lls) {
        this.lls = lls;
    }

    public String getLteacher() {
        return lteacher;
    }

    public void setLteacher(String lteacher) {
        this.lteacher = lteacher;
    }

    public String getOktime() {
        return oktime;
    }

    public void setOktime(String oktime) {
        this.oktime = oktime;
    }

    public String getKtype() {
        return ktype;
    }

    public void setKtype(String ktype) {
        this.ktype = ktype;
    }

    public String getKdesc() {
        return kdesc;
    }

    public void setKdesc(String kdesc) {
        this.kdesc = kdesc;
    }

    public String getKurl() {
        return kurl;
    }

    public void setKurl(String kurl) {
        this.kurl = kurl;
    }
}
