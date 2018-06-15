/**
 * 初始化油罐台账详情对话框
 */
var WbzxOilcanInfoDlg = {
    wbzxOilcanInfoData : {}
};

/**
 * 清除数据
 */
WbzxOilcanInfoDlg.clearData = function() {
    this.wbzxOilcanInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WbzxOilcanInfoDlg.set = function(key, val) {
    this.wbzxOilcanInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WbzxOilcanInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WbzxOilcanInfoDlg.close = function() {
    parent.layer.close(window.parent.WbzxOilcan.layerIndex);
}

/**
 * 收集数据
 */
WbzxOilcanInfoDlg.collectData = function() {
    this
    .set('id')
    .set('oilcanName')
    .set('oilcanParameter')
    .set('oilcanRecord');
}

/**
 * 提交添加
 */
WbzxOilcanInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wbzxOilcan/add", function(data){
        Feng.success("添加成功!");
        window.parent.WbzxOilcan.table.refresh();
        WbzxOilcanInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wbzxOilcanInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WbzxOilcanInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wbzxOilcan/update", function(data){
        Feng.success("修改成功!");
        window.parent.WbzxOilcan.table.refresh();
        WbzxOilcanInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wbzxOilcanInfoData);
    ajax.start();
}

$(function() {

});
