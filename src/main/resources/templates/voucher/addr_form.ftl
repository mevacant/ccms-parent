<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/iosSelect.js"></script>
<script type="text/javascript" src="/js/divisions_of_China.js"></script>
<link rel="stylesheet" href="/css/iosSelect.css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->


<link rel="stylesheet" href="/css/bootstrap.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/main.css">

<title>保存地址</title>
<style type="text/css">
    .col-xs-3 {
        text-align: left;
		font-size: 16px;
		font-weight: bold;
		line-height: 40px;
	}

    .orange-btn-know{
        background: url("/img/voucher/btn_know.png") no-repeat;
        width: 187px;
        height:46.5px;
        background-size:100% 100%;
        border-style: none;
        padding: 0;
    }

    .orange-btn-submit{
        background: url("/img/voucher/btn_submit.png") no-repeat;
        width: 295px;
        height:49px;
        background-size:100% 100%;
        border-style: none;
        padding: 0;
    }
</style>
<script type="text/javascript">
	$(document).ready(function(){
		initSelect();
	});

	var code = "A2019010110123"

	function saveAddr(){

        $('#myModal').modal({
            show:true
        })


		/*
        var realname = $("#realnameInput").val();
        var mobile = $("#mobileInput").val();
        var area = $("#areaInput").val();
        var address = $("#addressInput").val();
        var address2 = $("#addressInput2").val();

        var errorDom = $("#errorDom");
        if(realname == ""){
            showError(errorDom, "请输入收货人姓名");
            return;
        }
        if(mobile == ""){
            showError(errorDom, "请输入手机号");
            return;
        }
        if(area == ""){
            showError(errorDom, "请输入所在地区");
            return;
        }
        if(address == ""){
            showError(errorDom, "请输入详细地址");
            return;
        }



        var form = $("#addrForm").serializeObject();
        console.log("form:"+ JSON.stringify(form));

        form.addr = address+address2;


        invoke("/voucher/saveAddress",form, function(res){
            //alert(JSON.stringify(res));
            if(res != null && "1" == res.success){
                //兑换成功
                //显示模态窗口
                $('#myModal').modal({
                	show:true
                })
            }else{
                //兑换失败
                // $("#codeInput").val("");
                // showError($("#errorDom"), res.error.message);
                alert(res.error.message);
            }
        },"json");

		*/


	}

	function initSelect(){

		//var data=[{'id': '10001', 'value': '演示数据1'},{'id': '10002', 'value': '演示数据2'}];
		var showDom = document.querySelector('#areaInput');// 绑定一个触发元素
		var areaInputValueDom = $("#areaInputValue");
		showDom.addEventListener('click', function () {  // 添加监听事件
		    //默认值
		    var oneLevelId = areaInputValueDom.attr('data-province-code');
	        var twoLevelId = areaInputValueDom.attr('data-city-code');
	        var threeLevelId = areaInputValueDom.attr('data-district-code');
	        console.log("%s:%s:%s",oneLevelId,twoLevelId,threeLevelId);

			// 实例化组件
		    var example = new IosSelect(3,               // 第一个参数为级联层级，演示为1
		        [provinces,citys,counties],                             // 演示数据
		        {
		            container: '.container',             // 容器class
		            //title: '演示标题',                    // 标题
		            itemHeight: 50,                      // 每个元素的高度
		            relation: [1, 1], 					 //[1级-2级是否parentid关联 ,2级-3级是否parentid关联]
		            oneLevelId: oneLevelId,				//默认值
	                twoLevelId: twoLevelId,
	                threeLevelId: threeLevelId,
		            //itemShowCount: 3,                    // 每一列显示元素个数，超出将隐藏
		            callback: function (selectOneObj,selectTwoObj,selectThreeObj) {  // 用户确认选择后的回调函数
		                areaInput.value = selectOneObj.value + ' ' + selectTwoObj.value + ' ' + selectThreeObj.value;
		                
		                areaInputValueDom.attr('data-province-code', selectOneObj.id);
	                    areaInputValueDom.attr('data-city-code', selectTwoObj.id);
	                    areaInputValueDom.attr('data-district-code', selectThreeObj.id);
		            }
		    });
		});
	}
	

</script>


