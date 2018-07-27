<!doctype html>
<html>
<head>
    <%@ include  file="../common/taglibs.jsp"%>
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

    <form class="form-signin" action="${ctx}/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text"   name="userName"    class="input-block-level" placeholder="Email address">
        <input type="password" name="password" class="input-block-level" placeholder="Password">
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
    </form>

</div>

</body>
</html>