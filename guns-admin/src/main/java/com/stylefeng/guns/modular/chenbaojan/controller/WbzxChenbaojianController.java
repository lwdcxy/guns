package com.stylefeng.guns.modular.chenbaojan.controller;

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
import com.stylefeng.guns.modular.chenbaojan.service.IWbzxChenbaojianService;

/**
 * 呈报件登记控制器
 *
 * @author fengshuonan
 * @Date 2018-05-19 17:02:24
 */
@Controller
@RequestMapping("/wbzxChenbaojian")
public class WbzxChenbaojianController extends BaseController {

    private String PREFIX = "/chenbaojan/wbzxChenbaojian/";

    @Autowired
    private IWbzxChenbaojianService wbzxChenbaojianService;

    /**
     * 跳转到呈报件登记首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wbzxChenbaojian.html";
    }

    /**
     * 跳转到添加呈报件登记
     */
    @RequestMapping("/wbzxChenbaojian_add")
    public String wbzxChenbaojianAdd() {
        return PREFIX + "wbzxChenbaojian_add.html";
    }

    /**
     * 跳转到修改呈报件登记
     */
    @RequestMapping("/wbzxChenbaojian_update/{wbzxChenbaojianId}")
    public String wbzxChenbaojianUpdate(@PathVariable Integer wbzxChenbaojianId, Model model) {
        WbzxChenbaojian wbzxChenbaojian = wbzxChenbaojianService.selectById(wbzxChenbaojianId);
        model.addAttribute("item",wbzxChenbaojian);
        LogObjectHolder.me().set(wbzxChenbaojian);
        return PREFIX + "wbzxChenbaojian_edit.html";
    }

    /**
     * 获取呈报件登记列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	
    	//判断 condition 是否有值
		if (ToolUtil.isEmpty(condition)) {
			//如果没有值，则表示全部查询
			return wbzxChenbaojianService.selectList(null);
		}else {
			//如果有值，则认为是按呈报件名称进行模糊查询
			EntityWrapper<WbzxChenbaojian> entityWrapper = new EntityWrapper<>();
			Wrapper<WbzxChenbaojian> wrapper = entityWrapper.like("chenbaojiancol_name", condition);
			return wbzxChenbaojianService.selectList(wrapper);		
		}
    	
   
    	
    }

    /**
     * 新增呈报件登记
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WbzxChenbaojian wbzxChenbaojian) {
        wbzxChenbaojianService.insert(wbzxChenbaojian);
        return SUCCESS_TIP;
    }

    /**
     * 删除呈报件登记
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wbzxChenbaojianId) {
        wbzxChenbaojianService.deleteById(wbzxChenbaojianId);
        return SUCCESS_TIP;
    }

    /**
     * 修改呈报件登记
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WbzxChenbaojian wbzxChenbaojian) {
        wbzxChenbaojianService.updateById(wbzxChenbaojian);
        return SUCCESS_TIP;
    }

    /**
     * 呈报件登记详情
     */
    @RequestMapping(value = "/detail/{wbzxChenbaojianId}")
    @ResponseBody
    public Object detail(@PathVariable("wbzxChenbaojianId") Integer wbzxChenbaojianId) {
        return wbzxChenbaojianService.selectById(wbzxChenbaojianId);
    }
}
