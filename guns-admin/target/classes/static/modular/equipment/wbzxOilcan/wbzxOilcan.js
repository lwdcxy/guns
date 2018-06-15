/**
 * 油罐台账管理初始化
 */
var WbzxOilcan = {
    id: "WbzxOilcanTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
WbzxOilcan.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'oilcanName', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'oilcanParameter', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'oilcanRecord', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
WbzxOilcan.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        WbzxOilcan.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加油罐台账
 */
WbzxOilcan.openAddWbzxOilcan = function () {
    var index = layer.open({
        type: 2,
        title: '添加油罐台账',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wbzxOilcan/wbzxOilcan_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看油罐台账详情
 */
WbzxOilcan.openWbzxOilcanDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '油罐台账详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wbzxOilcan/wbzxOilcan_update/' + WbzxOilcan.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除油罐台账
 */
WbzxOilcan.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wbzxOilcan/delete", function (data) {
            Feng.success("删除成功!");
            WbzxOilcan.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wbzxOilcanId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询油罐台账列表
 */
WbzxOilcan.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    WbzxOilcan.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = WbzxOilcan.initColumn();
    var table = new BSTable(WbzxOilcan.id, "/wbzxOilcan/list", defaultColunms);
    table.setPaginationType("client");
    WbzxOilcan.table = table.init();
});
