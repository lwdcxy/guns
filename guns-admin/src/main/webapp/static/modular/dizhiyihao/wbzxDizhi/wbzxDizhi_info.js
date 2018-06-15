/**
 * 初始化低值易耗详情对话框
 */
var WbzxDizhiInfoDlg = {
    wbzxDizhiInfoData : {}
};

/**
 * 清除数据
 */
WbzxDizhiInfoDlg.clearData = function() {
    this.wbzxDizhiInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WbzxDizhiInfoDlg.set = function(key, val) {
    this.wbzxDizhiInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WbzxDizhiInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WbzxDizhiInfoDlg.close = function() {
    parent.layer.close(window.parent.WbzxDizhi.layerIndex);
}

/**
 * 收集数据
 */
WbzxDizhiInfoDlg.collectData = function() {
    this
    .set('id')
    .set('dizhiName')
    .set('dizhiGuige')
    .set('dizhiDanwei')
    .set('dizhiShuliang')
    .set('dizhiLeibie')
    .set('dizhiZhuangtai')
    .set('dizhiBumen')
    .set('dizhiUser')
    .set('dizhiWeizhi')
    .set('dizhiTime')
    .set('dizhiBeizhu');
}

/**
 * 提交添加
 */
WbzxDizhiInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wbzxDizhi/add", function(data){
        Feng.success("添加成功!");
        window.parent.WbzxDizhi.table.refresh();
        WbzxDizhiInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wbzxDizhiInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WbzxDizhiInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wbzxDizhi/update", function(data){
        Feng.success("修改成功!");
        window.parent.WbzxDizhi.table.refresh();
        WbzxDizhiInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wbzxDizhiInfoData);
    ajax.start();
}

$(function() {

});
