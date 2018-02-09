var page = function() {
    return {
        $addForm : $("#addForm"),
        $mainCon : $("#mainCon"),
        $searchForm : $("#searchForm"),
        $grid_selector : $("#grid-table"),
        $pager_selector : $("#grid-pager"),
        // 新增
        onTapAdd : function() {
            var that = this;
            that.$addForm.show();
            that.$mainCon.hide();
            that.$searchForm.hide();
        },
        // 保存
        onTapSave : function() {
            var that = this;
            common.showTip('正在保存中...');
            setTimeout(function() {
                common.hideTip();
            }, 1000);
        },
        // 返回
        onTapBack : function() {
            var that = this;
            that.$addForm.hide();
            that.$mainCon.show();
            that.$searchForm.show();
        },
        // 编辑
        onTapEdit : function() {
            var that = this;
            that.checkRadio();
            var status = that.checkRadio();
            if (status != false) { // 这个是顶部编辑按钮，如果要使用，添加下面代码即可，非必须
                var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
                editParam(id)
            }

        },
        // 删除
        onTapDel : function() {
            // common.confirm('', function() {
            // console.log('sure to delete')
            // })
            delRows();

        },
        // 查看详情
        viewDetail : function(rowId) {
            var that = this;
            var rowData = that.$grid_selector.jqGrid('getRowData', rowId);
            $("#myModalDetail").modal('show');
        },
        // 审核通过
        toPutOn : function() {

            var that = this;
            that.checkRadio(function() {
                //对话框
                $.confirm({
                    title: '审核',
                    theme: 'white',
                    content: '你确定要通过审核吗',
                    type: 'blue',
                    animation: 'scale',
                    typeAnimated: true,
                    buttons: {
                        ok: {
                            text: "确定",
                            btnClass: 'btn-primary',
                            keys: ['enter'],
                            action: function(){
                                updateRows(true);
                            }
                        },
                        cancel: {
                            text: "取消",
                            btnClass: 'btn-primary',
                            keys: ['esc'],
                            action:function () {
                                //	 alert("你点击了取消按钮！")
                            }
                        }
                    }
                });
            });
        },
        // 审核不通过
        toPutDown : function() {
            var that = this;
            that.checkRadio(function() {
                //对话框
                $.confirm({
                    title: '审核',
                    theme: 'white',
                    content: '你确定要拒绝通过审核吗？',
                    type: 'blue',
                    animation: 'scale',
                    typeAnimated: true,
                    buttons: {
                        ok: {
                            text: "确定",
                            btnClass: 'btn-primary',
                            keys: ['enter'],
                            action: function(){
                                updateRows(false);
                            }
                        },
                        cancel: {
                            text: "取消",
                            btnClass: 'btn-primary',
                            keys: ['esc'],
                            action:function () {
                                //	 alert("你点击了取消按钮！")
                            }
                        }
                    }
                });
            });
        },
        // 确认订单
        toConfirm : function(obj) {
            var that = this, html = '', $currModal = $(obj).parents('.modal');
            html += '<div class="">请选择配送方式：';
            html += '<select class="select-sm"><option value="AL">编码</option><option value="AK">名称</option></select>';
            html += '</div>';
            $currModal.find('.modal-body').html(html);
            $(obj).attr('onclick', '');
        },
        initMainGrid : function() { // 初始化
            var userAccount   = $("#userAccount").val();
            var goods_status  =  $("#goods_status option:selected").val();
            var detailAddress =  $("#detailAddress").val();
            var province = $("#province").val();
            var city = $("#city").val();
            var district = $("#district").val();
            var that = this;
            var buildGridObj = {
                datatype : "json",
                mtype : 'post',
                postData : {
                    "userAccount":userAccount,
                    "goods_status":goods_status,
                    "province":province,
                    "city":city,
                    "district":district,
                    "detailAddress":detailAddress
                },
                url : '#',// 默认不去请求数据，只显示表格头部
                mtype : 'post',
                height : 400,
                autowidth : true,
                colNames : [ 'ID', '商品ID', '商品名称', '单价(元)', '折扣(折)', '商品分类', '销量',
                    '库存','状态', '时间', '操作' ],
                colModel : [// 当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。如果设置多于一个，那么只选取第一个，其他被忽略
                    {
                        name : 'id',
                        index : 'id',
                        width : 30,
                        sorttype : "int",
                        key : true,
                        editable : false,
                        editoptions : {
                            size : "20",
                            maxlength : "30"
                        }
                    }, {
                        name : 'goodsId',
                        index : 'goodsId',
                        width : 60,
                        hidden : true
                    }, {
                        name : 'goodsName',
                        index : 'goodsName',
                        sortable: true,
                        editable : true,
                        edittype : "text",
                        width : 90
                    }, {
                        name : 'goodsPrice',
                        index : 'goodsPrice',
                        sortable: true,
                        editable : true,
                        edittype : "text",
                        width : 70
                    }, {
                        name : 'discount',
                        index : 'discount',
                        sortable: true,
                        editable : true,
                        edittype : "text",
                        width : 50
                    }, {
                        name : 'goodsType',
                        index : 'goodsType',
                        sortable: true,
                        editable : true,
                        edittype : "text",
                        width : 90
                    }, {
                        name : 'sales',
                        index : 'sales',
                        editable : false,
                        width : 60
                    }, {
                        name : 'stock',
                        index : 'stock',
                        editable : true,
                        sortable: true,
                        edittype : "text",
                        width : 60
                    }, {
                        name : 'goodsStatus',
                        index : 'goodsStatus',
                        editable : true,
                        edittype : "text",
                        width : 60
                    },
                    {
                        name : 'updateTime',
                        index : 'updateTime',
                        editable : true,
                        editoptions : { // 这部分使用日期控件
                            dataInit : function(e) {
                                $(e).datetimepicker({
                                    language : "zh-CN",// 语言
                                    format : "yyyy-mm-dd hh:ii:ss",
                                    autoclose : true,
                                    todayBtn : true,
                                    pickerPosition : "bottom-left"
                                });
                                $(this).click(function(e) {// 选中时间后隐藏
                                    $(e).parent().datepicker('hide');
                                });
                            }
                        },
                        sortable : false,
                        width : 100
                    },
                    {
                        name : 'edit',
                        index : 'edit',
                        width : 100,
                        height : 300,
                        align : "right"
                    }, ],
                rowList : [ 10, 20, 30 ],
                pager : "#grid-pager",
                viewrecords : true,
                multiselect : true,
                multiboxonly : true,
                altRows : true,
                rownumbers : true,// 如果为ture则会在表格左边新增一列，显示行顺序号
                sortable:true,
                sortorder:'asc',
                editurl : "/goods/update",
                caption : '订单列表'

            }
            common.buildGrid(that.$grid_selector, buildGridObj,
                that.pager_selector);
        },
        // 在编辑时判断是否选择一行，没选择提醒选择
        checkRadio : function(callback) {
            var that = this;
            var flag = that.$grid_selector.find(
                'tr input[type="checkbox"]:checked').eq(0).val();
            if (!flag) {
                layer.msg('请选择操作行');
                return false;
            } else {
                if (callback)
                    callback();
            }

        },
        // 顶部查询按钮查询数据
        query : function() { // 去查询数据
            var userAccount   = $("#userAccount").val();
            var goods_status  =  $("#goods_status option:selected").val();
            var province = $("#province").val();
            var city = $("#city").val();
            var district = $("#district").val();
            var detailAddress =  $("#detailAddress").val();
            $("#grid-table")
                .jqGrid(
                    'setGridParam',
                    {
                        url : "/goods/getGoodsAdminList",
                        postData : {
                            "userAccount":userAccount,
                            "goods_status":goods_status,
                            "detailAddress":detailAddress,
                            "province":province,
                            "city":city,
                            "district":district
                            /* goodsId*/
                        },
                        page : page.pager_selector,
                        loadComplete : function() {// 再加载完数据后，添加按钮
                            // 获取表格的所有列ID
                            var ids = $("#grid-table").jqGrid(
                                'getDataIDs');
                            for (var i = 0; i < ids.length; i++) {
                                var id = ids[i];
                                var editBtn = "<div class='btnBox'> "
                                    + "<button type='button'  onclick='editParam("
                                    + id
                                    + ")'>编辑</button>"
                                    + "<button type='button' onclick='saveParam("
                                    + id
                                    + ")'>保存</button>"
                                    + "<button type='button'  onclick='cancelParam("
                                    + id + ")'>取消</button> </div>"
                                // 给每一列添加操作按钮
                                $("#grid-table").jqGrid('setRowData',
                                    ids[i], {
                                        edit : editBtn
                                    });
                            }
                        }
                    }).trigger('reloadGrid');// 重新载入
        }

    }
}();