</head>
<body style="">

	<div class="container-fluid clear-padding header" style="z-index: 999;">
		<div class="row" style="padding:0 15px 0 15px;">
			<div class="col-xs-2 header-left" onclick="pageBack()">
				<div class="header-icon"></div>
			</div>
			<div class="col-xs-8 header-center">填写地址
			</div>
			<div class="col-xs-2 header-right">
			</div>
		</div>
	</div>



	<div class="container-fluid" style="position: relative;margin-top: 55px">
        <div style="position: absolute;z-index:99; top:0;left:50%;margin-left:-55.5">
            <img style="width: 115px;height: 135px" src="/img/voucher/form_gift.png">
        </div>
		<div class="row" style="">
			<div class="col-xs-12 col-md-offset-4 col-md-4" style="text-align:center;background:#DDDED5;">
				<div style="position:relative;background:#fff;margin-top:40px;padding: 10px 10px;">
					<div style="width: 100%;height: auto;border: 1px #D39F6A solid;">
						<p style="color:red;margin-top:50px;">请填写真实有效的信息，以防止出现收获异常</p>
						<form id="addrForm" class="form-horizontal" style="padding:20px 0 20px 15px;">
							<#--<div class="form-group">-->
								<#--<label style="text-align:left;" for="realnameInput" class="col-xs-3 control-label">姓名</label>-->
								<#--<div class="col-xs-9">-->
									<#--<input style="" type="text" class="form-control" id="realnameInput" name="name" placeholder="收货人">-->
								<#--</div>-->
							<#--</div>-->
                            <div class="row" style="font-size: 16px;margin: 10px 0px;">
                                <div class="col-xs-3 clear-padding-col" style="">姓名</div>
                                <div class="col-xs-9" style="text-align: left">
                                    <input style="height: 40px;width:100%;" type="text" class="line-input" id="realnameInput" name="name" placeholder="收货人">
                                </div>
                            </div>

							<#--<div class="form-group">-->
								<#--<label style="text-align:left;" for="mobileInput" class="col-xs-3 control-label">手机号</label>-->
								<#--<div class="col-xs-9">-->
									<#--<input style="" type="text" class="form-control" id="mobileInput" name="mobile" placeholder="11位手机号">-->
								<#--</div>-->
							<#--</div>-->
							<div class="row" style="font-size: 16px;margin: 10px 0px;">
								<div class="col-xs-3 clear-padding-col" style="">手机号</div>
								<div class="col-xs-9" style="text-align: left">
									<input style="height: 40px;width:100%;" type="text" class="line-input" id="mobileInput" name="mobile" placeholder="11位手机号">
								</div>
							</div>

							<#--<div class="form-group">-->
								<#--<label style="text-align:left;" for="areaInput" class="col-xs-3 control-label">所在地区</label>-->
								<#--<div class="input-group col-xs-9" style="padding-left:15px;padding-right:15px;">-->
								  <#--<input style="background:#fff;" readonly id="areaInput" name="area" type="text" class="form-control" placeholder="" aria-describedby="basic-addon2">-->
								  <#--<input type="hidden" name="areaInputValue" id="areaInputValue" value="" data-city-name="">-->
									<#--<input type="hidden" name="code" value="${code!""}" >-->
								  <#--<span class="input-group-addon" id="basic-addon2">-->
									<#--<span class="glyphicon glyphicon-map-marker" style="color:rgb(85, 176, 252)"></span>-->
								  <#--</span>-->
								<#--</div>-->
							<#--</div>-->
							<div class="row" style="font-size: 16px;margin: 10px 0px;">
								<div class="col-xs-3 clear-padding-col" style="">所在地区</div>
								<div class="col-xs-9" style="text-align: left;position: relative">
									<input style="height: 40px;width:100%;background:#fff;padding-right: 30px;" readonly type="text" class="line-input" id="areaInput" name="area" placeholder="" maxlength="10">
									<div style="position: absolute;top:8px;right: 20px">
										<img style="width: 16px;height: 19px;" src="/img/voucher/icon_map.png">
									</div>
                                    <#--<input style="height: 40px;width:20%;background:url('/img/voucher/icon-map.png');" readonly type="text" class="line-input" id="areaInput" name="area" placeholder="">-->
                                    <input type="hidden" name="areaInputValue" id="areaInputValue" value="" data-city-name="">
                                    <input type="hidden" name="code" value="${code!""}" >
								</div>
							</div>

							<#--<div class="form-group">-->
								<#--<label style="text-align:left;" for="addressInput" class="col-xs-3 control-label">详细地址</label>-->
								<#--<div class="col-xs-9">-->
									<#--<input style="" type="text" class="form-control" id="addressInput" name="address" placeholder="如道路、小区/大厦/学校">-->
								<#--</div>-->
							<#--</div>-->
							<div class="row" style="font-size: 16px;margin: 10px 0px;">
								<div class="col-xs-3 clear-padding-col" style="">详细地址</div>
								<div class="col-xs-9" style="text-align: left">
									<input style="height: 40px;width:100%;" type="text" class="line-input" id="addressInput" name="address" placeholder="如道路、小区/大厦/学校">
								</div>
							</div>
							<#--<div class="form-group">-->
								<#--<div class="col-xs-12">-->
									<#--<input style="" type="text" class="form-control" id="addressInput2" name="address2" placeholder="楼号/门牌号等">-->
								<#--</div>-->
							<#--</div>-->
							<div class="row" style="font-size: 16px;margin: 10px 0px;">
								<div class="col-xs-12 clear-padding-col" style="text-align: left;padding-right: 15px;">
									<input style="height: 40px;width:100%;" type="text" class="line-input" id="addressInput2" name="address2" placeholder="楼号/门牌号等">
								</div>
							</div>





							<p id="errorDom" class="errorSpan" style="">错误提示</p>

						</form>
                    </div>
				</div>


                <br/>
                <br/>
                <div style="text-align:center">
                    <button style="" class="btn btn-default orange-btn-submit"  type="submit" onclick="saveAddr();"></button>
                </div>

				<br><br><br><br>

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
	      <div class="modal-body" style="text-align:center;padding-bottom: 23.3px;">
	      	<img width="100%" class="center-block" src="/img/voucher/success_gif.png"/>
	      	<br/>
	      	<p>
	      		<h4><strong>恭喜您，兑换成功</strong></h4>
	      		预计3-5天能收货，请注意查收
	      	</p>
	      	<br/>
			<div class="modal-absolute">
                <#--<button style="padding:8px 50px;" class="btn orange-btn"  type="submit" onclick="saveAddr();" data-dismiss="modal">朕知道了</button>-->
                <button style="" class="btn-no-border orange-btn-know"  type="button" onclick="saveAddr();" data-dismiss="modal"></button>
			</div>
	      </div>
	      <!-- <div class="modal-footer" style="text-align:center;">
	        
	      </div> -->
	    </div>
	  </div>
	</div>


</body>
</html>