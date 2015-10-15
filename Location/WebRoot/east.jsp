<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<div class="easyui-tabs">
	 <div title="待处理">		
		<table id="mydatagrid" style="width:297px;height:500px">
		<thead>
			<tr>
				<th data-options="field:'userId',width:50,align:'right'">报警人</th>
				<th data-options="field:'address',width:70,align:'right'">报警位置</th>
				<th data-options="field:'state',width:80,align:'right'">报警时间</th>	
				<th hidden="hidden"	data-options="field:'radius',width:80,align:'right'">半径</th>	
				<th hidden="hidden"	data-options="field:'longitude',width:80,align:'right'">经度</th>
				<th hidden="hidden"	data-options="field:'latitude',width:80,align:'right'">纬度</th>
				<th hidden="hidden"	data-options="field:'alarmInfoId',width:80,align:'right'">报警类型</th>
			</tr>
		</thead>
		</table> 	
	</div> 
	<div title="报警历史记录">	
		<table class="easyui-datagrid" style="width:297px;height:500px"
			data-options="singleSelect:true,collapsible:true,url:'GetAllAlarmInfoAction.action',method:'post'">
		<thead>
			<tr>
				<th data-options="field:'userId',width:50,align:'right'">报警人</th>
				<th data-options="field:'address',width:100,align:'right'">报警位置</th>
				<th data-options="field:'state',width:100,align:'right'">报警时间</th>	
				<th hidden="hidden"	data-options="field:'radius',width:80,align:'right'">半径</th>	
				<th hidden="hidden"	data-options="field:'longitude',width:80,align:'right'">经度</th>
				<th hidden="hidden"	data-options="field:'latitude',width:80,align:'right'">纬度</th>
				<th hidden="hidden"	data-options="field:'alarmInfoId',width:80,align:'right'">报警类型</th>		
			</tr>
		</thead>
		</table> 	
	</div>
</div>

<script type="text/javascript">  
    $(function() {          //当文档执行完毕就执行
        $('#mydatagrid').datagrid({          
              
            pageSize : 5,//默认选择的分页是每页5行数据  
            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合  
            nowrap : false,//设置为true，当数据长度超出列宽时将会自动截取  
            striped : true,//设置为true将交替显示行背景。  
            collapsible : true,//显示可折叠按钮  
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
            url:'GetAllAlarmInfoAction.action',//url调用Action方法  
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
	}
       
    
</script>


<<script type="text/javascript">	
 	$('#mydatagrid').datagrid({   
 		onClickRow: function(index, row) {
 			var userId = row["userId"];
 			var state = row["state"];
 			var radius = row["radius"];
 			var longitude = row["longitude"];
 			var latitude = row["latitude"];
 			var alarmInfoId = row["alarmInfoId"];
 			var address = row["address"];
 			addTab(userId,"map/mapPoint.jsp?longitude="+longitude+"&latitude="+latitude+"&address=" + address);
 		}
 	});
	var row = $('#mydatagrid').datagrid('getSelected');	
	
    if(row) {
    	alert('UserId:' + row.userId + 'Address:' + address );
    }
</script>
