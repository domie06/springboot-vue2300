package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiyuyuexiyijiEntity;
import java.util.Map;

/**
 * 已预约洗衣机 服务类
 * @since 2021-03-15
 */
public interface YiyuyuexiyijiService extends IService<YiyuyuexiyijiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}