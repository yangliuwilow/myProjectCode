$(function(){
	//表格行，鼠标放上去变色
    $(".tr:odd").css("background", "#fafafa");
	$(".tr:odd").each(function(){
		$(this).hover(function(){
			 $(this).css("background-color", "#f5fcff");
		}, function(){
             $(this).css("background-color", "#fafafa");
		});
	});
	$(".tr:even").each(function(){
		$(this).hover(function(){
			 $(this).css("background-color", "#f5fcff");
		}, function(){  //#fafafa none repeat scroll 0 0
			 $(this).css("background-color", "#fff");
		});
	}); 
	 
	/*ie6,7下拉框美化*/
   /* if ( $.browser.msie ){
    	if($.browser.version == '7.0' || $.browser.version == '6.0'){
    		$('.select').each(function(i){
			   $(this).parents('.select_border,.select_containers').width($(this).width()+5); 
			 });
    		
    	}
    }*/
    
     //$("#editform").validate({
    jQuery('form').validate({
    	submitHandler: function(form) {//提交按钮置灰
          /*  $(form).find(":submit").attr("disabled", true).attr("value","处理中...");*/
            form.submit();
        },errorPlacement: function(error, element) {//单选按钮复选框错误提示信息
            if ( element.is(":radio") )
                error.appendTo( element.parent());
              else if ( element.is(":checkbox") )
                error.appendTo ( element.parent());
              else
                error.appendTo( element.parent());
            }
    });//jquery.metadata.js  验证
    var $pageNumber = $("#currentPage");
    var $pageSize = $("#pageSize");
    var $listForm = $("#listForm");
    var $pageTotal = $("#pageTotal");
   // tableColResizable('list_table'); 可拖拽table
});
// 页码跳转
$.pageSkip = function(pageNumber) {
    $("#currentPage").val(pageNumber);
    $("#listForm").submit();
    return false;
}
/**
 * iframe 打开新的页面
 * @param url
 */
function reloadcode(url) {
		var rnd = document.getElementById('rightMain');
		rnd.setAttribute('src', url);
}
/**
 * 表格宽度移动js
 * @param tableClass
 */
function  tableColResizable(tableClass){
	$("."+tableClass).colResizable({
	    liveDrag:true,
	    gripInnerHtml:"<div class='grip'></div>", 
	    draggingClass:"dragging", 
	    minWidth:30
	  });
}
 
/**
 * 删除确认框
 * @param url  请求连接url
 */
function delConfirm(httpurl,id){
	  var submit = function (v, h, f) {
		    if (v == 'ok') {
		        $.jBox.tip("正在删除数据...", 'loading');
                $.ajax({type : "POST",
                     url:''+httpurl,async:false,data:{id:id},success:function(data){
                        var res = eval('(' + data + ')');
                        var resCode = res['resCode'];
                        if (resCode == 'yes') {
                            document.forms[0].submit();
                            window.setTimeout(function () { $.jBox.tip('删除成功。', 'success'); }, 50);
                        }else{
                            window.setTimeout(function () { $.jBox.tip('删除错误。', 'success'); }, 50);
                        }
                    }
                })
		    }
		    else if (v == 'cancel') {
		        // 取消
		    }
		    return true; //close
	  };
	  $.jBox.confirm("确定要删除数据吗？", "提示", submit);
}

/**
 *  全选
 * @param maincheckbox   全选 idq
 * @param checkename     子复选框name
 */
function checkall(maincheckbox,checkename){
    var  select =$("#"+maincheckbox).attr("checked");
    if(!select){
        select=false;
    }
    $(":checkbox[name='"+checkename+"']").attr("checked",select);
}
/**
 *  子选项全部选中时候 选中父选项
 * @param maincheckbox  全选 id
 * @param checkename    子复选框name
 */
function childcheck(maincheckbox,checkename){
    if($(":checkbox[name='"+checkename+"']:checked").length>=$(":checkbox[name='"+checkename+"']").length){
        $("#"+maincheckbox).attr("checked","checked");
    }else{
        $("#"+maincheckbox).removeAttr("checked");
    }
}
/**
 * 提示输入文字数
 * @param textareaNamezzjs   文本框ID
 * @param spanName           显示DIV(ID)
 */
function countChar(textareaNamezzjs,spanName){
    document.getElementById(spanName).innerHTML=document.getElementById(textareaNamezzjs).value.length;
}

/**
 * 排序
 * @param orderBy      排序字段
 * @param defaultOrder 升降序（desc/asc）
 */
function sort(orderBy, defaultOrder) {
    if ($("#orderBy").val() == orderBy) {
        if ($("#order").val() == "") {
            $("#order").val(defaultOrder);
        } else if ($("#order").val() == "desc") {
            $("#order").val("asc");
        } else if ($("#order").val() == "asc") {
            $("#order").val("desc");
        }
    } else {
        $("#orderBy").val(orderBy);
        $("#order").val(defaultOrder);
    }
    document.forms[0].submit();
}