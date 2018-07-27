(function($){
	/**
	 * @param {Object} options
	 *  <li>errorElement <String> 默认 font</li>
	 *  <li>labelElement <String> 默认 label</li>
	 *
	 *  @since jquery.validate.js
	 */
	$.fn.validateForm = function(options){
		if(!options){
			options = {};
		}
		
		options.submitHandler = function(f) {
			$('input[type=submit]',$(f)).attr('disabled','disabled');
			//alert("admin.validate");
			f.submit();
		};
		options.errorElement = options.errorElement ? options.errorElement : 'font';
		options.labelElement = options.labelElement ? options.labelElement : 'label';
		options.ignore = options.ignore ? options.ignore : ':hidden';
		options.onkeyup = options.onkeyup ?  options.onkeyup : false;
		this.validate(options);

	    //将有必填标记的表单项，加上必填规则
//	    $("input,select,textarea",this).each(function(){
//	    	var op = $(this).parent();
//	    	if(op.is("li") && op.is(':visible')){
//	    		var span = op.find('em.requiredTag')
//	    		if(span.size() > 0 && span.is(":visible")){
//	    			addRequired(op,'input',options.labelElement);
//	    			addRequired(op,'select',options.labelElement);
//	    			addRequired(op,'textarea',options.labelElement);
//	    		}
//	    	}
//	    });

	    return this;
	}

//	function addRequired(op,tagName,labelElement){
//		if(op.find(tagName).size() > 0){
//			op.find(tagName).rules('add',{
//				//required: [true,'[' + $.trim(op.find(labelElement).text().replace('：','').replace('*','')) + ']']
//				required:true
//			})
//		}
//	}
})(jQuery);

function getContextPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    if("/base-web-boss"==projectName || "/sboss"==projectName){
    	return(localhostPaht+projectName);
    }else{
    	return localhostPaht;
    }
}



//自定义校验规则
 // 验证值必须大于特定值(不能等于)
jQuery.validator.addMethod("greaterThan", function(value, element, param) {
    return value > param;
}, $.validator.format("该数据项必须大于{0}"));

jQuery.validator.addMethod("compareDate", function(value, element, param) {
	//var startDate = jQuery(param).val() + " 00:00:00";//补全yyyy-MM-dd HH:mm:ss格式
    //value = value + " 00:00:00";
	var startDate = jQuery(param).val();
	var date1 = new Date(Date.parse(startDate.replace(/-/g, "/")));
    var date2 = new Date(Date.parse(value.replace(/-/g, "/")));
    return date1 <= date2;
}, $.validator.format("结束日期必须大于开始日期"));

//只能包括中文字、英文字母、数字和下划线
 jQuery.validator.addMethod("stringCheck", function(value, element) {
     return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
 }, "只能包括中文字、英文字母、数字和下划线");

 // 中文字两个字节
 jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {
     var length = value.length;
     for(var i = 0; i < value.length; i++){
         if(value.charCodeAt(i) > 127){
         length++;
        }
    }
    return this.optional(element) || ( length >= param[0] && length <= param[1] );
 }, "请确保输入的值在{0}-{1}个字节之间(一个中文字算2个字节)");
 
 //指定长度
 jQuery.validator.addMethod("targetLength", function(value, element, param) {
     var length = value.length;
    return this.optional(element) || ( length == param[0]);
 }, "只能输入{0}位有效数据");

 // 身份证号码验证
 jQuery.validator.addMethod("idCardNo", function(value, element) {
     //return this.optional(element) || isIdCardNo(value);
 	var length = value.length;
 	var reg = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
 	return this.optional(element) ||(length > 0 && reg.test(value));
 }, "身份证号码不正确");

 // 手机号码验证
 jQuery.validator.addMethod("mobile", function(value, element) {
     var length = value.length;
     var reg = /^[1][3-8]\d{9}$/;
     return this.optional(element) || (length == 11 && reg.test(value));
 }, "手机号码不正确");

 // 电话号码验证
 jQuery.validator.addMethod("phone", function(value, element) {
     var reg = /^([0-9]{2}-)?(0?[0-9]{2,3}\-)?[1-9]?[0-9]{7}$/;
     return this.optional(element) || (reg.test(value));
 }, "电话号码不正确");

 // 联系电话(手机/电话皆可)验证
 jQuery.validator.addMethod("phoneOrMobile", function(value,element) {
     var length = value.length;
     var mobile = /^[1][3-8]\d{9}$/;
     var tel = /^([0-9]{2}-)?(0?[0-9]{2,3}\-)?[1-9]?[0-9]{7}$/;
     return this.optional(element) || (tel.test(value) || mobile.test(value));

 }, "联系电话不正确");

 // 邮政编码验证
 jQuery.validator.addMethod("postCode", function(value, element) {
    var reg = /^[0-9]{6}$/;
    return this.optional(element) || (reg.test(value));
 }, "邮政编码格式不正确");
 
  //附件
 jQuery.validator.addMethod("accessory", function(value, element) {
    var reg = /\.(doc|docx|xls|xlsx|ppt|pdf|txt|rar|zip|jpg|jpeg|gif|bmp|png)$/i;
    return this.optional(element) || (reg.test(value));
 }, "禁止上传该格式的附件");
 
  //图片
 jQuery.validator.addMethod("image", function(value, element) {
    var reg = /\.(jpg|jpeg|gif|png)$/i;
    return this.optional(element) || (reg.test(value));
 }, "请上传正确的图片文件,格式为:(jpg|jpeg|gif|png)");
 
  //正则
 jQuery.validator.addMethod("regex", function(value, element, param) {
    return this.optional(element) || (param.test(value));
 }, "格式不正确");
 