// 编辑
function editParam(rowId) {
    var parameter = {
        oneditfunc : function(rowid) { // 在行成功转为编辑模式下触发的事件，参数为此行数据id
            // alert("edited" + rowid);
        }
    }
    $("#grid-table").editRow(rowId);// 开启可编辑模式
    // jQuery("#grid-table").editRow(rowId,parameter); //如果需要参数
    $('#grid-table').jqGrid('editRow', rowId, true);// 开启可编辑模式
    // $('#grid-table' ).jqGrid('editRow', rowId,
    // true,pickdates(rowId));//开启可编辑模式
}

// 保存
function saveParam(rowId) {
    // 获取行ID
    var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
    // 获取表格中的一行数据
    var rowDatas = $("#grid-table").jqGrid('getRowData', id);
    var parameter = {
        url : "goods/update", // 代替jqgrid中的editurl
        mtype : "POST",
        extraparam : {
            "id" : rowDatas.id,// colModel中带有editable:false，或者不可以编辑时可以这样取值
            "goodsId" : rowDatas.goodsId,
            "goodsName" : $("#" + id + "_" + "goodsName").val(), // colModel中带有editable:true需要用这种方式取值，不然再编辑状态下取不到值
            "goodsPrice" : $("#" + id + "_" + "goodsPrice").val(),//
            "goodsType" : $("#" + id + "_" + "goodsType").val(),
            "sales" : $("#" + id + "_" + "sales").val(),
            "stock" : $("#" + id + "_" + "stock").val(),
            "updateTime" : $("#" + id + "_" + "updateTime").val(),
        },
        successfunc : function(data) { // 在成功请求后触发;事件参数为XHR对象，需要返回true/false;
            // alert(XHR.responseText);//接收后台返回的数据
            if (data.status == 200) {
                common.showTip('修改成功');
                setTimeout(function() {
                    common.hideTip();
                }, 2000);
                return true; // 返回false会使用修改前的数据填充,同时关闭编辑模式。
            } else {
                common.showTip('修改失败');
                setTimeout(function() {
                    common.hideTip();
                }, 2000);
                return false; // 返回true会使用修改后的数据填充当前行,同时关闭编辑模式。
            }

        }
    }
    $('#grid-table').saveRow(rowId, parameter);
}

