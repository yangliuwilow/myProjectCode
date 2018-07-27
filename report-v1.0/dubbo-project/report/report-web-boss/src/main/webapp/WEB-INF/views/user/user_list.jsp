<%@ include file="../common/taglibs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
</style>
<script>
    function addUser(url) {
        $("#userForm").attr("action", url);
    }
    function delUser(id){
        jQuery.post(
                '${ctx}/user/delete',{id:id},
                function(responseText, textStatus){
                    responseText = decodeURIComponent(responseText,"UTF-8");
                    var result = eval('(' + responseText + ')');
                     if(result['resCode']=='yes'){
                         $.jBox.messager('删除成功!', '提示');
                        $("#userForm").submit();
                     }else{
                         $.jBox.messager('删除失败!', '提示');
                     }
                })
    }
</script>
<body class="body_main">
<form action="${ctx}/user" id="userForm">
    <div id="content" class="content">
        <div class="row-fluid">
            <!-- block -->
            <div class="block">
                <div class="navbar navbar-inner block-header">
                    <div class="muted pull-left">用户列表</div>
                </div>
                <div class="block-content collapse in">
                    <div class="span12">
                        <div role="grid" class="dataTables_wrapper form-inline" id="example2_wrapper">
                            <div class="search_center">
                                <div class="search_item">
                                    <label>名称</label>

                                    <div class="control">
                                        <input type="text" class=" m-wrap sh_input " name="name"
                                               value="${itcastUserQuery.name}">
                                    </div>
                                </div>


                                <div class="search_item">
                                    <label>登录名</label>

                                    <div class="control">
                                        <input type="text" class=" m-wrap sh_input " name="loginname"
                                               value="${itcastUserQuery.loginname}">
                                    </div>
                                </div>


                                <div class="search_item">
                                    <label>手机</label>

                                    <div class="control">
                                        <input type="text" class=" m-wrap sh_input " name="phonenumber"
                                               value="${itcastUserQuery.phonenumber}">
                                    </div>
                                </div>
                                <div class="search_item">
                                    <label>日期</label>

                                    <div class="control">
                                        <input type="text" name="modifyDate" class="Wdate sh_input_date"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">至
                                        <input type="text" name="modifyDate_to" class="Wdate sh_input_date"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                                    </div>
                                </div>

                                <div class="search_item">
                                    <label>部门</label>

                                    <div class="control">
                                        <select name="departmentid" class="sh_input m-wrap">
                                            <option value="">Select...</option>
                                            <option value="1"
                                                    <c:if test="${itcastUserQuery.departmentid==1}">selected="selected" </c:if>>
                                                软件一部
                                            </option>
                                            <option value="2"
                                                    <c:if test="${itcastUserQuery.departmentid==2}">selected="selected" </c:if>>
                                                开发部
                                            </option>
                                            <option value="3"
                                                    <c:if test="${itcastUserQuery.departmentid==3}">selected="selected" </c:if>>
                                                人事部
                                            </option>
                                            <option value="4"
                                                    <c:if test="${itcastUserQuery.departmentid==4}">selected="selected" </c:if>>
                                                运维部
                                            </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="search_btn_area">
                                    <a href="#">
                                        <button class="btn btn-primary">搜 索</button>
                                    </a>
                                    <a href="${ctx}/user/new">
                                        <button class="btn btn-primary" onclick="addUser('${ctx}/user/new')">添 加</button>
                                    </a>
                                    <a href="${ctx}/upload/new">
                                        <button class="btn btn-primary" onclick="addUser('${ctx}/upload/new')">文件上传</button>
                                    </a>
                                </div>
                            </div>
                            <div class="main_div_list">
                                <table cellspacing="0" cellpadding="0" border="0" id="example2"
                                       class="table table-striped table-bordered dataTable dataTable_mian"
                                       aria-describedby="example2_info">
                                    <thead>
                                    <tr role="row">
                                        <th   >id
                                        </th>
                                        <th >名称
                                        </th>
                                        <th >登录名
                                        </th>
                                        <th >性别
                                        </th>
                                        <th >手机
                                        </th>
                                        <th >描述
                                        </th>
                                        <th >邮件
                                        </th>
                                        <th  >部门
                                        </th>
                                        <th >创建时间
                                        </th>
                                        <th >修改时间
                                        </th>
                                        <th >操作
                                        </th>

                                    </tr>
                                    </thead>

                                    <tbody role="alert" aria-live="polite" aria-relevant="all">
                                    <c:forEach var="item" items="${resultList}" varStatus="user">
                                        <tr
                                                <c:if test="${status.count%2==0}">class="gradeA odd"</c:if>
                                                <c:if test="${status.count%2==0}">class="gradeA even"</c:if>>
                                            <td >${item.id}
                                            </td>
                                            <td >${item.name}
                                            </td>
                                            <td >${item.loginname}
                                            </td>
                                            <td ><c:if test="${item.gender==1}">男</c:if> <c:if
                                                    test="${item.gender==2}">女</c:if>
                                            </td>
                                            <td >${item.phonenumber}
                                            </td>
                                            <td >${item.description}
                                            </td>
                                            <td >${item.email}
                                            </td>
                                            <td class="sorting_asc">${item.departmentid}
                                            </td>
                                            <td ><fmt:formatDate value="${item.createDate}" type="date"/>
                                            </td>
                                            <td ><fmt:formatDate value="${item.modifyDate}" type="date"/>
                                            </td>
                                            <td >
                                                <a href="${ctx}/user/toEdit/${item.id}">编辑</a>
                                                <a href="#" onclick="delUser('${item.id}')">删除</a>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>


                            <div class="span6">
                                <div class="dataTables_paginate paging_bootstrap pagination">
                                    <ul>
                                        <li class="prev disabled"><a href="#">← Previous</a></li>
                                        <li class="active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li class="next"><a href="#">Next → </a></li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <!-- /block -->
        </div>
    </div>
</form>
</body>
