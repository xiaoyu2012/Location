<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<div class="easyui-tabs">
	 <div title="待处理">		
		<table id="mydatagrid" style="width:350px;height:500px">
		<thead>
			<tr>
				<th data-options="field:'userId',width:30,align:'right'">报警人</th>
				<th data-options="field:'address',width:70,align:'right'">报警位置</th>
				<th data-options="field:'time',width:70,align:'right'">报警时间</th>	
				<th hidden="hidden"	data-options="field:'radius',width:80,align:'right'">半径</th>	
				<th hidden="hidden"	data-options="field:'longitude',width:80,align:'right'">经度</th>
				<th hidden="hidden"	data-options="field:'latitude',width:80,align:'right'">纬度</th>
				<th hidden="hidden"	data-options="field:'alarmInfoId',width:80,align:'right'">报警ID</th>
				<th hidden="hidden"	data-options="field:'type',width:80,align:'right'">报警类型</th>
				<th hidden="hidden"	data-options="field:'identify',width:80,align:'right'">识别号</th>
			</tr>
		</thead>
		</table> 	
	</div> 
	<div title="报警历史记录">	
		<table id="mydatagrid2" style="width:330px;height:500px">
		<thead>
			<tr>
				<th data-options="field:'userId',width:30,align:'right'">报警人</th>
				<th data-options="field:'address',width:70,align:'right'">报警位置</th>
				<th data-options="field:'time',width:70,align:'right'">报警时间</th>	
				<th hidden="hidden"	data-options="field:'radius',width:80,align:'right'">半径</th>	
				<th hidden="hidden"	data-options="field:'longitude',width:80,align:'right'">经度</th>
				<th hidden="hidden"	data-options="field:'latitude',width:80,align:'right'">纬度</th>
				<th hidden="hidden"	data-options="field:'alarmInfoId',width:80,align:'right'">报警ID</th>
				<th hidden="hidden"	data-options="field:'type',width:80,align:'right'">报警类型</th>
				<th hidden="hidden"	data-options="field:'identify',width:80,align:'right'">识别号</th>
			</tr>
		</thead>
		</table> 	
	</div>
</div>

<script type="text/javascript">  
    $(function() {          //当文档执行完毕就执行
        $('#mydatagrid').datagrid({          
              
            pageSize : 10,//默认选择的分页是每页5行数据  
            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合  
            nowrap : false,//设置为true，当数据长度超出列宽时将会自动截取  
            striped : true,//设置为true将交替显示行背景。  
            collapsible : true,//显示可折叠按钮  
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
            url:'getAllAlarmInfoAction.action?state=0',//url调用Action方法  
            loadMsg : '数据装载中......',  
            singleSelect:true,//为true时只能选择单行  
            fitColumns:true,//允许表格自动缩放，以适应父容器  
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序  
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。  
            remoteSort : false,          
            pagination : true,//分页  
            rownumbers : true//行数  
        });   
          
    });  
    
    $(function() {          //当文档执行完毕就执行
        $('#mydatagrid2').datagrid({          
              
            pageSize : 10,//默认选择的分页是每页5行数据  
            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合  
            nowrap : false,//设置为true，当数据长度超出列宽时将会自动截取  
            striped : true,//设置为true将交替显示行背景。  
            collapsible : true,//显示可折叠按钮  
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
            url:'getAllAlarmInfoAction.action?state=2',//url调用Action方法  
            loadMsg : '数据装载中......',  
            singleSelect:true,//为true时只能选择单行  
            fitColumns:true,//允许表格自动缩放，以适应父容器  
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序  
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。  
            remoteSort : false,          
            pagination : true,//分页  
            rownumbers : true//行数  
        });   
          
    });
    
	//timerID = setInterval("Reflash()",2000);     //2秒刷新一次
	
	function Reflash(){
		$('#mydatagrid').datagrid('reload');
		$('#mydatagrid2').datagrid('reload');
	}
       
    
</script>


<script type="text/javascript">	     //待处理
	var alarmInfoId = 1;
 	$('#mydatagrid').datagrid({   
 		onClickRow: function(index, row) {
 			var userId = row["userId"];
 			var identify = row["identify"]; 	
 			alarmInfoId = row["alarmInfoId"];
 			/*
 			var state = row["state"];
 			var radius = row["radius"];
 			var longitude = row["longitude"];
 			var latitude = row["latitude"];
 			var alarmInfoId = row["alarmInfoId"];
 			var address = row["address"];
 			var time = row["time"];
 			*/
 			changeState(alarmInfoId, 1);
 			showUserInfo(identify, userId);
 			addTab(userId,"getOnceAlarmInfoAction.action?userId="+userId+"&identify="+identify);
 		}
 	});
 	
 	$('#mydatagrid2').datagrid({      //历史报警记录
 		onClickRow: function(index, row2) {
 			var userId = row2["userId"];
 			var identify = row2["identify"];
 			alarmInfoId = row2["alarmInfoId"];
 			
 			
 			/*
 			var state = row["state"];
 			var radius = row["radius"];
 			var longitude = row["longitude"];
 			var latitude = row["latitude"];
 			var alarmInfoId = row["alarmInfoId"];
 			var address = row["address"];
 			var time = row["time"];
 			*/
 			
 			showUserInfo(identify, userId);
 			addTab(userId,"getOnceAlarmInfoAction.action?userId="+userId+"&identify="+identify);
 		}
 	});
 	
	 var row = $('#mydatagrid').datagrid('getSelected');	
	 var row2 = $('#mydatagrid2').datagrid('getSelected');	
	 /*
    if(row) {
    	alert('UserId:' + row.userId + 'Address:' + address );
    } */
</script>

<script type="text/javascript">
	function getXhr() {
		var xhr = null;
		//浏览器判定
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		} else {
			xhr = new ActiveXObject("Micsoft.XMLHttp");
		}
		return xhr;
	}
	
	function changeState(alarmInfoId,state){
		var xhr = getXhr();
		var url = "changeStateAction.action?alarmInfoId=" + alarmInfoId + "&state=" + state;
		xhr.open("get",url, true);		
		xhr.send(null);
	}
	
	function showUserInfo(identify, userId){
		var xhr=getXhr();
		//get请求	
		xhr.open("get","getUserInfo.action?userId="+userId,true);
		xhr.onreadystatechange=function(){
		   if(xhr.readyState==4){
		       if(xhr.status==200){
		          var user=eval("(" + xhr.responseText + ")"); //获取文本
		          var id = document.getElementById("id");
		          id.innerHTML=userId;
		          var name = document.getElementById("name");
		          name.innerHTML=user.name;
		          var sex = document.getElementById("sex");
		          sex.innerHTML=user.sex;
		          var tel = document.getElementById("tel");
		          tel.innerHTML=user.tel;
		          var ename = document.getElementById("ename");
		          ename.innerHTML=user.ename;
		          var etel = document.getElementById("etel");
		          etel.innerHTML=user.etel;
		          var identify2 = document.getElementById("identify");
		          identify2.innerHTML=identify;   	          
		       }
		   }
		};
		xhr.send(null);
	}
	
</script>
