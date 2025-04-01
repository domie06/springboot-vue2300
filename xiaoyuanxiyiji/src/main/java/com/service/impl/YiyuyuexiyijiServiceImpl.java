package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.YiyuyuexiyijiDao;
import com.entity.YiyuyuexiyijiEntity;
import com.service.YiyuyuexiyijiService;
import com.entity.view.YiyuyuexiyijiView;

/**
 * 已预约洗衣机 服务实现类
 * @since 2021-03-15
 */
@Service("yiyuyuexiyijiService")
@Transactional
public class YiyuyuexiyijiServiceImpl extends ServiceImpl<YiyuyuexiyijiDao, YiyuyuexiyijiEntity> implements YiyuyuexiyijiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YiyuyuexiyijiView> page =new Query<YiyuyuexiyijiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
