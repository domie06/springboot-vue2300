package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiyijiEntity;
import java.util.Map;

/**
 * 洗衣机 服务类
 * @since 2021-03-15
 */
public interface XiyijiService extends IService<XiyijiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}