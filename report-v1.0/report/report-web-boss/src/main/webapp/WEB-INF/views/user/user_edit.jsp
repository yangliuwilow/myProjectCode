<%@ include  file="../common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
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
                    <form class="form-horizontal" id="form_sample_1" action="${ctx}/user/save" novalidate="novalidate" method="POST">
                        <input type="hidden" class="span4 m-wrap"  name="id" value="${itcastUser.id}">
                        <fieldset>
                            <div class="control-group">
                                <label class="control-label">登录名<span class="required">*</span></label>
                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" data-required="1" name="loginname" value="${itcastUser.loginname}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">真实姓名<span class="required">*</span></label>
                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" name="name" value="${itcastUser.name}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">部门<span class="required">*</span></label>
                                <div class="controls">
                                    <select name="departmentid" class="span4 m-wrap">
                                        <option value="">Select...</option>
                                        <option value="1" <c:if test="${itcastUser.departmentid==1}">selected="selected" </c:if>>软件一部</option>
                                        <option value="2" <c:if test="${itcastUser.departmentid==2}">selected="selected" </c:if>>开发部</option>
                                        <option value="3" <c:if test="${itcastUser.departmentid==3}">selected="selected" </c:if>>人事部</option>
                                        <option value="4" <c:if test="${itcastUser.departmentid==4}">selected="selected" </c:if>>运维部</option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">密码<span class="required">*</span></label>

                                <div class="controls">
                                    <input type="password" class="span4 m-wrap" name="password" value="${itcastUser.password}">
                                    <span class="help-block"> </span>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">性别<span class="required">*</span></label>
                                <div class="controls">
                                    <input type="radio" <c:if test="${itcastUser.gender==1}">checked="checked" </c:if>  class="span4 m-wrap" style="width: 10px;" name="gender" value="1"> 男
                                    <input type="radio" <c:if test="${itcastUser.gender==2}">checked="checked" </c:if> class="span4 m-wrap" style="width: 10px;" name="gender" value="2"> 女
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label">手机&nbsp;&nbsp;</label>

                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" name="phonenumber" value="${itcastUser.phonenumber}">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">邮件&nbsp;&nbsp;</label>

                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" name="email"  value="${itcastUser.email}">
                                    <span class="help-block"></span>
                                </div>
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
                    </form>
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