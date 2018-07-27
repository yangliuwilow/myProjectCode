<#include "/common/taglibs.ftl" >
<script type="text/javascript">
</script>
<style>
</style>
<body class="body_main">
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
                                <label>姓名</label>
                                <div class="control">
                                    <input type="text" class=" m-wrap sh_input " name="url">
                                </div>
                            </div>

                            <div class="search_item">
                                <label>爱好</label>
                                <div class="control">
                                    <input type="text" class="sh_input m-wrap" name="url">
                                </div>
                            </div>
                            <div class="search_item">
                                <label>年龄</label>
                                <div class="control">
                                    <input type="text" class="sh_input m-wrap" name="url">
                                </div>
                            </div>
                            <div class="search_item">
                                <label>日期</label>
                                <div class="control">
                                    <input type="text" name="name" class="Wdate sh_input_date"
                                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  >至
                                    <input type="text" name="name" class="Wdate sh_input_date"
                                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  >
                                </div>
                            </div>

                            <div class="search_item">
                                <label>category</label>
                                <div class="control">
                                    <select name="category" class="sh_input m-wrap">
                                        <option value="">Select...</option>
                                        <option value="Category 1">Category 1</option>
                                        <option value="Category 2">Category 2</option>
                                        <option value="Category 3">Category 5</option>
                                        <option value="Category 4">Category 4</option>
                                    </select>
                                </div>
                            </div>
                            <div class="search_btn_area">
                                <a href="#">
                                    <button class="btn btn-primary">搜 索</button>
                                  <#-- <button class="btn btn-success">搜 索<i class="icon-plus icon-white"></i></button>
                               --> </a>
                            </div>
                        </div>
                        <div class="main_div_list">
                        <table cellspacing="0" cellpadding="0" border="0" id="example2"
                               class="table table-striped table-bordered dataTable dataTable_mian" aria-describedby="example2_info">
                            <thead>
                            <tr role="row">
                                <th class="sorting_asc">用户名
                                </th>
                                <th class="sorting">性别
                                </th>
                                <th class="sorting">年龄
                                </th>
                                <th class="sorting">籍贯
                                </th>
                                <th class="sorting">职业
                                </th>
                                <th class="sorting_asc">Rendering engine
                                </th>
                                <th class="sorting">Browser
                                </th>
                                <th class="sorting">Platform(s)
                                </th>
                                <th class="sorting">Engine version
                                </th>
                                <th class="sorting">CSS grade
                                </th>
                                <th class="sorting_asc">Rendering engine
                                </th>
                                <th class="sorting">Browser
                                </th>
                                <th class="sorting">Platform(s)
                                </th>
                                <th class="sorting">Engine version
                                </th>
                                <th class="sorting">CSS grade
                                </th>
                            </tr>
                            </thead>

                            <tbody role="alert" aria-live="polite" aria-relevant="all">
                            <tr class="gradeA odd" >
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                            </tr>
                            <tr class="gradeA even">
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                            </tr>
                            <tr class="gradeA odd">
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                            </tr>
                            <tr class="gradeA even">
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                            </tr><tr class="gradeA odd">
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.0</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.7</td>
                                <td class="center ">A</td>
                            </tr>
                            <tr class="gradeA even">
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                                <td class="  sorting_1">Gecko</td>
                                <td class=" ">Firefox 1.5</td>
                                <td class=" ">Win 98+ / OSX.2+</td>
                                <td class="center ">1.8</td>
                                <td class="center ">A</td>
                            </tr>


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
</body>
