;(function($){  
/** 
 * jqGrid Chinese Translation 
 * Lun Jun v5.rikugun@gmail.com 
 * http://rikugun.iteye.com/blog/  
 * Dual licensed under the MIT and GPL licenses: 
 * http://www.opensource.org/licenses/mit-license.php 
 * http://www.gnu.org/licenses/gpl.html 
**/  
$.jgrid = {};  
  
$.jgrid.defaults = {  
    recordtext: "行",  
    loadtext: "读取中...",  
    pgtext : "/"  
};  
$.jgrid.search = {  
    caption: "搜索...",  
    Find: "查找",  
    Reset: "重置",  
    odata : ['等于', '不等于', '小于', '小于等于','大于','大于等于', '开始于','结束于','包含' ]  
};  
$.jgrid.edit = {  
    addCaption: "添加记录",  
    editCaption: "编辑记录",  
    bSubmit: "提交",  
    bCancel: "取消",  
    bClose: "关闭",  
    processData: "处理中...",  
    msg: {  
        required:"此字段必需",  
        number:"请输入有效数字",  
        minValue:"输入值必须大于等于",  
        maxValue:"输入值必须小于等于",  
        email: "这不是有效的e-mail"  
    }  
};  
$.jgrid.del = {  
    caption: "删除",  
    msg: "删除所选记录?",  
    bSubmit: "删除",  
    bCancel: "取消",  
    processData: "处理中..."  
};  
$.jgrid.nav = {  
    edittext: " ",  
    edittitle: "编辑所选行",  
    addtext:" ",  
    addtitle: "添加行",  
    deltext: " ",  
    deltitle: "删除所选行",  
    searchtext: " ",  
    searchtitle: "查找",  
    refreshtext: "",  
    refreshtitle: "刷新表格",  
    alertcap: "警告",  
    alerttext: "请选择行"  
};  
// setcolumns module  
$.jgrid.col ={  
    caption: "显示/隐藏行",  
    bSubmit: "提交",  
    bCancel: "取消"     
};  
$.jgrid.errors = {  
    errcap : "错误",  
    nourl : "没有设置url",  
    norecords: "没有要处理的记录"  
};  
})(jQuery); 