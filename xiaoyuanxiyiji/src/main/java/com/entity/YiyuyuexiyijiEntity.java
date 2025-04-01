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
 * 已预约洗衣机
 *
 * @email
 * @date 2021-03-15
 */
@TableName("yiyuyuexiyiji")
public class YiyuyuexiyijiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public YiyuyuexiyijiEntity() {

    }

    public YiyuyuexiyijiEntity(T t) {
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
    @TableField(value = "xyj_types")

    private Integer xyjTypes;


    /**
     * 预约用户
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
     * 使用时间（单位小时）
     */
    @TableField(value = "hour")

    private Integer hour;


    /**
     * 总价价格
     */
    @TableField(value = "money")

    private Integer money;


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
    public Integer getXyjTypes() {
        return xyjTypes;
    }


    /**
	 * 获取：洗衣机编号
	 */

    public void setXyjTypes(Integer xyjTypes) {
        this.xyjTypes = xyjTypes;
    }
    /**
	 * 设置：预约用户
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：预约用户
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：使用时间（单位小时）
	 */
    public Integer getHour() {
        return hour;
    }


    /**
	 * 获取：使用时间（单位小时）
	 */

    public void setHour(Integer hour) {
        this.hour = hour;
    }
    /**
	 * 设置：总价价格
	 */
    public Integer getMoney() {
        return money;
    }


    /**
	 * 获取：总价价格
	 */

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
    return "Yiyuyuexiyiji{" +
            "id=" + id +
            ", xyjTypes=" + xyjTypes +
            ", yhTypes=" + yhTypes +
            ", createTime=" + createTime +
            ", hour=" + hour +
            ", money=" + money +
    "}";
    }
    }
