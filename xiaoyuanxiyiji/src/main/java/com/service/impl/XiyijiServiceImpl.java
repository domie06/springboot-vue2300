package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.XiyijiDao;
import com.entity.XiyijiEntity;
import com.service.XiyijiService;
import com.entity.view.XiyijiView;

/**
 * 洗衣机 服务实现类
 * @since 2021-03-15
 */
@Service("xiyijiService")
@Transactional
public class XiyijiServiceImpl extends ServiceImpl<XiyijiDao, XiyijiEntity> implements XiyijiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XiyijiView> page =new Query<XiyijiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
