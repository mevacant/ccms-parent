<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="${basePath}/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${basePath}/js/common.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->
<link rel="stylesheet" href="${basePath}/css/bootstrap.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" href="${basePath}/css/main.css">

<title>乔馥</title>
<script type="text/javascript">
	$(document).ready(function(){
		//alert($("#codeInput").offset().top);
		var top = $("#codeInput").offset().top;
		$("#fixedQueryBtn").css("top",top);


		// var height = $("#index1img").height();
		// console.log(height);
		// $("#formBox").css("margin-top",height-40);
	});

	//var code = "A2019010110123"

	function useCode(){
		var code = $("#codeInput").val();
        var errorDom = $("#errorDom");

        clearError(errorDom);
		//console.log(code);
		if(code == ""){
			showError(errorDom, "券码不能为空哦");
			return;
		}
        if(code.length != 13){
            showError(errorDom, "请输入13位券码哦");
            return;
        }

		var param = {
		    code : code,
			userId : 0
		}
		
		invoke("/voucher/useCode",param, function(res){

            if(res != null && "1" == res.success){
                //兑换成功
                pageOpen("/pages/addrForm?code="+code);
            }else if(res != null && "4007" == res.error.code){
                //4007.券码已被领取/兑换 还未填写收货地址
                pageOpen("/pages/addrForm?code="+code);
            }else if(res != null && "4011" == res.error.code){
                //4011.券码已被领取/兑换 已经填写收货地址
                pageOpen("/pages/showAddr?code="+code);
            }
            else{
                //兑换失败
                $("#codeInput").val("");
                showError($("#errorDom"), res.error.message);
            }



		});
	}
	

</script>


</head>

<div class="container-fluid" style="">
	<div class="row" style="">
		<div class="col-xs-12 col-md-offset-4 col-md-4" style="background:#DDDED5;text-align:center;padding-top:30px;padding-bottom: 50px;">
			<div id="whiteBox" style="background:#fff;padding:17px;">
				<img id="index1img" width="100%" class="center-block" src="/img/voucher/index1-1.png"/>
				<div style="position:absolute;top:47px;left:0;right:0;margin: auto;">
                    <img id="index1img" width="100%" class="center-block" src="/img/voucher/index1-2.png"/>
				</div>
                <div id="formBox" style="margin-top: 30px;font-size: 16px;">
                    <form class="form-horizontal" style="">
                        <#--<div class="form-group" style="margin-bottom:0;">-->
                            <#--<label style="" for="codeInput" class="col-xs-4 control-label">券码</label>-->
                            <#--<div class="col-xs-8">-->

                                <#--<input style="width:150px;" type="text" class="form-control line-input" id="codeInput" name="code" placeholder="">-->
                            <#--</div>-->
                        <#--</div>-->
						<div class="row">
							<div class="col-xs-4" style="text-align: right;font-size: 16px;font-weight: bold;line-height: 40px;">券码</div>
							<div class="col-xs-8" style="text-align: left">
								<input style="width:150px;height: 40px;background: transparent;" type="text" class="line-input" id="codeInput" name="code" placeholder="请输入13位券码">
							</div>
						</div>

						<div class="row" style="margin:10px 0;">
							<div class="col-xs-4"></div>
							<div class="col-xs-8" style="text-align: left">
							<span id="errorDom" class="errorSpan" >未知错误
							</span>
							</div>
						</div>

						<div style="position:relative;">
                            <div style="position:absolute;top:0;left:0;right:0;margin: auto;">
                                <button style="" class="btn-no-border orange-btn-big"  type="button" onclick="useCode();"></button>
                            </div>
						</div>

                    </form>
                </div>
			</div>
		</div>
	</div>
</div>

<div id="fixedQueryBtn" onclick="pageOpen('/pages/queryGift')" style="z-index:999;position:fixed;right:0;top:227px;text-align:center;line-height:12px;color:fff;width:82px;">
	<#--<div>查询</div>-->
	<#--<div>礼物</div>-->
	<img width="100%" src="/img/voucher/fix_btn.png">
</div>

<br/>
<div style="width:100%;text-align:center;margin-top: 20px;">
	<p style="font-size:17px;"><strong>礼品展示</strong></p>
</div>

<div class="container-fluid" style="">
	<div class="row" style="">
		<div class="col-xs-12 col-md-offset-4 col-md-4" style="">
			<img width="100%" class="center-block" src="/img/voucher/index2.png"/>
		</div>
	</div>
</div>

<br/>
<div style="width:100%;text-align:center">
	<a class="lighten" style="color:black;text-decoration:underline;font-size: 13px;">查看店铺</a>
</div>

<br/><br/><br/><br/><br/>


<!-- <div class="" style="width:100%;position:fixed;bottom:5px;text-align:center;">
			<button class="btn btn-default" style="width:10rem" type="submit" onclick="useCode();">兑换</button> 
			<button class="btn btn-default" style="width:10rem" type="submit">查询</button>
</div> -->




</html>