/**
 * 呈报件登记管理初始化
 */
var WbzxChenbaojian = {
    id: "WbzxChenbaojianTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
WbzxChenbaojian.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '呈报件编号', field: 'chenbaojianNo', visible: true, align: 'center', valign: 'middle'},
            {title: '呈报件名称', field: 'chenbaojiancolName', visible: true, align: 'center', valign: 'middle'},
            {title: '登记时间', field: 'chenbaojiancolTime', visible: true, align: 'center', valign: 'middle'},
            {title: '登记人', field: 'chenbaojiancolUser', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
WbzxChenbaojian.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        WbzxChenbaojian.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加呈报件登记
 */
WbzxChenbaojian.openAddWbzxChenbaojian = function () {
    var index = layer.open({
        type: 2,
        title: '添加呈报件登记',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wbzxChenbaojian/wbzxChenbaojian_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看呈报件登记详情
 */
WbzxChenbaojian.openWbzxChenbaojianDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '呈报件登记详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wbzxChenbaojian/wbzxChenbaojian_update/' + WbzxChenbaojian.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除呈报件登记
 */
WbzxChenbaojian.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wbzxChenbaojian/delete", function (data) {
            Feng.success("删除成功!");
            WbzxChenbaojian.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wbzxChenbaojianId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询呈报件登记列表
 */
WbzxChenbaojian.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    WbzxChenbaojian.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = WbzxChenbaojian.initColumn();
    var table = new BSTable(WbzxChenbaojian.id, "/wbzxChenbaojian/list", defaultColunms);
    table.setPaginationType("client");
    WbzxChenbaojian.table = table.init();
});
