<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/iosSelect.js"></script>
<link rel="stylesheet" href="/css/iosSelect.css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->


<link rel="stylesheet" href="/css/bootstrap.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/main.css">

<title>礼品已兑换</title>
<style type="text/css">
    .orange-btn-change{
        background: url("/img/voucher/btn_changea_dd.png") no-repeat;
        width: 115px;
        height:35px;
        background-size:100% 100%;
        border-style: none;
        padding: 0;
    }
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
<body style="background:#DDDED5;">
	<div class="container-fluid clear-padding header" style="z-index: 999;">
		<div class="row" style="padding:0 15px 0 15px;">
			<div class="col-xs-2 header-left" onclick="pageBack()">
				<div class="header-icon"></div>
			</div>
			<div class="col-xs-8 header-center">查询礼物
			</div>
			<div class="col-xs-2 header-right">
			</div>
		</div>
	</div>


	<div class="container-fluid" style="margin-top: 90px;">
		<div class="row" style="">
			<div class="col-xs-12 col-md-offset-4 col-md-4" style="">
                <div style="position:relative;height:210px;background:#fff url('/img/voucher/bg_logo.png') no-repeat left;background-size:210px 190px;argin-top:40px;padding: 40px 20px;font-size: 14px;">
					<p style="">上海市 xxx xxxxxxxxxxxxxxxxxxxxxxxx</p>
					<p style="">xxxxxxxxxxxxxxxxxxxxxxxx</p>

					<div style="position: absolute;bottom: 40px;right: 40px;">
                        <button  class="btn-no-border orange-btn-change"  type="button" onclick="saveAddr();"></button>
					</div>

				</div>
			</div>
		</div>
	</div>
	<br/>



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

    <div style="color: #8D8D8D;text-align: center;">
        <p>
            如有疑问，请关注乔馥公众号( Truffle_man ) 进行留言
        </p>
        <p>
            或拨打客服热线：021-52925205
        </p>
    </div>
    <br/><br/>

</body>
</html>