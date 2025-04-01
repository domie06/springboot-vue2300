package com.entity.model;

import com.entity.XiyijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 洗衣机
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-15
 */
public class XiyijiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 洗衣机编号 Search
     */
    private String name;


    /**
     * 价格/小时
     */
    private Integer money;


    /**
     * 洗衣机状态
     */
    private Integer xyjztTypes;


    /**
     * 洗衣机照片
     */
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
