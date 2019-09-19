// 页面url，去掉”#“后面的
var url = location.href.split('#')[0];

// 微信初始化配置参数
var config = {
    appId:'',
    timestamp:'',
    nonceStr:'',
    signature:''
}

// 分享数据
var data = {
	shareFriend:'',
	shareTimeLine:'',
	shareQQ:'',
	shareQZone:'',
	shareWeibo:''
}

// 获取配置参数
$.ajax({
    url: "/wx/getAccess",
    type: 'post',
    async: false ,
    dataType: 'json',
    data: { url: url},
    success: function(data){
    	config.appId = data.data.appId;
    	config.timestamp = data.data.timestamp;
    	config.nonceStr = data.data.nonceStr;
    	config.signature = data.data.signature;
    	console.log(config)
        console.log(config.appId)
    },
    error: function (XMLHttpRequest, textStatus, errorThrown) {
    	config = {};
    }
});

//debug 模式
wx.config({
    debug: false,
    appId: config.appId,
    timestamp: config.timestamp,
    nonceStr: config.nonceStr,
    signature: config.signature,
    jsApiList: [
        'checkJsApi',
		'onMenuShareTimeline',
		'onMenuShareAppMessage',
		'onMenuShareQQ',
		'onMenuShareWeibo',
		'onMenuShareQZone',
		'startRecord',
		'stopRecord',
		'onVoiceRecordEnd',
		'playVoice',
		'pauseVoice',
		'stopVoice',
		'onVoicePlayEnd',
		'uploadVoice',
		'downloadVoice',
		'chooseImage',
		'previewImage',
		'uploadImage',
		'downloadImage',
		'translateVoice',
		'getNetworkType',
		'openLocation',
		'getLocation',
		'hideOptionMenu',
		'showOptionMenu',
		'hideMenuItems',
		'showMenuItems',
		'hideAllNonBaseMenuItem',
		'showAllNonBaseMenuItem',
		'closeWindow',
		'scanQRCode',
		'chooseWXPay',
		'openProductSpecificView',
		'addCard',
		'chooseCard',
		'openCard'
    ]
});



wx.ready(function () {
	// 分享给朋友
    console.log(12313213);

	if (data.shareFriend != ''){
		wx.onMenuShareAppMessage(data.shareFriend);
	}
	
	// 分享到朋友圈
	if (data.shareTimeLine != ''){
		wx.onMenuShareTimeline(data.shareTimeLine);
	}
	
	// 分享到QQ
	if (data.shareQQ != ''){
		wx.onMenuShareQQ(data.shareQQ);
	}
	
	// 分享到QQ空间
	if (data.shareQZone != ''){
		wx.onMenuShareQZone(data.shareQZone);
	}
	
	// 分享到微博
	if (data.shareWeibo != ''){
		wx.onMenuShareWeibo(data.shareWeibo);
	}
});

/**
 * 分享给朋友
 * @param sdata
 */
function shareFriend(sdata){
	data.shareFriend = sdata;
	wx.onMenuShareAppMessage(sdata);
}

/**
 * 分享到朋友圈
 * @param sdata
 */
function shareTimeLine(sdata){
	data.shareTimeLine = sdata;
	wx.onMenuShareTimeline(data.shareTimeLine);
}

/**
 * 分享到QQ
 * @param sdata
 */
function shareQQ(sdata){
	data.shareQQ = sdata;
	wx.onMenuShareQQ(data.shareQQ);
}

/**
 * 分享到QQ空间
 * @param sdata
 */
function shareQZone(sdata){
	data.shareQZone = sdata;
	wx.onMenuShareQZone(data.shareQZone);
}

/**
 * 分享到微博
 * @param sdata
 */
function shareWeibo(sdata){
	data.shareWeibo = sdata;
	wx.onMenuShareWeibo(data.shareWeibo);
}

/**
 * 调用相机或相册
 * @param sdata
 */
function chooseImage(data){
	wx.chooseImage(data);
}

/**
 * 上传图像
 * @param sdata
 */
function uploadImage(data){
	wx.uploadImage(data);
}

/**
 * 下载图像
 * @param sdata
 */
function downloadImage(data){
	wx.downloadImage(data);
}
