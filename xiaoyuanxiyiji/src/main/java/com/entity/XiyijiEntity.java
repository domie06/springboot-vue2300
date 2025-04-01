package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 洗衣机
 *
 * @email
 * @date 2021-03-15
 */
@TableName("xiyiji")
public class XiyijiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public XiyijiEntity() {

    }

    public XiyijiEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 洗衣机编号
     */
    @TableField(value = "name")

    private String name;


    /**
     * 价格/小时
     */
    @TableField(value = "money")

    private Integer money;


    /**
     * 洗衣机状态
     */
    @TableField(value = "xyjzt_types")

    private Integer xyjztTypes;


    /**
     * 洗衣机照片
     */
    @TableField(value = "im_photo")

    private String imPhoto;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：洗衣机编号
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：洗衣机编号
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：价格/小时
	 */
    public Integer getMoney() {
        return money;
    }


    /**
	 * 获取：价格/小时
	 */

    public void setMoney(Integer money) {
        this.money = money;
    }
    /**
	 * 设置：洗衣机状态
	 */
    public Integer getXyjztTypes() {
        return xyjztTypes;
    }


    /**
	 * 获取：洗衣机状态
	 */

    public void setXyjztTypes(Integer xyjztTypes) {
        this.xyjztTypes = xyjztTypes;
    }
    /**
	 * 设置：洗衣机照片
	 */
    public String getImPhoto() {
        return imPhoto;
    }


    /**
	 * 获取：洗衣机照片
	 */

    public void setImPhoto(String imPhoto) {
        this.imPhoto = imPhoto;
    }

    @Override
    public String toString() {
    return "Xiyiji{" +
            "id=" + id +
            ", name=" + name +
            ", money=" + money +
            ", xyjztTypes=" + xyjztTypes +
            ", imPhoto=" + imPhoto +
    "}";
    }
    }
