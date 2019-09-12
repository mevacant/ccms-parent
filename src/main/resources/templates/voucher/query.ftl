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

<title>乔馥</title>
<style type="text/css">
    .orange-btn-query{
        background: url("/img/voucher/btn1_querygift_gold.png") no-repeat;
        width: 295px;
        height:49px;
        background-size:100% 100%;
        border-style: none;
        padding: 0;
    }

    .orange-btn-imm{
        background: url("/img/voucher/btn_redeem_immediately.png") no-repeat;
        width: 187px;
        height:46px;
        background-size:100% 100%;
        border-style: none;
        padding: 0;
    }
</style>
<script type="text/javascript">
	$(document).ready(function(){
	});


    function queryCode(){
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

        invoke("/voucher/queryCode",param, function(res){
            //alert(JSON.stringify(res));
            if(res != null && "1" == res.success){
                //显示模态窗口
                $('#myModal').modal({
                    show:true

                })
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
                window.location.href='/pages/addrForm?code='+code;
            }else{
                //兑换失败
                $("#codeInput").val("");
                showError($("#errorDom"), res.error.message);
            }
        });
    }

	
	

</script>


</head>
<body style="background:#DDDED5">
	<!-- <div class="header" style="">
		<span class="glyphicon glyphicon-menu-left" style="float:left;"></span>
		<div class="left"></div>
		<div class="center"></div>
		<div class="right"></div>
	</div> -->
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

    <div class="container-fluid" style="position: relative;">
        <div class="row" style="">
            <div class="col-xs-12 col-md-offset-4 col-md-4" style="text-align:center;padding-top: 90px;">
                <div style="position:relative;height:210px;background:#fff url('/img/voucher/bg_gift.png') no-repeat right;background-size:175px 195px;argin-top:40px;padding: 10px 10px;">
                    <div style="width: 100%;height:100%;border: 1px #f2e2d2 solid;">
						<form class="form-horizontal" style="margin-top: 60px;">
							<#--<div class="form-group">-->
								<#--<label for="codeInput" class="control-label">券码</label> &nbsp;-->
								<#--<input style="width:150px;display:inline-block" type="text" class="form-control" id="codeInput" name="code" placeholder="">-->
							<#--</div>-->
							<#--<p class="errorSpan" style="">错误提示</p>-->



                            <div class="row" style="font-size: 16px;">
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
						</form>
					</div>
                </div>


                <br/><br/>
                <div style="text-align:center">
				<#--<button style="" class="btn btn-default orange-btn"  type="submit" onclick="saveAddr();">兑换礼品</button>-->
                    <button style="" class="btn btn-default orange-btn-query"  type="submit" onclick="queryCode();"></button>
                </div>



                <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

                <div style="color: #8D8D8D;text-align: center;font-size: 12px;">
                    <p>
                        如有疑问，请关注乔馥公众号( Truffle_man ) 进行留言
                    </p>
                    <p>
                        或拨打客服热线：021-52925205
                    </p>
                </div>
                <br/><br/>

            </div>
        </div>
    </div>







	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content modal-content-no-border">
	      <!-- <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
	      </div> -->
			<div style="position: absolute;top:-66px;right: 0;margin: auto;">
				<img style="width: 48%;" src="/img/voucher/gift2_pop.png">
			</div>

	      <div class="modal-body" style="text-align:center;font-size: 16px;font-weight: bold;padding: 60px 0 23px 0">
	      	<!-- <img width="100%" class="center-block" src="img/timg.jpg"/> -->
	      	<p>
	      		您的礼物暂未兑换，
	      	</p>
	      	<p>
	      		快去兑换吧！
	      	</p>
			  <br/>
	        <#--<button style="padding:8px 50px;" class="btn btn-default orange-btn"  type="submit" onclick="saveAddr();" data-dismiss="modal">朕知道了</button>-->
		   	<div class="modal-absolute">
			  <button style="" class="btn-no-border orange-btn-imm"  type="button" onclick="useCode();" data-dismiss="modal"></button>
		  	</div>

	      </div>
	      <!-- <div class="modal-footer" style="text-align:center;">

	      </div> -->
	    </div>
	  </div>
	</div>





</body>
</html>