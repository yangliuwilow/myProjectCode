<#include "/common/taglibs.ftl" >
<style>
  </style>
<body class="body_main">
<div id="content" class="content">

    <!-- validation -->
    <div class="row-fluid">
        <!-- block -->
        <div class="block">
            <div class="navbar navbar-inner block-header">
                <div class="muted pull-left">Form Validation</div>
            </div>
            <div class="block-content collapse in">
                <div class="span12">
                    <!-- BEGIN FORM-->
                    <form class="form-horizontal" id="form_sample_1" action="#" novalidate="novalidate">
                        <fieldset>
                            <div class="control-group">
                                <label class="control-label">Name<span class="required">*</span></label>
                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" data-required="1" name="name">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Email<span class="required">*</span></label>

                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" name="email">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">URL<span class="required">*</span></label>

                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" name="url">
                                    <span class="help-block"> </span>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Number<span class="required">*</span></label>

                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" name="number">
                                </div>
                            </div>

                            <div class="control-group">
                                <label for="fileInput" class="control-label">File input</label>
                                <div class="controls">
                                    <div class="uploader" id="uniform-fileInput" style="width: 292px">
                                        <input type="file" id="fileInput" class="input-file uniform_on" onchange="document.getElementById('filename').innerHTML=this.value" >
                                        <span class="filename" style="-moz-user-select: none;width: 184px;" id="filename">core_bg.png</span>
                                        <span class="action" style="-moz-user-select: none;">选择</span></div>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Occupation&nbsp;&nbsp;</label>

                                <div class="controls">
                                    <input type="text" class="span4 m-wrap" name="occupation">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="control-group">
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
                            </div>
                            <div class="form-actions">
                                <button class="btn btn-primary" type="submit">提交</button>
                                <button class="btn" type="button">取消</button>
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