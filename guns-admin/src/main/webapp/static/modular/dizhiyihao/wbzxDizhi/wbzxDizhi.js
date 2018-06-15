/**
 * 低值易耗管理初始化
 */
var WbzxDizhi = {
    id: "WbzxDizhiTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
WbzxDizhi.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '物品名称', field: 'dizhiName', visible: true, align: 'center', valign: 'middle'},
            {title: '规格', field: 'dizhiGuige', visible: true, align: 'center', valign: 'middle'},
            {title: '单位', field: 'dizhiDanwei', visible: true, align: 'center', valign: 'middle'},
            {title: '数量', field: 'dizhiShuliang', visible: true, align: 'center', valign: 'middle'},
            {title: '类别', field: 'dizhiLeibie', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'dizhiZhuangtai', visible: true, align: 'center', valign: 'middle'},
            {title: '使用部门', field: 'dizhiBumen', visible: true, align: 'center', valign: 'middle'},
            {title: '使用人', field: 'dizhiUser', visible: true, align: 'center', valign: 'middle'},
            {title: '存放位置', field: 'dizhiWeizhi', visible: true, align: 'center', valign: 'middle'},
            {title: '购入日期', field: 'dizhiTime', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'dizhiBeizhu', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
WbzxDizhi.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        WbzxDizhi.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加低值易耗
 */
WbzxDizhi.openAddWbzxDizhi = function () {
    var index = layer.open({
        type: 2,
        title: '添加低值易耗',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wbzxDizhi/wbzxDizhi_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看低值易耗详情
 */
WbzxDizhi.openWbzxDizhiDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '低值易耗详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wbzxDizhi/wbzxDizhi_update/' + WbzxDizhi.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除低值易耗
 */
WbzxDizhi.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wbzxDizhi/delete", function (data) {
            Feng.success("删除成功!");
            WbzxDizhi.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wbzxDizhiId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询低值易耗列表
 */
WbzxDizhi.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    WbzxDizhi.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = WbzxDizhi.initColumn();
    var table = new BSTable(WbzxDizhi.id, "/wbzxDizhi/list", defaultColunms);
    table.setPaginationType("client");
    WbzxDizhi.table = table.init();
});
