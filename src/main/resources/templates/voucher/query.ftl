<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="../../../../../../activity/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../../../../../../activity/js/common.js"></script>
<script type="text/javascript" src="../../../../../../activity/js/iosSelect.js"></script>
<link rel="stylesheet" href="../../../../../../activity/css/iosSelect.css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->


<link rel="stylesheet" href="../../../../../../activity/css/bootstrap.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../../../../../../activity/css/main.css">

<title>查询礼物</title>
<style type="text/css">
</style>
<script type="text/javascript">
	$(document).ready(function(){
	});

	var code = "A2019010110123"

	function saveAddr(){
		var form = $("#addrForm").serializeObject();
		console.log("form:"+ JSON.stringify(form));
		/*
		$.ajax({ 
			url: "http://127.0.0.1/saveAddr", 
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: form, 
			timeout: 6000,
			success: function(res){
	    		alert(res)
	    	},
	    	error: function(err){
	    		console.log(JSON.stringify(err));
	    		alert(err);
	    	}

	    });
		*/	
		//显示模态窗口
		$('#myModal').modal({
			show:true

		})
	}

	
	

</script>


</head>
<body style="background:#ddd;">
	<!-- <div class="header" style="">
		<span class="glyphicon glyphicon-menu-left" style="float:left;"></span>
		<div class="left"></div>
		<div class="center"></div>
		<div class="right"></div>
	</div> -->
	<div class="container-fluid clear-padding header" style="">
		<div class="row" style="padding:0 15px 0 15px;">
			<div class="col-xs-2 header-left">
				<span class="glyphicon glyphicon-menu-left"></span>
			</div>
			<div class="col-xs-8 header-center">查询礼物
			</div>
			<div class="col-xs-2 header-right">
			</div>
		</div>
	</div>


	<br/><br/>
	<div class="container-fluid" style="">
		<div class="row" style="">
			<div class="col-xs-12 col-md-offset-4 col-md-4" style="text-align:center;">
				<div style="margin-top:40px;">
					<form class="form-horizontal" style="">
						<div class="form-group">
							<label for="codeInput" class="control-label">券码</label> &nbsp;
							<input style="width:150px;display:inline-block" type="text" class="form-control" id="codeInput" name="code" placeholder="">
						</div>
						<p class="bg-danger" style="color:red">错误提示</p>
					</form>
						
				</div>
			</div>
		</div>
	</div>
	<br/>
	<div style="text-align:center">
		<button style="" class="btn btn-default orange-btn"  type="submit" onclick="saveAddr();">兑换礼品</button>
	</div>



	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">
	      <!-- <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
	      </div> -->
	      <div class="modal-body" style="text-align:center;">
	      	<!-- <img width="100%" class="center-block" src="img/timg.jpg"/> -->
	      	<br/>
	      	<p>
	      		您的礼物暂未兑换，
	      	</p>
	      	<p>
	      		快去兑换吧！
	      	</p>
	      	<br/>
	        <button style="padding:8px 50px;" class="btn btn-default orange-btn"  type="submit" onclick="saveAddr();" data-dismiss="modal">朕知道了</button>
	      </div>
	      <!-- <div class="modal-footer" style="text-align:center;">
	        
	      </div> -->
	    </div>
	  </div>
	</div>

	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

	<!-- <div>
		<form id="addrForm">
			姓名：<input name="name" type="text"/>
			<br/>
			手机号：<input name="mobile" type="text"/>
			<br/>
			地址：<input name="addr" type="text"/>
			<br/>

			<button type="button" class="btn btn-default" onclick="saveAddr()">提交</button>
		</form>
	</div> -->

</body>
</html>