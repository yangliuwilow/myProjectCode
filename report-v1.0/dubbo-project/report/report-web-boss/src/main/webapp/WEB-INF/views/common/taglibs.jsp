<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>   <!--  不加ctx获取不到 -->
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css"/>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<!-- 表格宽度拖动 -->
<script type="text/javascript" src="${ctx}/js/colResizable-1.3.min.js"></script>
<!-- 公共js定义 -->
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<!-- 时间框 -->
<script src="${ctx}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
<!-- jBox -->

<script type="text/javascript" src="${ctx}/js/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jBox/i18n/jquery.jBox-zh-CN.js"></script>
<link type="text/css" rel="stylesheet" href="${ctx}/js/jBox/Skins/Green/jbox.css"/>
<!-- 验证框架 -->
<script type="text/javascript" src="${ctx}/js/jquery-validate/jquery.metadata.js"></script><!-- css加class验证方式必须导入js -->
<script type="text/javascript" src="${ctx}/js/jquery-validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-validate/messages_cn.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-validate/eric.validate.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-validate/jquery.validate.css"/>

<!-- bootstrap -->
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/js/bootstrap/vendors/uniform.default.css" rel="stylesheet" media="screen">
<link href="${ctx}/js/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/js/bootstrap/css/styles.css" rel="stylesheet" media="screen">
<%--
<link href="${ctx}/js/bootstrap/css/DT_bootstrap.css" rel="stylesheet" media="screen">
--%>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<script src="${ctx}/js/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/js/bootstrap/js/jquery.uniform.min.js"></script>
</head>

