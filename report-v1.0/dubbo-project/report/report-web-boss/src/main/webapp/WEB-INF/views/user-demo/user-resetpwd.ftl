<#include "/common/taglibs.ftl" >
<body class="body_main">
<div class="box">
    <div class="box_border">
        <div class="box_top"><b class="pl15">修改密码</b></div>
        <div class="cztable">
            <form action="" class="jqtransform"  >
                <table class="form_table" width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td class="td_right">原始密码：</td>
                        <td class="">
                            <input type="password" name="name" class="sh_input_text {required:true}" >
                        </td>
                    </tr>
                    <tr >
                        <td class="td_right">新密码：</td>
                        <td class="">
                            <input type="password" name="name1" id="password" class="sh_input_text {required:true,minlength:6}" >
                        </td>
                    </tr>
                    <tr>
                        <td class="td_right">新密码：</td>
                        <td class="">
                            <input type="password" name="name2" class="sh_input_text  {required:true,minlength:6,equalTo:'#password'}" >
                        </td>
                    </tr>
                    <tr>
                        <td class="" colspan="2" align="center">
                            <input type="submit"  class="btn btn82 btn_save2" value="保存">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>