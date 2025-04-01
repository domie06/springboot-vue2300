package com.entity.vo;

import com.entity.YiyuyuexiyijiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 已预约洗衣机
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-15
 */
@TableName("yiyuyuexiyiji")
public class YiyuyuexiyijiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
