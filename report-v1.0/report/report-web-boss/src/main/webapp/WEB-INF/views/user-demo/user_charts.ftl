<#include "/common/taglibs.ftl" >
<script type="text/javascript">
    $(function () {
         //tableColResizable('list_table');
    });
</script>
<body class="body_main">
<#--
<script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
-->
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts-3d.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>

 <script type="text/javascript">
    $(document).ready(function() {
        var options = {
            chart: {
                renderTo: 'container', //DIV容器ID
                type: 'column'//报表类型
            },
            //报表名称
            title:{
                text:'测试'
            },
       //补充说明
        subtitle: {
            text: '报表说明'
        },
        yAxis: {
            min: 0,
                    title: {
                text: '单位(mm)'
            }
        },
        //x轴显示内容
        xAxis: {
            categories: [ ]
        },
       //数据来源(多个对比的)
        series: [{},{},{},{}]
    };
    //json url 地址这里我使用的servlet
    var url =  "${ctx}/admin/user/groupByList";
    $.getJSON(url,function(data) {
        var i,len=data.length;
        for( i=0;i<len;i++){
            //赋值 series
            options.series[i].data = data[i].list;
            options.series[i].name = data[i].year;
            //对报表X轴显示名称赋值
            options.xAxis.categories[i]=data[i].name;
        }
        var chart = new Highcharts.Chart(options);
    });
    });
</script>
<body>
<div id="container">fff</div>
</body>
</body>
