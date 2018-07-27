<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台首页</title>
    <style type="text/css">
        #arrow{float:left;top: 25px;margin-top: 159px;margin-right:5px;z-index: 3; overflow: hidden;position: absolute;}
        #arrow{width:5px;height:390px;cursor:hand;border:1px solid #cfcfd1}

        .left_menu {left: 0;overflow: hidden; position: absolute; top: 115px;  width: 206px;}


    </style>

    <script type="text/javascript" src="${ctx}/js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="${ctx}/js/jsplit.js"></script>
    <script type="text/javascript">
        $(function() {
            $(".sideMenu").slide({
                titCell : "h3",
                targetCell : "ul",
                defaultIndex : 0,
                effect : 'slideDown',
                delayTime : '500',
                trigger : 'click',
                triggerTime : '150',
                defaultPlay : true,
                returnDefault : false,
                easing : 'easeInQuint',
                endFun : function() {
                    scrollWW();
                }
            });
            $(window).resize(function() {
                scrollWW();
            });

            $("li").bind({click:function(){
                $("li[class='on']").removeClass("on");
                $(this).addClass("on");
                var url='${ctx}/'+$(this).attr('title');
                $("#rightMain").attr("src",url);
                $("#here_title").html('<a href="#" onclick="reloadcode(\''+url+'\')">'+$(this).text()+'</a>');
            }
            });
            //菜单div隐藏显示
            $("#arrow").click(function(){
                var leftDiv,rightDiv,arrow;
                leftDiv = $("#menu");
                rightDiv = $("#main");
                arrow = $("#arrow");
                var topleftDiv=$("#side_here_l");
                var toprightDiv=$("#here_area");
                if(leftDiv.css("display") == "none"){
                    leftDiv.css("display","");
                    topleftDiv.css("display","");
                    rightDiv.css("left","206px"); toprightDiv.css("left","206px");
                    arrow.removeClass("aright").addClass("aleft");
                }else{
                    leftDiv.css("display","none"); topleftDiv.css("display","none");
                    rightDiv.css("left","0px"); toprightDiv.css("left","0px");
                    arrow.removeClass("aleft").addClass("aright");
                }
            })
        });

        function scrollWW() {
            if ($(".side").height() < $(".sideMenu").height()) {
                $(".scroll").show();
                var pos = $(".sideMenu ul:visible").position().top - 38;
                $('.sideMenu').animate({
                    top : -pos
                });
            } else {
                $(".scroll").hide();
                $('.sideMenu').animate({
                    top : 0
                });
                n = 1;
            }
        }

        var n = 1;
        function menuScroll(num) {
            var Scroll = $('.sideMenu');
            var ScrollP = $('.sideMenu').position();
            if (num == 1) {
                Scroll.animate({
                    top : ScrollP.top - 38
                });
                n = n + 1;
            } else {
                if (ScrollP.top > -38 && ScrollP.top != 0) {
                    ScrollP.top = -38;
                }
                if (ScrollP.top < 0) {
                    Scroll.animate({
                        top : 38 + ScrollP.top
                    });
                } else {
                    n = 1;
                }
                if (n > 1) {
                    n = n - 1;
                }
            }
        }
        function resetPwd(){
            $.jBox("iframe:"+'${ctx}/admin/user/resetpwd', {
                title: "修改密码",
                width: 550,
                height: 300,
                buttons: { '关闭': true }
            });
        }
    </script>
</head>
<body>
<div class="top">
    <div id="top_t">
        <div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
            <div id="photo" class="fl">
                <a href="#"><img src="${ctx}/images/a.png" alt="" width="60" height="60">
                </a>
            </div>
            <div id="base_info" class="fr">
                <div class="help_info">
                    <a href="#" id="hp">&nbsp;</a>
                    <a href="#" onclick="resetPwd();"   id="gy"><font  color="#ffffff" style="font-size: 12px;">&nbsp;修 改 密 码</font></a>
                    <a href="${ctx}/login/outLogin"  >&nbsp;</a>
                </div>
                <div class="info_center">
                    <%-- ${user.loginName}--%> <span id="nt">通知</span><span><a href="#" id="notice">3</a>
						</span>
                </div>
            </div>
        </div>
    </div>
    <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：<span id="here_title"></span></div>
    </div>
</div>


        <div class=" left_menu"  id="menu">
        <div id="sidebar"  >
            <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                <li title="admin/user/toEdit">
                    <a href="#"> <i class="icon-chevron-right"></i> 编辑用户      </a>
                </li>
                <li title="admin/user">
                    <a href="#"> <i class="icon-chevron-right"></i> 用户列表   </a>
                </li>
                <li>
                    <a href="#"><i class="icon-chevron-right"></i> Statistics (Charts)</a>
                </li>
                <li class="active">
                    <a href="#"><i class="icon-chevron-right"></i> Forms</a>
                </li>

            </ul>
        </div></div>

<!--箭头开始-->
<div id="arrow" class="aleft" style="cursor:pointer;"></div>
<!--箭头结束-->
<div class="main"  id="main">
    <iframe name="right" id="rightMain" src="" frameborder="no" scrolling="auto" width="100%" height="auto" allowtransparency="true"></iframe>
</div>
<div class="bottom">
    <div id="bottom_bg">京ICP证130173号</div>
</div>

</body>
</html>