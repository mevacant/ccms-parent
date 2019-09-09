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

<title>活动</title>
<script type="text/javascript">
	$(document).ready(function(){
		//alert($("#codeInput").offset().top);
	});

	//var code = "A2019010110123"

	function useCode(){
		var code = $("#codeInput").val();
		//console.log(code);
		if(code == ""){
			var errorDom = $("#errorDom");
			showError(errorDom, "请输入券码");
			return;
		}

		var param = {
		    code : code,
			userId : 0
		}
		
		invoke("/voucher/useCode",param, function(res){
			//alert(JSON.stringify(res));
			if(res != null && "1" == res.success){
			    //兑换成功
			}else{
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
		<div class="col-xs-12 col-md-offset-4 col-md-4" style="background:#ddd;text-align:center;">
			<img width="100%" class="center-block" src="/img/timg.jpg"/>
			<br/>
			<div>
				<form class="form-horizontal" style="">
					<div class="form-group" style="margin-bottom:0;">
						<label for="codeInput" class="control-label">券码</label> &nbsp;
						<input style="width:150px;display:inline-block" type="text" class="form-control" id="codeInput" name="code" placeholder="">
					</div>
					<p id="errorDom" class="bg-danger" style="color:red;font-size:12px;margin:5px 0;visibility:hidden;">错误提示</p>
					<button style="" class="btn btn-default orange-btn"  type="button" onclick="useCode();">兑换礼品</button>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="" style="z-index:999;width:60px;height:40px;border-top-left-radius:40px;border-bottom-left-radius:40px;position:fixed;right:0;top:227px;text-align:center;background:rgb(93, 90, 90);line-height:12px;color:fff;padding-top:8px;font-size:12px;box-shadow: 0px 3px 5px #888888;">
	<div>查询</div>
	<div>礼物</div>
</div>

<br/>
<div style="width:100%;text-align:center">
	<p>- 礼品展示 - </p>
</div>

<div class="container-fluid" style="">
	<div class="row" style="">
		<div class="col-xs-12 col-md-offset-4 col-md-4" style="">
			<img width="100%" class="center-block" src="/img/timg.jpg"/>
		</div>
	</div>
</div>

<br/>
<div style="width:100%;text-align:center">
	<a class="lighten">查看店铺</a>
</div>

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>


<!-- <div class="" style="width:100%;position:fixed;bottom:5px;text-align:center;">
			<button class="btn btn-default" style="width:10rem" type="submit" onclick="useCode();">兑换</button> 
			<button class="btn btn-default" style="width:10rem" type="submit">查询</button>
</div> -->




</html>