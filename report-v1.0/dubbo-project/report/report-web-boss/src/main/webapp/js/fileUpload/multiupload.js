var path=getContextPath();
var delFileList=[];

$(document).ready(function () {
    initMultiUploader(config);
});
function multiUploader(config) {

    this.config = config;
    this.items = "";
    this.all = [] ;
    this.allFileLists  = [];
    var self = this;

    multiUploader.prototype._init = function () {
        if (window.File &&
            window.FileReader &&
            window.FileList &&
            window.Blob) {
            var inputId = $("#" + this.config.form).find("input[type='file']").eq(0).attr("id");
            document.getElementById(inputId).addEventListener("change", this._read, false);
            document.getElementById(this.config.submitHandler).addEventListener("click", this._submit, false);
        } else
            console.log("Browser supports failed");
    }

    multiUploader.prototype._submit = function (e) {
        e.stopPropagation();
        e.preventDefault();
        var index=0;
        if (self.allFileLists.length > 0) {
            document.getElementById('submitHandler').disabled=true;
            fileUpload(self.allFileLists,index);
        }
    }

    multiUploader.prototype._preview = function (data) {
        this.items = data;
        if (this.items.length > 0) {
            var html = "";
            var uId = "";
            for (var i = 0; i < this.items.length; i++) {
                uId = this.items[i].name._unique();
                var sampleIcon = '<img src='+path+'/js/fileUpload/images/image.png />';
                var errorClass = "";
                if (typeof this.items[i] != undefined) {
                    if (self._validate(this.items[i].type) <= 0) {
                        sampleIcon = '<img src='+path+'/js/fileUpload/images/unknown.png />';
                        errorClass = " invalid";
                    }else{
                        self.allFileLists.push(this.items[i]);
                    }
                    html += '<div class="dfiles' + errorClass + '" rel="' + uId + '"><h5>' + sampleIcon + this.items[i].name + '</h5><div id="' + uId + '" class="delete" onclick="delImg(this)" style=""><img src='+path+'/js/fileUpload/images/trash.png /></div><div id="' + uId + '" class="progress" style="display:none;"><img src='+path+'/js/fileUpload/images/ajax-loader.gif /></div></div>';
                }
            }
            $("#dragAndDropFiles").append(html);
        }
    }

    multiUploader.prototype._read = function (evt) {
        if (evt.target.files) {
            self._preview(evt.target.files);
            self.all.push(evt.target.files);
        } else
            console.log("Failed file reading");
    }

    multiUploader.prototype._validate = function (format) {
        var arr = this.config.support.split(",");
        return arr.indexOf(format);
    }



    multiUploader.prototype._uploader = function (file, f) {

    }

    multiUploader.prototype._startUpload = function () {

    }

    String.prototype._unique = function () {
        return this.replace(/[a-zA-Z]/g, function (c) {
            return String.fromCharCode((c <= "Z" ? 90 : 122) >= (c = c.charCodeAt(0) + 13) ? c : c - 26);
        });
    }

    this._init();
}

function initMultiUploader() {
    new multiUploader(config);
}

function shwoProgress(index,total,loaded) {
    var width = Math.round(loaded/total * 100) + "%"    ;
    $("#percentage").html("正在上传第个"+(index+1)+"文件，上传进度："+width);
    $(".bar").css("width",width);
}



var xhrOnProgress=function(fun) {
    xhrOnProgress.onprogress = fun; //绑定监听
    //使用闭包实现监听绑
    return function() {
        //通过$.ajaxSettings.xhr();获得XMLHttpRequest对象
        var xhr = $.ajaxSettings.xhr();
        //判断监听函数是否为函数
        if (typeof xhrOnProgress.onprogress !== 'function')
            return xhr;
        //如果有监听函数并且xhr对象支持绑定时就把监听函数绑定上去
        if (xhrOnProgress.onprogress && xhr.upload) {
            xhr.upload.onprogress = xhrOnProgress.onprogress;
        }
        return xhr;
    }
}
function getContextPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    if("/report-web-boss"==projectName || "/sboss"==projectName){
        return(localhostPaht+projectName);
    }else{
        return localhostPaht;
    }
}
function  fileUpload(allFileLists,index){
 var file= allFileLists[index];
    if (typeof file != undefined ) {
        var data = new FormData();
        var ids = file.name._unique();
        data.append('file', file);
        data.append('index', ids);
        $("#percentage").html("正在上传第个"+(index+1)+"文件，上传进度：0%");
        $(".bar").css("width", "0%");
        $(".dfiles[rel='" + ids + "']").find(".progress").show();
        $(".dfiles[rel='" + ids + "']").find(".delete").hide();
        $.ajax({
            type: "POST",
            url: config.uploadUrl,
            data: data,
            cache: false,
            contentType: false,
            //async: false,
            processData: false,
            xhr: xhrOnProgress(function (e) {
                shwoProgress(index, e.total, e.loaded);
            }),
            success: function (response) {
                $(".dfiles[rel='" + ids + "']").find(".progress").hide();
                if ((index + 1) == allFileLists.length) {
                    allFileLists.length = 0;

                    $("#dragAndDropFiles").html("");
                    $("#percentage").html("上传完成");
                    document.getElementById('submitHandler').disabled = false;
                } else {
                    index++;
                    fileUpload(allFileLists,index);
                }
            }
        });
    }
}
function delImg(e){
   var ids=$(e).attr("id") ;
    $(".dfiles[rel='" + ids + "']").remove();
    delFileList.pop(ids);
}

