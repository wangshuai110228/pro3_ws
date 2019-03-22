package com.ws.bean;

import java.io.Serializable;

/**
 *
 */
public class Ketype implements Serializable {


    private static final long serialVersionUID = -5931103615563589711L;
    private  Integer id;
    private  String kename;
    private  String kid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKename() {
        return kename;
    }

    public void setKename(String kename) {
        this.kename = kename;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }
}
