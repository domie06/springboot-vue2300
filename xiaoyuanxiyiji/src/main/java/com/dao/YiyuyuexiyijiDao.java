package com.dao;

import com.entity.YiyuyuexiyijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YiyuyuexiyijiView;

/**
 * 已预约洗衣机 Dao 接口
 *
 * @since 2021-03-15
 */
public interface YiyuyuexiyijiDao extends BaseMapper<YiyuyuexiyijiEntity> {

   List<YiyuyuexiyijiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