function updateRows(isThrough) {
    var status = 0;
    if(isThrough==true){
        status = 1
    }
    var arr = new Array();
    var ids = $("#grid-table").jqGrid("getGridParam", "selarrrow");
    for(var j=0;j<ids.length;j++){
        rowData = $("#grid-table").jqGrid('getRowData',ids[j]);
        arr[j] = rowData.goodsId;
    }
    $.ajax({
        type: "POST",
        url: "goods/authenticate",
        data: "goodsIds="+arr+"&"+"status="+status,
        beforeSend: function() {
            common.showTip('处理中...');
            setTimeout(function() {
                common.hideTip();
            }, 2000);
        },
        error:function(){
            common.showTip('请求失败');
            setTimeout(function() {
                common.hideTip();
                page.query();
            }, 1000);
        },
        success: function(msg){
            console.log(msg);
            if(msg.status==200){
                var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
                var len = selectedRowIds.length;
                /* for (var i = 0; i < len; i++) {
                     $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
                 }
 */
                common.showTip('审核成功');
                setTimeout(function() {
                    page.query();
                    common.hideTip();
                }, 1500);
            }else{
                common.showTip('审核失败');
                setTimeout(function() {
                    common.hideTip();
                }, 500);
            }
        }
    });


}
function delRows() {
    var arr = new Array();
    var ids = $("#grid-table").jqGrid("getGridParam", "selarrrow");
    for(var j=0;j<ids.length;j++){
        rowData = $("#grid-table").jqGrid('getRowData',ids[j]);
        arr[j] = rowData.goodsId;
    }
    $.ajax({
        type: "POST",
        url: "goods/del",
        data: "goodsIds="+arr,
        beforeSend: function() {
            common.showTip('正在删除中...');
            setTimeout(function() {
                page.query();
                common.hideTip();
            }, 2000);
        },
        error:function(){
            common.showTip('请求失败');
            setTimeout(function() {
                common.hideTip();
            }, 1000);
        },
        success: function(msg){
            console.log(msg);
            if(msg.status==200){
                var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
                var len = selectedRowIds.length;
                for (var i = 0; i < len; i++) {
                    $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
                }

                common.showTip('删除成功');
                setTimeout(function() {
                    page.query();
                    common.hideTip();
                }, 1500);
            }else{
                common.showTip('操作失败');
                setTimeout(function() {
                    common.hideTip();
                }, 500);
            }
        }
    });


}
// 定义取消操作
function cancelParam(rowId) {
    $('#grid-table').restoreRow(rowId); // 用修改前的数据填充当前行
}
// function pickdates(id) {
// jQuery("#" + id + "_updateTime", "#grid-table").bind("click",
// function() {
// //WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd
// HH:mm:ss',alwaysUseStartDate:true});
// })
//
// }
$(function() {
    page.initMainGrid();
});