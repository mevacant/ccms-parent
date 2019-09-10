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

// function invoke(path,param,callback){
//     invoke(path,param,callback,"post");
// }


function invoke(path,param,callback){
    var serverUrl = "http://127.0.0.1:8003";
    var url = serverUrl + path
    console.log("request url:%s, param:%s",url,param);

    console.log("request url:%s,param:%s",serverUrl+url,JSON.stringify(param));
    $.ajax({
        url: url, 
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        type:"post",
        data: param,
        timeout: 6000,
        success: function(res){
            callback(res);
        },
        error: function(err){
            console.log(JSON.stringify(err));
            alert("请求失败，稍后再试");
        },
        complete: function (res) {
            console.log("reponse url:%s,res:%s",serverUrl+url,JSON.stringify(res));
        }

    });
}