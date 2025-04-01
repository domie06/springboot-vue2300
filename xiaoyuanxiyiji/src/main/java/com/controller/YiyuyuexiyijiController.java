package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.XiyijiEntity;
import com.service.XiyijiService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.YiyuyuexiyijiEntity;

import com.service.YiyuyuexiyijiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 已预约洗衣机
 * 后端接口
 * @author
 * @email
 * @date 2021-03-15
*/
@RestController
@Controller
@RequestMapping("/yiyuyuexiyiji")
public class YiyuyuexiyijiController {
    private static final Logger logger = LoggerFactory.getLogger(YiyuyuexiyijiController.class);

    @Autowired
    private XiyijiService xiyijiService;

    @Autowired
    private YiyuyuexiyijiService yiyuyuexiyijiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = null;
        if(request.getSession().getAttribute("role").equals("用户")){
            params.put("yhTypes",request.getSession().getAttribute("userId"));
            page = yiyuyuexiyijiService.queryPage(params);
        }else{
            page = yiyuyuexiyijiService.queryPage(params);
        }

        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        YiyuyuexiyijiEntity yiyuyuexiyiji = yiyuyuexiyijiService.selectById(id);
        if(yiyuyuexiyiji!=null){
            return R.ok().put("data", yiyuyuexiyiji);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YiyuyuexiyijiEntity yiyuyuexiyiji, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<YiyuyuexiyijiEntity> queryWrapper = new EntityWrapper<YiyuyuexiyijiEntity>()
            .eq("xyj_types", yiyuyuexiyiji.getXyjTypes())
            .eq("yh_types", yiyuyuexiyiji.getYhTypes())
            .eq("hour", yiyuyuexiyiji.getHour())
            .eq("money", yiyuyuexiyiji.getMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiyuyuexiyijiEntity yiyuyuexiyijiEntity = yiyuyuexiyijiService.selectOne(queryWrapper);
        if(yiyuyuexiyijiEntity==null){
            yiyuyuexiyijiService.insert(yiyuyuexiyiji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YiyuyuexiyijiEntity yiyuyuexiyiji, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<YiyuyuexiyijiEntity> queryWrapper = new EntityWrapper<YiyuyuexiyijiEntity>()
            .notIn("id",yiyuyuexiyiji.getId())
            .eq("xyj_types", yiyuyuexiyiji.getXyjTypes())
            .eq("yh_types", yiyuyuexiyiji.getYhTypes())
            .eq("hour", yiyuyuexiyiji.getHour())
            .eq("money", yiyuyuexiyiji.getMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiyuyuexiyijiEntity yiyuyuexiyijiEntity = yiyuyuexiyijiService.selectOne(queryWrapper);
        if(yiyuyuexiyijiEntity==null){
            yiyuyuexiyijiService.updateById(yiyuyuexiyiji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer ids){
        YiyuyuexiyijiEntity yiyuyuexiyiji = yiyuyuexiyijiService.selectById(ids);
        XiyijiEntity xiyiji = xiyijiService.selectById(yiyuyuexiyiji.getXyjTypes());
        if(xiyiji  == null){
            return R.error();
        }
        xiyiji.setXyjztTypes(1);
        xiyijiService.updateById(xiyiji);
        yiyuyuexiyijiService.deleteById(ids);
        return R.ok();
    }
}

