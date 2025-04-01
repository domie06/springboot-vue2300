package com.entity.view;

import com.entity.YiyuyuexiyijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 已预约洗衣机
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-15
 */
@TableName("yiyuyuexiyiji")
public class YiyuyuexiyijiView extends YiyuyuexiyijiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public YiyuyuexiyijiView() {

	}

	public YiyuyuexiyijiView(YiyuyuexiyijiEntity yiyuyuexiyijiEntity) {
		try {
			BeanUtils.copyProperties(this, yiyuyuexiyijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
