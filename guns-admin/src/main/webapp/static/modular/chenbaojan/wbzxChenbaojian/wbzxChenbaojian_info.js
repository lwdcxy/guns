/**
 * 初始化呈报件登记详情对话框
 */
var WbzxChenbaojianInfoDlg = {
    wbzxChenbaojianInfoData : {}
};

/**
 * 清除数据
 */
WbzxChenbaojianInfoDlg.clearData = function() {
    this.wbzxChenbaojianInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WbzxChenbaojianInfoDlg.set = function(key, val) {
    this.wbzxChenbaojianInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WbzxChenbaojianInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WbzxChenbaojianInfoDlg.close = function() {
    parent.layer.close(window.parent.WbzxChenbaojian.layerIndex);
}

/**
 * 收集数据
 */
WbzxChenbaojianInfoDlg.collectData = function() {
    this
    .set('id')
    .set('chenbaojianNo')
    .set('chenbaojiancolName')
    .set('chenbaojiancolTime')
    .set('chenbaojiancolUser');
}

/**
 * 提交添加
 */
WbzxChenbaojianInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wbzxChenbaojian/add", function(data){
        Feng.success("添加成功!");
        window.parent.WbzxChenbaojian.table.refresh();
        WbzxChenbaojianInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wbzxChenbaojianInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WbzxChenbaojianInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wbzxChenbaojian/update", function(data){
        Feng.success("修改成功!");
        window.parent.WbzxChenbaojian.table.refresh();
        WbzxChenbaojianInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wbzxChenbaojianInfoData);
    ajax.start();
}

$(function() {

});