/*  //中文姓名
 jQuery.validator.addMethod("username", function(value, element) {
    var reg = /^[\u4e00-\u9fa5]{2,4}$/;
    return this.optional(element) || (reg.test(value)); 
 }, "格式不正确,必须是由2-4为中文组成");*/
 
  //企业名称
 jQuery.validator.addMethod("companyname", function(value, element) {
    var reg = /[\u4E00-\u9FA5]{4,40}/;
    return this.optional(element) || (reg.test(value)); 
 }, "格式不正确,至少包含4个中文字符");
 
 //登陆交易密码
 jQuery.validator.addMethod("password", function(value, element) {
    var reg = /^\S{6,16}$/;
    return this.optional(element) || (reg.test(value));
 }, "密码不能小于6位或者大于16位");
 
//登陆图片验证码
 jQuery.validator.addMethod("captcha", function(value, element) {
    var reg = /^\S{4,4}$/;
    return this.optional(element) || (reg.test(value));
 }, "请输入四位验证码");

//验证密码格式
 jQuery.validator.addMethod("pwdCheck", function(value, element) {
	 var reg = /^[a-zA-Z0-9]{6,16}$/ ;
	 return this.optional(element) || (reg.test(value));
 }, "交易密码格式错误");
 
//手机验证码
 jQuery.validator.addMethod("captdcha", function(value, element) {
    var reg = /^\S{6,6}$/;
    return this.optional(element) || (reg.test(value));
 }, "请输入六位验证码");
 
 
 
 
 
//判断整数value是否等于0 
 jQuery.validator.addMethod("isIntEqZero", function(value, element) { 
      value=parseInt(value);      
      return this.optional(element) || value==0;       
 }, "整数必须为0"); 
   
 // 判断整数value是否大于0
 jQuery.validator.addMethod("isIntGtZero", function(value, element) { 
      value=parseInt(value);      
      return this.optional(element) || value>0;       
 }, "整数必须大于0");

// 判断整数value是否大于0
jQuery.validator.addMethod("isIntGtZeroLimit", function(value, element) {
    value=parseInt(value);
    return this.optional(element) || value>0;
}, "限额必须大于0");

