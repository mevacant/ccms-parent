$.fn.serializeObject = function() {  
    var o = {};  
    var a = this.serializeArray();  
    $.each(a, function() {  
        if (o[this.name]) {  
            if (!o[this.name].push) {  
                o[this.name] = [ o[this.name] ];  
            }  
            o[this.name].push(this.value || '');  
        } else {  
            o[this.name] = this.value || '';  
        }  
    });  
    return o;  
}

function showError(dom,msg){
    dom.css("visibility","visible");
    if(msg){
        dom.text(msg);
    }else{
        dom.text("未知错误");
    }
}

function clearError(dom){
    dom.css("visibility","");
    dom.text("");
}

// function invoke(path,param,callback){
//     invoke(path,param,callback,"post");
// }


function invoke(path,param,callback,contentType){
    // var serverUrl = "http://127.0.0.1:8003";
    // var serverUrl = "https://activity.qiaofu.shop";
    var serverUrl = "";
    var url = serverUrl + path
    if("json" == contentType){
        contentType = "application/json; charset=utf-8";
        param = JSON.stringify(param);
    }else {
        contentType = "application/x-www-form-urlencoded; charset=utf-8"
    }
    console.log("request url:%s, param:%s",url,JSON.stringify(param));

    $.ajax({
        url: url, 
        contentType: contentType,
        dataType: "json",
        type:"post",
        data: param,
        timeout: 6000,
        success: function(res){
            callback(res);
        },
        error: function(err){
            console.log(JSON.stringify(err));
            //alert("请求失败，稍后再试");
            showError($("#errorDom"), "当前网络不能用，请检查网络");
        },
        complete: function (res) {
            console.log("reponse url:%s,res:%s",url,JSON.stringify(res));
        }

    });
}

function pageBack() {
    window.history.back(-1);
    // window.location.go(-1);
    // window.location.href=document.referrer;
}

function pageOpen(url) {
    //window.history.back(-1);
    window.location = url;
}

//手机号码校验
function isMobile(){
    return /^1[3456789]\d{9}$/.test(phone);
}