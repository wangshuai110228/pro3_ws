package com.ws.bean.zhifu;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "z_flow")
public class Flow {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String flowNum;

    private String orderNum;

    private String productId;

    private String paidAmount;

    private Integer paidMethod;

    private Integer buyCounts;


    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}