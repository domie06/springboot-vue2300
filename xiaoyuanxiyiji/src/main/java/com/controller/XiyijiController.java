package com.controller;

import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.YiyuyuexiyijiEntity;
import com.entity.YonghuEntity;
import com.service.YiyuyuexiyijiService;
import com.service.YonghuService;
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

import com.entity.XiyijiEntity;

import com.service.XiyijiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 洗衣机
 * 后端接口
 * @author
 * @email
 * @date 2021-03-15
*/
@RestController
@Controller
@RequestMapping("/xiyiji")
public class XiyijiController {
    private static final Logger logger = LoggerFactory.getLogger(XiyijiController.class);

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private XiyijiService xiyijiService;

    @Autowired
    private YiyuyuexiyijiService yiyuyuexiyijiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = xiyijiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        XiyijiEntity xiyiji = xiyijiService.selectById(id);
        if(xiyiji!=null){
            return R.ok().put("data", xiyiji);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiyijiEntity xiyiji, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<XiyijiEntity> queryWrapper = new EntityWrapper<XiyijiEntity>()
            .eq("name", xiyiji.getName())
            .eq("money", xiyiji.getMoney())
            .eq("xyjzt_types", xiyiji.getXyjztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiyijiEntity xiyijiEntity = xiyijiService.selectOne(queryWrapper);
        if("".equals(xiyiji.getImPhoto()) || "null".equals(xiyiji.getImPhoto())){
            xiyiji.setImPhoto(null);
        }
        if(xiyijiEntity==null){
            xiyiji.setXyjztTypes(1);
            xiyijiService.insert(xiyiji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiyijiEntity xiyiji, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<XiyijiEntity> queryWrapper = new EntityWrapper<XiyijiEntity>()
            .notIn("id",xiyiji.getId())
            .eq("name", xiyiji.getName())
            .eq("money", xiyiji.getMoney())
            .eq("xyjzt_types", xiyiji.getXyjztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiyijiEntity xiyijiEntity = xiyijiService.selectOne(queryWrapper);
        if("".equals(xiyiji.getImPhoto()) || "null".equals(xiyiji.getImPhoto())){
                xiyiji.setImPhoto(null);
        }
        if(xiyijiEntity==null){
            xiyijiService.updateById(xiyiji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        xiyijiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/subscribe")
    public R subscribe(Integer ids,Integer hour, HttpServletRequest request){
        if(!request.getSession().getAttribute("role").equals("用户")){
            return R.error("只有用户可以进行预约哦");
        }
        XiyijiEntity xiyiji = xiyijiService.selectById(ids);
        if(xiyiji == null){
            return  R.error();
        }
        if(hour >= 10){
            return R.error("使用时间不能大于10小时");
        }
        if(hour == null || hour < 1){
            return R.error("使用时间不能为空或者小于1");
        }
        YiyuyuexiyijiEntity yiyuyuexiyiji = new YiyuyuexiyijiEntity();
        yiyuyuexiyiji.setCreateTime(new Date());
        yiyuyuexiyiji.setXyjTypes(xiyiji.getId());

        YonghuEntity userId = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
        if(userId == null){
            return R.error();
        }
        if(userId.getMoney() < hour*xiyiji.getMoney()){
            return R.error("您余额不足，请充值");
        }
        userId.setMoney(userId.getMoney() - hour*xiyiji.getMoney());

        yiyuyuexiyiji.setYhTypes((Integer) request.getSession().getAttribute("userId"));
        yiyuyuexiyiji.setHour(hour);
        yiyuyuexiyiji.setMoney(hour*xiyiji.getMoney());
        Wrapper<YiyuyuexiyijiEntity> queryWrapper = new EntityWrapper<YiyuyuexiyijiEntity>()
                .eq("xyj_types", yiyuyuexiyiji.getXyjTypes())
                .eq("yh_types", yiyuyuexiyiji.getYhTypes())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiyuyuexiyijiEntity yiyuyuexiyijiEntity = yiyuyuexiyijiService.selectOne(queryWrapper);
        if(yiyuyuexiyijiEntity==null){
            xiyiji.setXyjztTypes(2);
            yonghuService.updateById(userId);
            xiyijiService.updateById(xiyiji);
            yiyuyuexiyijiService.insert(yiyuyuexiyiji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }
}

