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

<!-- bootstrap -->
<link href="${ctx}/js/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/js/bootstrap/vendors/uniform.default.css" rel="stylesheet" media="screen">
<link href="${ctx}/js/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/js/bootstrap/css/styles.css" rel="stylesheet" media="screen">
<%--
<link href="${ctx}/js/bootstrap/css/DT_bootstrap.css" rel="stylesheet" media="screen">
--%>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<script   type="text/javascript" src="${ctx}/js/bootstrap/js/bootstrap.min.js"></script>
<script  type="text/javascript" src="${ctx}/js/bootstrap/js/jquery.uniform.min.js"></script>



<script type="text/javascript" src="${ctx}/js/fileUpload/multiupload.js"></script>
<link href="${ctx}/js/fileUpload/style.css" type="text/css" rel="stylesheet" />
</head>
<script type="text/javascript">
    var config = {
        support: "image/jpg,image/png,image/bmp,image/jpeg,image/gif",		// Valid file formats
        form: "demoFiler",					// Form ID
        dragArea: "dragAndDropFiles",		// Upload Area ID
        uploadUrl: "${ctx}/upload/fileUpload",				// Server side upload url
        submitHandler:"submitHandler"    //上传按钮
    }
</script>


    <body class="body_main">
<div id="content" class="content">

    <!-- validation -->
    <div class="row-fluid">
        <!-- block -->
        <div class="block">
            <div class="navbar navbar-inner block-header">
                <div class="muted pull-left">添加用户</div>
            </div>
            <div class="block-content collapse in">
                <div class="span12">
                    <!-- BEGIN FORM-->
                    <%--<form class="form-horizontal" id="form_sample_1" action="${ctx}/user/save" novalidate="novalidate"
                          method="POST">--%>
                        <input type="hidden" class="span4 m-wrap" name="id" value="${itcastUser.id}">
                        <fieldset>
                            <%--<div class="control-group">
                                <label class="control-label">登录名<span class="required">*</span></label>

                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" data-required="1" name="loginname"
                                           value="${itcastUser.loginname}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="fileInput" class="control-label">File input</label>

                                <div class="controls">
                                    <div class="uploader" id="uniform-fileInput" style="width: 292px">
                                        <input type="file" id="fileInput" class="input-file uniform_on"
                                               onchange="document.getElementById('filename').innerHTML=this.value"
                                               multiple>
                                        <span class="filename" style="-moz-user-select: none;width: 184px;"
                                              id="filename">core_bg.png</span>
                                        <span class="action" style="-moz-user-select: none;">选择</span></div>
                                </div>
                            </div>--%>
                            <div class="control-group">
                                <center><h1 class="title">Multiple Drag and Drop File Upload</h1></center>
                                <div id="dragAndDropFiles" class="uploadArea">
                                    <h1>Drop Images Here</h1>
                                </div>
                                <form name="demoFiler" id="demoFiler" enctype="multipart/form-data">
                                    <input type="file" name="multiUpload" id="multiUpload" multiple/>
                                    <input type="button" name="submitHandler" id="submitHandler" value="Upload"
                                           class="buttonUpload"/>
                                </form>
                                <div class="progress progress-striped active">
                                    <div style="width: 0.1%;" class="bar"></div>
                                </div>
                                <span id="percentage" style="color:blue;"></span> <br>


                            </div>
                            <%-- 不要修改<div class="control-group">
                                    <label class="control-label">Category<span class="required">*</span></label>
                                    <div class="controls">
                                        <select name="category" class="span4 m-wrap">
                                            <option value="">Select...</option>
                                            <option value="Category 1">Category 1</option>
                                            <option value="Category 2">Category 2</option>
                                            <option value="Category 3">Category 5</option>
                                            <option value="Category 4">Category 4</option>
                                        </select>
                                    </div>
                                </div>--%>
                            <%--不要修改<div class="control-group">
                                <label for="fileInput" class="control-label">File input</label>
                                <div class="controls">
                                    <div class="uploader" id="uniform-fileInput" style="width: 292px">
                                        <input type="file" id="fileInput" class="input-file uniform_on" onchange="document.getElementById('filename').innerHTML=this.value" >
                                        <span class="filename" style="-moz-user-select: none;width: 184px;" id="filename">core_bg.png</span>
                                        <span class="action" style="-moz-user-select: none;">选择</span></div>
                                </div>
                            </div>     --%>
                            <div class="form-actions">
                                <button class="btn btn-primary" type="submit">提交</button>
                                <button class="btn" type="button" onclick="javascript:history.back(-1)">取消</button>
                            </div>
                        </fieldset>
                  <%--  </form>--%>
                    <!-- END FORM-->
                </div>
            </div>
        </div>
        <!-- /block -->

        <!-- /validation -->
    </div>
</div>
</body>
</html>