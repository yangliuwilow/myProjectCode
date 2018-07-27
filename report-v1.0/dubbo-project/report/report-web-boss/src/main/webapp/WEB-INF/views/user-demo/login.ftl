<#assign ctx = request.contextPath/>
<!doctype html>
<html>
<head>
<#include "/common/taglibs.ftl" >
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台登录</title>
    <script type="text/javascript">
        $(function () {
            var error='${loginError}';
            if(error!='')
                $.jBox.error(error, 'jBox');
        });
    </script>
    <script type="text/javascript">
        if (window != top)
            top.location.href = location.href;
    </script>

<body id="login">
<div class="container">

    <form class="form-signin" action="${ctx}/login/index">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="input-block-level" placeholder="Email address">
        <input type="password" class="input-block-level" placeholder="Password">
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->

</body>
</html>