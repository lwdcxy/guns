package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.enums.IdType;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 呈报件登记
 * </p>
 *
 * @author lwdcxy123
 * @since 2018-05-19
 */
@TableName("wbzx_chenbaojian")
public class WbzxChenbaojian extends Model<WbzxChenbaojian> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("chenbaojian_no")
    private String chenbaojianNo;
    @TableField("chenbaojiancol_name")
    private String chenbaojiancolName;
    @TableField("chenbaojiancol_time")
    private Date chenbaojiancolTime;
    @TableField("chenbaojiancol_user")
    private String chenbaojiancolUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChenbaojianNo() {
        return chenbaojianNo;
    }

    public void setChenbaojianNo(String chenbaojianNo) {
        this.chenbaojianNo = chenbaojianNo;
    }

    public String getChenbaojiancolName() {
        return chenbaojiancolName;
    }

    public void setChenbaojiancolName(String chenbaojiancolName) {
        this.chenbaojiancolName = chenbaojiancolName;
    }

    public Date getChenbaojiancolTime() {
        return chenbaojiancolTime;
    }

    public void setChenbaojiancolTime(Date chenbaojiancolTime) {
        this.chenbaojiancolTime = chenbaojiancolTime;
    }

    public String getChenbaojiancolUser() {
        return chenbaojiancolUser;
    }

    public void setChenbaojiancolUser(String chenbaojiancolUser) {
        this.chenbaojiancolUser = chenbaojiancolUser;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WbzxChenbaojian{" +
        "id=" + id +
        ", chenbaojianNo=" + chenbaojianNo +
        ", chenbaojiancolName=" + chenbaojiancolName +
        ", chenbaojiancolTime=" + chenbaojiancolTime +
        ", chenbaojiancolUser=" + chenbaojiancolUser +
        "}";
    }
}
