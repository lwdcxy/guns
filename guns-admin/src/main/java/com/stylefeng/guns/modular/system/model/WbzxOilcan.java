package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 油罐台账
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-19
 */
@TableName("wbzx_oilcan")
public class WbzxOilcan extends Model<WbzxOilcan> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("oilcan_name")
    private String oilcanName;
    @TableField("oilcan_parameter")
    private String oilcanParameter;
    @TableField("oilcan_record")
    private String oilcanRecord;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOilcanName() {
        return oilcanName;
    }

    public void setOilcanName(String oilcanName) {
        this.oilcanName = oilcanName;
    }

    public String getOilcanParameter() {
        return oilcanParameter;
    }

    public void setOilcanParameter(String oilcanParameter) {
        this.oilcanParameter = oilcanParameter;
    }

    public String getOilcanRecord() {
        return oilcanRecord;
    }

    public void setOilcanRecord(String oilcanRecord) {
        this.oilcanRecord = oilcanRecord;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WbzxOilcan{" +
        "id=" + id +
        ", oilcanName=" + oilcanName +
        ", oilcanParameter=" + oilcanParameter +
        ", oilcanRecord=" + oilcanRecord +
        "}";
    }
}
