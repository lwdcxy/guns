package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;
import java.sql.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 低值易耗表
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-19
 */
@TableName("wbzx_dizhi")
public class WbzxDizhi extends Model<WbzxDizhi> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @TableField("dizhi_name")
    private String dizhiName;
    @TableField("dizhi_guige")
    private String dizhiGuige;
    @TableField("dizhi_danwei")
    private String dizhiDanwei;
    @TableField("dizhi_shuliang")
    private String dizhiShuliang;
    @TableField("dizhi_leibie")
    private String dizhiLeibie;
    @TableField("dizhi_zhuangtai")
    private String dizhiZhuangtai;
    @TableField("dizhi_bumen")
    private String dizhiBumen;
    @TableField("dizhi_user")
    private String dizhiUser;
    @TableField("dizhi_weizhi")
    private String dizhiWeizhi;
    @TableField("dizhi_time")
    private Date dizhiTime;
    @TableField("dizhi_beizhu")
    private String dizhiBeizhu;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDizhiName() {
        return dizhiName;
    }

    public void setDizhiName(String dizhiName) {
        this.dizhiName = dizhiName;
    }

    public String getDizhiGuige() {
        return dizhiGuige;
    }

    public void setDizhiGuige(String dizhiGuige) {
        this.dizhiGuige = dizhiGuige;
    }

    public String getDizhiDanwei() {
        return dizhiDanwei;
    }

    public void setDizhiDanwei(String dizhiDanwei) {
        this.dizhiDanwei = dizhiDanwei;
    }

    public String getDizhiShuliang() {
        return dizhiShuliang;
    }

    public void setDizhiShuliang(String dizhiShuliang) {
        this.dizhiShuliang = dizhiShuliang;
    }

    public String getDizhiLeibie() {
        return dizhiLeibie;
    }

    public void setDizhiLeibie(String dizhiLeibie) {
        this.dizhiLeibie = dizhiLeibie;
    }

    public String getDizhiZhuangtai() {
        return dizhiZhuangtai;
    }

    public void setDizhiZhuangtai(String dizhiZhuangtai) {
        this.dizhiZhuangtai = dizhiZhuangtai;
    }

    public String getDizhiBumen() {
        return dizhiBumen;
    }

    public void setDizhiBumen(String dizhiBumen) {
        this.dizhiBumen = dizhiBumen;
    }

    public String getDizhiUser() {
        return dizhiUser;
    }

    public void setDizhiUser(String dizhiUser) {
        this.dizhiUser = dizhiUser;
    }

    public String getDizhiWeizhi() {
        return dizhiWeizhi;
    }

    public void setDizhiWeizhi(String dizhiWeizhi) {
        this.dizhiWeizhi = dizhiWeizhi;
    }

    public Date getDizhiTime() {
        return dizhiTime;
    }

    public void setDizhiTime(Date dizhiTime) {
        this.dizhiTime = dizhiTime;
    }

    public String getDizhiBeizhu() {
        return dizhiBeizhu;
    }

    public void setDizhiBeizhu(String dizhiBeizhu) {
        this.dizhiBeizhu = dizhiBeizhu;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WbzxDizhi{" +
        "id=" + id +
        ", dizhiName=" + dizhiName +
        ", dizhiGuige=" + dizhiGuige +
        ", dizhiDanwei=" + dizhiDanwei +
        ", dizhiShuliang=" + dizhiShuliang +
        ", dizhiLeibie=" + dizhiLeibie +
        ", dizhiZhuangtai=" + dizhiZhuangtai +
        ", dizhiBumen=" + dizhiBumen +
        ", dizhiUser=" + dizhiUser +
        ", dizhiWeizhi=" + dizhiWeizhi +
        ", dizhiTime=" + dizhiTime +
        ", dizhiBeizhu=" + dizhiBeizhu +
        "}";
    }
}
