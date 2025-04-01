package com.entity.vo;

import com.entity.XiyijiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 洗衣机
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-15
 */
@TableName("xiyiji")
public class XiyijiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 洗衣机编号 Search
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
	 * 设置：洗衣机编号 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：洗衣机编号 Search
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

}
