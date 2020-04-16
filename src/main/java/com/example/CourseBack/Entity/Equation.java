package com.example.CourseBack.Entity;

import javax.persistence.*;

@Entity
@Table(name = "equations")
public class Equation {

    @Id
    @Column(name = "equationid")
    private Integer equationid;

    @Column(name = "equationnamerus", length = 255)
    private String equationnamerus;
    @Column(name = "equationnameeng", length = 255)
    private String equationnameeng;
    @Column(name = "equationjs", length = 255)
    private String equationjs;
    @Column(name = "equationcoefficientsjs", length = 255)
    private String equationcoefficientsjs;

    @Column(name = "xmin")
    private Double xmin;
    @Column(name = "xmax")
    private Double xmax;

    @Column(name = "xaxis", length = 255)
    private String xaxis;
    @Column(name = "xmesuare", length = 255)
    private String xmesuare;
    @Column(name = "yaxis", length = 255)
    private String yaxis;
    @Column(name = "ymesuare", length = 255)
    private String ymesuare;
    @Column(name = "xml", length = 255)
    private String xml;

    public Integer getEquationid() {
        return equationid;
    }

    public void setEquationid(Integer equationid) {
        this.equationid = equationid;
    }

    public String getEquationnamerus() {
        return equationnamerus;
    }

    public void setEquationnamerus(String equationnamerus) {
        this.equationnamerus = equationnamerus;
    }

    public String getEquationnameeng() {
        return equationnameeng;
    }

    public void setEquationnameeng(String equationnameeng) {
        this.equationnameeng = equationnameeng;
    }

    public String getEquationjs() {
        return equationjs;
    }

    public void setEquationjs(String equationjs) {
        this.equationjs = equationjs;
    }

    public String getEquationcoefficientsjs() {
        return equationcoefficientsjs;
    }

    public void setEquationcoefficientsjs(String equationcoefficientsjs) {
        this.equationcoefficientsjs = equationcoefficientsjs;
    }

    public Double getXmin() {
        return xmin;
    }

    public void setXmin(Double xmin) {
        this.xmin = xmin;
    }

    public Double getXmax() {
        return xmax;
    }

    public void setXmax(Double xmax) {
        this.xmax = xmax;
    }

    public String getXaxis() {
        return xaxis;
    }

    public void setXaxis(String xaxis) {
        this.xaxis = xaxis;
    }

    public String getXmesuare() {
        return xmesuare;
    }

    public void setXmesuare(String xmesuare) {
        this.xmesuare = xmesuare;
    }

    public String getYaxis() {
        return yaxis;
    }

    public void setYaxis(String yaxis) {
        this.yaxis = yaxis;
    }

    public String getYmesuare() {
        return ymesuare;
    }

    public void setYmesuare(String ymesuare) {
        this.ymesuare = ymesuare;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
