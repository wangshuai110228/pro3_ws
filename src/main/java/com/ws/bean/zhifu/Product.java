package com.ws.bean.zhifu;


import javax.persistence.*;

@Entity
@Table(name = "z_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer productId;
    private String productName;
    private String  productBeizhu;
    private Integer  unitId;
    private String  productfenlei;
    private String unitOrder;
    private Integer unitpid;
    private Integer  producPid;
    private  String textName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBeizhu() {
        return productBeizhu;
    }

    public void setProductBeizhu(String productBeizhu) {
        this.productBeizhu = productBeizhu;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getProductfenlei() {
        return productfenlei;
    }

    public void setProductfenlei(String productfenlei) {
        this.productfenlei = productfenlei;
    }

    public String getUnitOrder() {
        return unitOrder;
    }

    public void setUnitOrder(String unitOrder) {
        this.unitOrder = unitOrder;
    }

    public Integer getUnitpid() {
        return unitpid;
    }

    public void setUnitpid(Integer unitpid) {
        this.unitpid = unitpid;
    }

    public Integer getProducPid() {
        return producPid;
    }

    public void setProducPid(Integer producPid) {
        this.producPid = producPid;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }
}