// 判断整数value是否大于或等于0
 jQuery.validator.addMethod("isIntGteZero", function(value, element) { 
      value=parseInt(value);      
      return this.optional(element) || value>=0;       
 }, "整数必须大于或等于0");   
 
 // 判断整数value是否不等于0 
 jQuery.validator.addMethod("isIntNEqZero", function(value, element) { 
      value=parseInt(value);      
      return this.optional(element) || value!=0;       
 }, "整数必须不等于0");  
 
 // 判断整数value是否小于0 
 jQuery.validator.addMethod("isIntLtZero", function(value, element) { 
      value=parseInt(value);      
      return this.optional(element) || value<0;       
 }, "整数必须小于0");  
 
 // 判断整数value是否小于或等于0 
 jQuery.validator.addMethod("isIntLteZero", function(value, element) { 
      value=parseInt(value);      
      return this.optional(element) || value<=0;       
 }, "整数必须小于或等于0");  
 
 // 判断浮点数value是否等于0 
 jQuery.validator.addMethod("isFloatEqZero", function(value, element) { 
      value=parseFloat(value);      
      return this.optional(element) || value==0;       
 }, "浮点数必须为0"); 
   
 // 判断浮点数value是否大于0
 jQuery.validator.addMethod("isFloatGtZero", function(value, element) { 
      value=parseFloat(value);      
      return this.optional(element) || value>0;       
 }, "浮点数必须大于0"); 
   
 jQuery.validator.addMethod("isFloatGteZero", function(value, element) {
      value=parseFloat(value);      
      return this.optional(element) || value>=0;       
 }, "必须大于或等于0");   
 
 // 判断浮点数value是否不等于0 
 jQuery.validator.addMethod("isFloatNEqZero", function(value, element) { 
      value=parseFloat(value);      
      return this.optional(element) || value!=0;       
 }, "浮点数必须不等于0");  
 
 // 判断浮点数value是否小于0 
 jQuery.validator.addMethod("isFloatLtZero", function(value, element) { 
      value=parseFloat(value);      
      return this.optional(element) || value<0;       
 }, "浮点数必须小于0");  
 
 // 判断浮点数value是否小于或等于0 
 jQuery.validator.addMethod("isFloatLteZero", function(value, element) { 
      value=parseFloat(value);      
      return this.optional(element) || value<=0;       
 }, "浮点数必须小于或等于0");  
 
 // 判断浮点型  
 jQuery.validator.addMethod("isFloat", function(value, element) {       
      return this.optional(element) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
 }, "只能包含数字、小数点等字符"); 
  
 // 匹配integer
 jQuery.validator.addMethod("isInteger", function(value, element) {       
      return this.optional(element) || (/^[-\+]?\d+$/.test(value) && parseInt(value)>=0);       
 }, "匹配integer");  
  
 // 判断数值类型，包括整数和浮点数
 jQuery.validator.addMethod("isNumber", function(value, element) {       
      return this.optional(element) || /^[-\+]?\d+$/.test(value) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
 }, "匹配数值类型，包括整数和浮点数");  
 
 // 只能输入[0-9]数字
 jQuery.validator.addMethod("isDigits", function(value, element) {       
      return this.optional(element) || /^\d+$/.test(value);       
 }, "只能输入0-9数字");  
 
 // 判断中文字符 
 jQuery.validator.addMethod("isChinese", function(value, element) {       
      return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);       
 }, "只能包含中文字符。");   

 // 判断英文字符 
 jQuery.validator.addMethod("isEnglish", function(value, element) {       
      return this.optional(element) || /^[A-Za-z]+$/.test(value);       
 }, "只能包含英文字符。");   

 // 电话号码验证
 jQuery.validator.addMethod("isPhone", function(value, element) {    
   var tel = /^(\d{3,4}-?)?\d{7,9}$/g;    
   return this.optional(element) || (tel.test(value));    
 }, "请正确填写您的电话号码。");

 // 联系电话(手机/电话皆可)验证   
 jQuery.validator.addMethod("isTel", function(value,element) {   
     var length = value.length;   
     var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;   
     var tel = /^(\d{3,4}-?)?\d{7,9}$/g;       
     return this.optional(element) || tel.test(value) || (length==11 && mobile.test(value));   
 }, "请正确填写您的联系方式"); 

  // 匹配qq      
 jQuery.validator.addMethod("isQq", function(value, element) {       
      return this.optional(element) || /^[1-9]\d{4,12}$/;       
 }, "匹配QQ");   

  // 邮政编码验证    
 jQuery.validator.addMethod("isZipCode", function(value, element) {    
   var zip = /^[0-9]{6}$/;    
   return this.optional(element) || (zip.test(value));    
 }, "请正确填写您的邮政编码。");  
 
 // 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。      
 jQuery.validator.addMethod("isPwd", function(value, element) {       
      return this.optional(element) || /^[a-zA-Z]\\w{6,17}$/.test(value);       
 }, "以字母开头，长度在6-17之间，只能包含字符、数字和下划线。");  
 
 // 身份证号码验证
 jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
   //var idCard = /^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;   
   return this.optional(element) || isIdCardNo(value);    
 }, "请输入正确的身份证号码。"); 

 // IP地址验证   
 jQuery.validator.addMethod("ip", function(value, element) {    
   return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);    
 }, "请填写正确的IP地址。");

 // 字符验证，只能包含中文、英文、数字、下划线等字符。    
 jQuery.validator.addMethod("stringCheck", function(value, element) {       
      return this.optional(element) || /^[a-zA-Z0-9\u4e00-\u9fa5-_]+$/.test(value);       
 }, "只能包含中文、英文、数字、下划线等字符");   

 // 匹配english  
 jQuery.validator.addMethod("isEnglish", function(value, element) {       
      return this.optional(element) || /^[A-Za-z]+$/.test(value);       
 }, "只能输入字母");   
 
 // 匹配汉字
 jQuery.validator.addMethod("isChinese", function(value, element) {
      return this.optional(element) || /^[\u4e00-\u9fa5]+$/.test(value);
 }, "只能输入汉字");

 // 匹配中文(包括汉字和字符)
 jQuery.validator.addMethod("isChineseChar", function(value, element) {       
      return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);
 }, "匹配中文(包括汉字和字符) "); 
   
 // 判断是否为合法字符(a-zA-Z0-9-_)
 jQuery.validator.addMethod("isRightfulString", function(value, element) {       
      return this.optional(element) || /^[A-Za-z0-9_-]+$/.test(value);       
 }, "请输入合法字符");
 
