package com.stylefeng.guns.modular.equipment.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.WbzxOilcan;
import com.stylefeng.guns.modular.equipment.service.IWbzxOilcanService;

/**
 * 油罐台账控制器
 *
 * @author fengshuonan
 * @Date 2018-05-19 18:29:48
 */
@Controller
@RequestMapping("/wbzxOilcan")
public class WbzxOilcanController extends BaseController {

    private String PREFIX = "/equipment/wbzxOilcan/";

    @Autowired
    private IWbzxOilcanService wbzxOilcanService;

    /**
     * 跳转到油罐台账首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wbzxOilcan.html";
    }

    /**
     * 跳转到添加油罐台账
     */
    @RequestMapping("/wbzxOilcan_add")
    public String wbzxOilcanAdd() {
        return PREFIX + "wbzxOilcan_add.html";
    }

    /**
     * 跳转到修改油罐台账
     */
    @RequestMapping("/wbzxOilcan_update/{wbzxOilcanId}")
    public String wbzxOilcanUpdate(@PathVariable Integer wbzxOilcanId, Model model) {
        WbzxOilcan wbzxOilcan = wbzxOilcanService.selectById(wbzxOilcanId);
        model.addAttribute("item",wbzxOilcan);
        LogObjectHolder.me().set(wbzxOilcan);
        return PREFIX + "wbzxOilcan_edit.html";
    }

    /**
     * 获取油罐台账列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return wbzxOilcanService.selectList(null);
    }

    /**
     * 新增油罐台账
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WbzxOilcan wbzxOilcan) {
        wbzxOilcanService.insert(wbzxOilcan);
        return SUCCESS_TIP;
    }

    /**
     * 删除油罐台账
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wbzxOilcanId) {
        wbzxOilcanService.deleteById(wbzxOilcanId);
        return SUCCESS_TIP;
    }

    /**
     * 修改油罐台账
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WbzxOilcan wbzxOilcan) {
        wbzxOilcanService.updateById(wbzxOilcan);
        return SUCCESS_TIP;
    }

    /**
     * 油罐台账详情
     */
    @RequestMapping(value = "/detail/{wbzxOilcanId}")
    @ResponseBody
    public Object detail(@PathVariable("wbzxOilcanId") Integer wbzxOilcanId) {
        return wbzxOilcanService.selectById(wbzxOilcanId);
    }
}
