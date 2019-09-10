<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="../../../../../../activity/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../../../../../../activity/js/common.js"></script>
<script type="text/javascript" src="../../../../../../activity/js/iosSelect.js"></script>
<script type="text/javascript" src="../../../../../../activity/js/divisions_of_China.js"></script>
<link rel="stylesheet" href="../../../../../../activity/css/iosSelect.css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->


<link rel="stylesheet" href="../../../../../../activity/css/bootstrap.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../../../../../../activity/css/main.css">

<title>保存地址</title>
<style type="text/css">
</style>
<script type="text/javascript">
	$(document).ready(function(){
		initSelect();
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

	function initSelect(){
		// var provinces = [
		//     {'id': '0101', 'value': '1级A', 'parentId': '0'},
		//     {'id': '0102', 'value': '1级B', 'parentId': '0'},
		// ];

		// var citys = [
		//     {'id': '0201', 'value': '2级0201', 'parentId': '0101'},
		//     {'id': '0202', 'value': '2级0202', 'parentId': '0101'},
		//     {'id': '0203', 'value': '2级0203', 'parentId': '0102'},
		// ];

		// var counties = [
		//     {'id': '0301', 'value': '3级01', 'parentId': '0202'},
		//     {'id': '0302', 'value': '3级03', 'parentId': '0202'},
		//     {'id': '0303', 'value': '3级04', 'parentId': '0201'},
		//     {'id': '0304', 'value': '3级02', 'parentId': '0203'},
		// ];


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
			<div class="col-xs-8 header-center">填写地址
			</div>
			<div class="col-xs-2 header-right">
			</div>
		</div>
	</div>


	<br/><br/>
	<div class="container-fluid" style="">
		<div class="row" style="">
			<div class="col-xs-12 col-md-offset-4 col-md-4" style="text-align:center;">
				<div style="background:#fff;margin-top:40px;">
					<br/>
					<br/>
					<p style="color:red;">请填写真实有效的信息，以防止出现收获异常</p>
					<form class="form-horizontal" style="padding:20px 15px 20px 15px;">
						<div class="form-group">
							<label style="text-align:left;" for="realnameInput" class="col-xs-3 control-label">姓名</label>
							<div class="col-xs-9">
								<input style="" type="text" class="form-control" id="realnameInput" name="realname" placeholder="收货人">
							</div>
						</div>
						<div class="form-group">
							<label style="text-align:left;" for="mobileInput" class="col-xs-3 control-label">手机号</label>
							<div class="col-xs-9">
								<input style="" type="text" class="form-control" id="mobileInput" name="mobile" placeholder="11位手机号">
							</div>
						</div>
						<div class="form-group">
							<label style="text-align:left;" for="areaInput" class="col-xs-3 control-label">所在地区</label>
							<!-- <div class="col-xs-9">
								<input style="" type="text" class="form-control" id="areaInput" name="area" placeholder="">
							</div> -->

							<div class="input-group col-xs-9" style="padding-left:15px;padding-right:15px;">
							  <input style="background:#fff;" readonly id="areaInput" type="text" class="form-control" placeholder="" aria-describedby="basic-addon2">
							  <input type="hidden" name="areaInputValue" id="areaInputValue" value="" data-city-name="">
							  <span class="input-group-addon" id="basic-addon2">
							  	<span class="glyphicon glyphicon-map-marker" style="color:rgb(85, 176, 252)"></span>
							  </span>
							</div>
						</div>
						<div class="form-group">
							<label style="text-align:left;" for="addressInput" class="col-xs-3 control-label">详细地址</label>
							<div class="col-xs-9">
								<input style="" type="text" class="form-control" id="addressInput" name="address" placeholder="如道路、小区/大厦/学校">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<input style="" type="text" class="form-control" id="addressInput2" name="address2" placeholder="楼号/门牌号等">
							</div>
						</div>





						<p class="bg-danger" style="color:red">错误提示</p>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	<br/>
	<div style="text-align:center">
		<button style="" class="btn btn-default orange-btn"  type="submit" onclick="saveAddr();">提交</button>
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
	      	<img width="100%" class="center-block" src="img/timg.jpg"/>
	      	<br/>
	      	<p>
	      		<h4>礼品兑换成功</h4>
	      		预计3-5天能收货，请注意查收
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