//判断是否为合法字符(a-zA-Z0-9)
 jQuery.validator.addMethod("isCharAndNumString", function(value, element) {
      return this.optional(element) || /^[A-Za-z0-9]+$/.test(value);
 }, "只能输入字母和数字");

 // 判断是否包含中英文特殊字符，除英文"-_"字符外
 jQuery.validator.addMethod("isContainsSpecialChar", function(value, element) {  
      var reg = RegExp(/[(\ )(\`)(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\|)(\{)(\})(\')(\:)(\;)(\')(',)(\[)(\])(\.)(\<)(\>)(\/)(\?)(\~)(\！)(\@)(\#)(\￥)(\%)(\…)(\&)(\*)(\（)(\）)(\—)(\+)(\|)(\{)(\})(\【)(\】)(\‘)(\；)(\：)(\”)(\“)(\’)(\。)(\，)(\、)(\？)]+/);   
      return this.optional(element) || !reg.test(value);       
 }, "含有中英文特殊字符");

jQuery.validator.addMethod("isCurreny", function(value, element) {
    return this.optional(element) || /^(?!(0{1,9}(((\.0{0,2})?))$))([1-9]{1}[0-9]{0,9}|0)(\.[0-9]{1,2})?$/.test(value);
    //return this.optional(element) || /^((\d+\.\d*[1-9]\d*)|(\d*[1-9]\d*\.\d+)|(\d*[1-9]\d*)|(?:\.\d{1,2}))$/.test(value) ;
}, "只能输入正整数或者两位小数");

// 只能输入正整数和两位小数
jQuery.validator.addMethod("isNumberGteZero", function(value, element) {
    return this.optional(element) || /^\d+\.?\d{0,2}$/.test(value);
    //return this.optional(element) || /^((\d+\.\d*[1-9]\d*)|(\d*[1-9]\d*\.\d+)|(\d*[1-9]\d*)|(?:\.\d{1,2}))$/.test(value) ;
}, "只能输入整数和两位小数");
// 只能输入正整数和三位小数
jQuery.validator.addMethod("isThreeNumberGteZero", function(value, element) {
    return this.optional(element) || /^\d+\.?\d{0,3}$/.test(value);
}, "只能输入正整数和三位小数");

// 只能输入正整数和三位小数
jQuery.validator.addMethod("isInteger", function(value, element) {
    return this.optional(element) || /^-?\d+$/.test(value);
}, "请输入正确的整数");


jQuery.validator.addMethod("mulIp", function(value, element) {
    var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    var flag = false;
    if(value.indexOf(",")!=-1){
        var ss = value.split(",");
        for(var i=0;i<ss.length;i++){
            if(ip.test(ss[i])){
                flag = true;
                continue;
            }else{
                return ip.test(ss[i]);
            }
        }
    }else{
        return this.optional(element) || (ip.test(value));
    }
    return flag;
}, "多个Ip地址以英文逗号分隔");

jQuery.validator.addMethod("mulUrl", function(value, element) {
    var url = /^((http|https|ftp):\/\/)?(\w(\:\w)?@)?([0-9a-z_-]+\.)*?([a-z]{2,6}(\.[a-z]{2})?(\:[0-9]{2,6})?)((\/[^?#<>\/\\*":]*)+(\?[^#]*)?(#.*)?)?$/i;
    var flag = false;
    if(value.indexOf(",")!=-1){
        var ss = value.split(",");
        for(var i=0;i<ss.length;i++){
            if(url.test(ss[i])){
                flag = true;
                continue;
            }else{
                return url.test(ss[i]);
            }
        }
    }else{
        return this.optional(element) || (url.test(value));
    }
    return flag;

}, "多个url地址以英文逗号分隔");

// 判断人员档案电话不可重复
jQuery.validator.addMethod("humanMobile", function(value, element,param) {
	if(value == param){
		return true;
	}
 	var location = (window.location+'').split('/');
 	// ajax验证身份证是否存在
 	var flag = 1;
 	$.ajax({
 		type : "POST",
 		url : getContextPath()+'/system/human/humanMobile',
 		async : false, // 同步方法，如果用异步的话，flag永远为1
 		data : {
 			'mobile' : value
 		},
 		success : function(data) {
 			var res = eval('(' + data + ')');
 			var resCode = res['resCode'];
 			if (resCode == 'yes') {
 				flag = 0;
 			}
 		}
 	});
 	if (flag == 0) {
 		return false;
 	} else {
 		return true;
 	}
 }, "<font color='red'>该手机号已被注册</font>");

//判断人员档案电话不可重复
jQuery.validator.addMethod("humanEmail", function(value, element , param) {
	if(value == param){
		return true;
	}
 	// ajax验证身份证是否存在
 	var flag = 1;
 	$.ajax({
 		type : "POST",
 		url : getContextPath()+'/system/human/humanEmail',
 		async : false, // 同步方法，如果用异步的话，flag永远为1
 		data : {
 			'email' : value
 		},
 		success : function(data) {
 			var res = eval('(' + data + ')');
 			var resCode = res['resCode'];
 			if (resCode == 'yes') {
 				flag = 0;
 			}
 		}
 	});
 	if (flag == 0) {
 		return false;
 	} else {
 		return true;
 	}
 }, "<font color='red'>该邮箱已被注册</font>");
//判断人员档案是否存在
jQuery.validator.addMethod("humanIsExists", function(value, element , param) {
    if(value == param){
        return true;
    }
    var location = (window.location+'').split('/');
    // ajax验证身份证是否存在
    var flag = 0;
    $.ajax({
        type : "POST",
        url : getContextPath()+'/system/human/humanIsExists',
        async : false, // 同步方法，如果用异步的话，flag永远为1
        data : {
            'name' : value
        },
        success : function(data) {
            var res = eval('(' + data + ')');
            var resCode = res['resCode'];
            if (resCode == 'yes') {
                flag = 1;
            }
        }
    });
    if (flag == 0) {
        return false;
    } else {
        return true;
    }
}, "<font color='red'>该人员不存在</font>");

//判断管理员邮箱是否已经存在
jQuery.validator.addMethod("adminEmail", function(value, element , param) {
    if(value == param){
        return true;
    }
    var location = (window.location+'').split('/');
    // ajax验证身份证是否存在
    var flag = 1;
    $.ajax({
        type : "POST",
        url : getContextPath()+'/merchant/customer/adminEmail',
        async : false, // 同步方法，如果用异步的话，flag永远为1
        data : {
            'email' : value
        },
        success : function(data) {
            var res = eval('(' + data + ')');
            var resCode = res['resCode'];
            if (resCode == 'yes') {
                flag = 0;
            }
        }
    });
    if (flag == 0) {
        return false;
    } else {
        return true;
    }
}, "<font color='red'>该邮箱已被注册</font>");

//判断部门编码是否存在
jQuery.validator.addMethod("checkDeptId", function(value, element) {
    var location = (window.location+'').split('/');
    // ajax验证身份证是否存在
    var flag = 1;
    $.ajax({
        type : "POST",
        url : getContextPath()+'/system/dept/checkDeptId',
        async : false, // 同步方法，如果用异步的话，flag永远为1
        data : {
            'deptId' : value
        },
        success : function(data) {
            var res = eval('(' + data + ')');
            var resCode = res['resCode'];
            if (resCode == 'yes') {
                flag = 0;
            }
        }
    });
    if (flag == 0) {
        return false;
    } else {
        return true;
    }
}, "<font color='red'>该编码已存在</font>");




//判断人员档案是否存在
jQuery.validator.addMethod("checkParameterId", function(value, element) {
    var flag = 0;
    var oldPara =element.attributes.value.value;
    if(value==oldPara){
        return true;
    }
        $.ajax({
            type : "POST",
            url : getContextPath()+'/system/param/checkParameterId',
            async : false, // 同步方法，如果用异步的话，flag永远为1
            data : {
              'parameterId' : value ,'oldPara':oldPara
            },
            success : function(data) {
                var res = eval('(' + data + ')');
                var resCode = res['resCode'];
                if (resCode == 'yes') {
                    flag = 1;
                }
            }
        });
    if (flag == 0) {
        return false;
    } else {
        return true;
    }
}, "<font color='red'>输入的参数ID重复！</font>");


//角色是否重复
jQuery.validator.addMethod("checkAuthRole", function(value, element) {
    // ajax验证身份证是否存在
    var flag = 1;
    var oldAuthRoleName =element.attributes.value.value;
    if(value==oldAuthRoleName){
        return true;
    }
    $.ajax({
        type : "POST",
        url : getContextPath()+'/auth/authrole/checkAuthRole',
        async : false, // 同步方法，如果用异步的话，flag永远为1
        data : {
            'name' : value ,"oldAuthRoleName":oldAuthRoleName
        },
        success : function(data) {
            var res = eval('(' + data + ')');
            var resCode = res['resCode'];
            if (resCode == 'no') {
                flag = 0;
            }
        }
    });
    if (flag == 0) {
        return false;
    } else {
        return true;
    }
}, "<font color='red'>该角色已存在</font>");


//判断登录名是否存在
jQuery.validator.addMethod("checkLoginName", function(value, element) {
    // ajax验证身份证是否存在
    var flag = 1;
    var oldloginName =element.attributes.value.value;
    if(value==oldloginName){
        return true;
    }
    $.ajax({
        type : "POST",
        url : getContextPath()+'/auth/authuser/checkLoginName',
        async : false, // 同步方法，如果用异步的话，flag永远为1
        data : {
            'loginName' : value
        },
        success : function(data) {
            var res = eval('(' + data + ')');
            var resCode = res['resCode'];
            if (resCode == 'yes') {
                flag = 0;
            }
        }
    });
    if (flag == 0) {
        return false;
    } else {
        return true;
    }
}, "<font color='red'>登录名已存在</font>");


//判断姓名是否存在
jQuery.validator.addMethod("checkUserName", function(value, element) {
    // ajax验证身份证是否存在
    var flag = 1;
    var oldhumanName =element.attributes.value.value;
    if(value==oldhumanName){
        return true;
    }
    $.ajax({
        type : "POST",
        url : getContextPath()+'/auth/authuser/checkLoginName',
        async : false, // 同步方法，如果用异步的话，flag永远为1
        data : {
            'human.name' : value
        },
        success : function(data) {
            var res = eval('(' + data + ')');
            var resCode = res['resCode'];
            if (resCode == 'yes') {
                flag = 0;
            }
        }
    });
    if (flag == 0) {
        return false;
    } else {
        return true;
    }
}, "<font color='red'>姓名已存在</font>");



