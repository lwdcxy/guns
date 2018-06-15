package com.stylefeng.guns.modular.dizhiyihao.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.util.ToolUtil;

import org.springframework.web.bind.annotation.RequestParam;

import com.stylefeng.guns.modular.system.model.WbzxChenbaojian;
import com.stylefeng.guns.modular.system.model.WbzxDizhi;
import com.stylefeng.guns.modular.dizhiyihao.service.IWbzxDizhiService;

/**
 * 低值易耗控制器
 *
 * @author fengshuonan
 * @Date 2018-05-19 17:35:21
 */
@Controller
@RequestMapping("/wbzxDizhi")
public class WbzxDizhiController extends BaseController {

    private String PREFIX = "/dizhiyihao/wbzxDizhi/";

    @Autowired
    private IWbzxDizhiService wbzxDizhiService;

    /**
     * 跳转到低值易耗首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wbzxDizhi.html";
    }

    /**
     * 跳转到添加低值易耗
     */
    @RequestMapping("/wbzxDizhi_add")
    public String wbzxDizhiAdd() {
        return PREFIX + "wbzxDizhi_add.html";
    }

    /**
     * 跳转到修改低值易耗
     */
    @RequestMapping("/wbzxDizhi_update/{wbzxDizhiId}")
    public String wbzxDizhiUpdate(@PathVariable Integer wbzxDizhiId, Model model) {
        WbzxDizhi wbzxDizhi = wbzxDizhiService.selectById(wbzxDizhiId);
        model.addAttribute("item",wbzxDizhi);
        LogObjectHolder.me().set(wbzxDizhi);
        return PREFIX + "wbzxDizhi_edit.html";
    }

    /**
     * 获取低值易耗列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	
    	//判断 condition 是否有值
		if (ToolUtil.isEmpty(condition)) {
			//如果没有值，则表示全部查询
			return wbzxDizhiService.selectList(null);
		}else {
			//如果有值，则认为是按呈报件名称进行模糊查询
			EntityWrapper<WbzxDizhi> entityWrapper = new EntityWrapper<>();
			Wrapper<WbzxDizhi> wrapper = entityWrapper.like("dizhi_name", condition);
			return wbzxDizhiService.selectList(wrapper);		
		}
    	
//        return wbzxDizhiService.selectList(null);
    }

    /**
     * 新增低值易耗
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WbzxDizhi wbzxDizhi) {
        wbzxDizhiService.insert(wbzxDizhi);
        return SUCCESS_TIP;
    }

    /**
     * 删除低值易耗
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wbzxDizhiId) {
        wbzxDizhiService.deleteById(wbzxDizhiId);
        return SUCCESS_TIP;
    }

    /**
     * 修改低值易耗
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WbzxDizhi wbzxDizhi) {
        wbzxDizhiService.updateById(wbzxDizhi);
        return SUCCESS_TIP;
    }

    /**
     * 低值易耗详情
     */
    @RequestMapping(value = "/detail/{wbzxDizhiId}")
    @ResponseBody
    public Object detail(@PathVariable("wbzxDizhiId") Integer wbzxDizhiId) {
        return wbzxDizhiService.selectById(wbzxDizhiId);
    }
}
