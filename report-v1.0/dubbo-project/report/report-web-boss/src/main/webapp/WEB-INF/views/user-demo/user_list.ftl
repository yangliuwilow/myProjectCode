<#include "/common/taglibs.ftl" >
<script type="text/javascript">
    $(function () {
         //tableColResizable('list_table');
    });
</script>
<body class="body_main">
<form action="${ctx}/admin/user" id="listForm">
    <div class="main_div">
        <!--  搜索 -->
        <div id="search_bar">
            <div class="box">
                <div class="box_border">
                    <div class="box_top">
                        <b class="pl15">搜索</b>
                    </div>
                    <div class="box_center ">

                        <table class="form_table" border="0" cellpadding="0" cellspacing="0" >
                            <tr>
                                <td class="search_table_td_title">姓名：</td>
                                <td class="search_table_td_txt">
                                    <input type="text" name="name" class="sh_input_text" size="10">
                                </td>
                                <td class="search_table_td_title">性别：</td>
                                <td class="search_table_td_txt">
                                    <select name="" class="sh_input_select">
                                        <option>男</option>
                                        <option>女</option>
                                    </select>
                                </td>
                                <td class="search_table_td_title">创建时间：</td>
                                <td class="search_table_td_txt">
                                    <input type="text" name="name" class="Wdate sh_input_text"
                                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly">
                                </td>

                            </tr>
                        </table>

                    </div>
                    <div class="search_box_bottom" >
                        <div class="search_bar_btn">
                            <input type="submit" class="btn btn82 btn_search" value="查询">
                            <input type="button" class="btn btn82 btn_add" value="新增"
                                   onclick="javascript:window.location.href='${ctx}/user/user-edit.action'">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--  列表-->
        <div class="main_div_list">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                    <th width="30">#</th>
                    <th width="100">标题</th>
                    <th width="100">标题</th>
                    <th>标题</th>
                    <th width="30">#</th>
                    <th width="100">标题</th>
                    <th width="100">标题</th>
                    <th>标题</th>
                    <th width="30">#</th>
                    <th width="100">标题</th>
                    <th width="100">标题</th>
                    <th>标题</th>
                    <th>操作</th>
                </tr>
                <tr class="tr">
                    <td class="td_center"><input type="checkbox"></td>
                    <td>aad</td>
                    <td>aad是是是是是是是是是是是是是是是</td>
                    <td>aad</td>
                    <td class="td_center"><input type="checkbox"></td>
                    <td>aad</td>
                    <td>aad是是是是是是是是是是是是是是是的顶顶顶顶顶的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶</td>
                    <td>aad</td>
                    <td class="td_center"><input type="checkbox"></td>
                    <td>aad</td>
                    <td>aad是是是是是是是是是是是是是是是</td>
                    <td>aad</td>
                    <td class="td_modi">
                        <input type="button" value="暂停" class="btn_pause" onclick="resetPwd();"/>
                        <input type="button" value="修改" class="btn_modify"
                               onclick="location.href='${base}/admin/user/toEdit';"/>
                        <input type="button" value="删除" class="btn_delete"
                               onclick="delConfirm('${base}/admin/user/');"/>
                    </td>
                </tr>
                <tr class="tr">
                    <td class="td_center"><input type="checkbox"></td>
                    <td>aad</td>
                    <td>aad</td>
                    <td>aad</td>
                    <td>
                        <input type="button" value="暂停" class="btn_start" onclick="setState();"/>
                        <input type="button" value="修改" class="btn_modify"
                               onclick="location.href='${ctx}/user/user-edit.action';"/>
                        <input type="button" value="删除" class="btn_delete"
                               onclick="delConfirm('${ctx}/user/user-edit.action');"/>
                    </td>
                </tr>
            </table>
            <div class="pagination ">
            <@p.pagination page />
            </div>
        </div>
    </div>
</form>
</body>
