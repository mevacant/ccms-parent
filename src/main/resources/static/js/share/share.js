/**
 * 微信分享帮助类
 */
var ShareWX = {
	// 分享微信、QQ、微博
	share : function(shareData){

console.log('test');
console.log(shareData);
		// 分享给朋友
		shareFriend(shareData);
		// 分享到朋友圈
		shareTimeLine(shareData);
		// 分享到QQ好友
		shareQQ(shareData);
		// 分享到QQ空间
		shareQZone(shareData);
		// 分享到微博
		shareWeibo(shareData);
	},
	// 查询分享参数
	query : function(activityCode,category) {
		var request = Request.queryShareInfoUrl();
		request.data = {
			activityCode : activityCode
		};
		request.callback = ShareWX.queryShareCallback;
		request.category = category;
		
		Request.post(request);
	},
	// 查询带有邀请关系的分享参数
	queryInv : function(activityCode, invCode, invMobile, category) {
		console.log("into="+activityCode);
		var request = Request.queryShareInfoUrl();
		request.data = {
			activityCode : activityCode
		};
		request.callback = ShareWX.queryShareCallback;
		request.invCode = invCode || "";
		request.invMobile = invMobile || "";
		Request.post(request);
	},
	// 查询参数回调
	queryShareCallback : function(data){
		if(Utils.isNotEmpty(data)){
			if(Utils.isNotEmpty(data.param.category)){
				if(data.param.category == "1"){//推广分享
					ShareWX.promote(data);
				} else if (data.param.category == "2"){
					ShareWX.inv(data);
				}
			}else{//通用分享
				ShareWX.general(data);
			}
		}
	},
	// 通用分享分享
	general : function(data){
		var shareData =  {
	        title: data.shareTitle,
	        desc: data.shareContent,
	        link: data.shareUrl,
	        imgUrl: data.sharePic
		};
		this.share(shareData);
	},
	//推广分享
	promote : function(data){
		data.shareUrl = Utils.addUrlParam(data.shareUrl, 'activity', $("#activity").val());
		ShareWX.general(data);
	},
	//推广分享
	inv : function(data){
		data.shareUrl = data.shareUrl + "&invCode=" + data.param.invCode + "&invMobile=" + data.param.invMobile;
		ShareWX.general(data);
	},
	/*// 机票介绍页分享
	ticketIndex : function(data){
		var shareData =  {
	        title: '买不到火车票，败给了12306的验证码？',
	        desc: '才米送你机票，这样回家快一点！',
	        link:  uri + '/activity/ticket/index',
	        imgUrl: data.uri + '/img/ticket/jipiao-share.png'
		}
		
		this.share(shareData);
	},
	// 机票“扛”页面分享
	ticketCarry : function(data){
		var url = encodeURIComponent(data.uri + '/activity/ticket/carry?actcode=' + data.actcode + '&nickName=' + data.nickName + '&openid=' + data.openid + '&');
		var shareData =  {
	        title: data.nickName + '需要你的帮助！',
	        desc: '没抢到火车票！雪地裸体空翻360度跪求帮抢机票！才米送我回家！',
	        link:  data.accUrl + '?jump=' + url,
	        imgUrl: data.uri + '/img/ticket/jipiao-share.png'
		}
		
		this.share(shareData);
	},
	// 机票结果页分享
	ticketResult : function(data){
		var shareData =  {
	        title: '才米送机票啦！',
	        desc: '快来看看你中了没',
	        link:  data.uri + '/activity/ticket/result',
	        imgUrl: data.uri + '/img/ticket/result.png'
		}
		
		this.share(shareData);
	},*/
	// 吉利红包页分享
	jiliResult : function(data){
		var shareData =  {
	        title: '过年大出血？财神爷教你，如何一元钱原地满血满状态复活！',
	        desc: '【好友推荐福利】只需投资1元，就可激活8888元新手体验金！2月14日前有效',
	        link:  Utils.getUri() + '/activity/jili/index?invCode='+data.invCode+'&invMobile='+data.invMobile+'&activity='+data.activity,
	        imgUrl: Utils.getImgUri() + '/img/jili/fenxiang.png'
		}
		
		this.share(shareData);
	},
	// 老的MGM红包页分享
	mgm : function(data){
		var shareData =  {
	        title: '来自乔馥的一份心意',
	        desc: '好松露，值得寻觅。快来兑换吧！',
	        link:  'https://activity.qiaofu.shop/pages/index',
	        imgUrl: 'https://activity.qiaofu.shop/images/userfiles/ecpimg/54062b5ad13749ae82a5be6f3fd29b8a.png'
		}
		this.share(shareData);
	},
	// 猜灯谜分享
	cdm : function(data){
		var shareData =  {
	        title: '见过猜灯谜，没见过猜灯谜能挣钱的？好友正在挑战11.98%高息，需要你的帮助！',
	        desc: '帮助好友获得额外5%加息的同时，你还可领最高8888元体验金哦~',
	        link:  Utils.getUri() + '/activity/cdm/register?invCode='+data.invCode+'&invMobile='+data.invMobile+'&activity='+data.activity + '&pid=' + data.pid,
	        imgUrl: Utils.getImgUri() + '/img/cdm/cdmfenxiang.png'
		}
		this.share(shareData);
	},
	//复活节分享
	easter : function(data){
		var shareData =  {
			title: '复活节去哪儿玩，不如来才米“猜”蛋，猜中最高可享5%加息！',
			desc: '才米把加息福利都藏进了复活节彩蛋里，快来猜猜看吧！机智如你一定能猜对，年化利率最高可飙升至11.98%哦！',
			link:  Utils.getUri() + '/activity/easter/register?invCode='+data.invCode+'&invMobile='+data.invMobile+'&activity='+data.activity,
			imgUrl: Utils.getImgUri() + '/img/easter/eastershare.png'
		}
		this.share(shareData);
	}
}
