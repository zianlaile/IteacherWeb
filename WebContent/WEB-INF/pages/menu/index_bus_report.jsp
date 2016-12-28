<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="page_allusers">
    <meta name="author" content="neog">
	<title>Hap Control</title>
	<link href="${ctx}/assets/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/assets/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="${ctx}/assets/jquery-easyui/themes/bootstrap/easyui.css" rel="stylesheet">
    <link href="${ctx}/assets/jquery-easyui/themes/icon.css" rel="stylesheet">
    <link href="${ctx}/assets/sb-admin-2/timeline.css" rel="stylesheet">
    <link href="${ctx}/assets/sb-admin-2/sb-admin-2.css" rel="stylesheet">
    <link href="${ctx}/assets/morrisjs/morris.css" rel="stylesheet">
    <link href="${ctx}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">    
</head>
<body>
	<div id="wrapper">
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="${ctx}/accountsIndex">Hello, World.</a>
            </div>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="${ctx}/accountsIndex"><i class="fa fa-user fa-fw"></i> 账号</a>
                        </li>
                        <li>
                            <a href="${ctx}/profilesIndex"><i class="fa fa-file-text fa-fw"></i> 用户资料</a>
                        </li>
                        <li>
                            <a href="${ctx}/feelingsIndex"><i class="fa fa-comments-o fa-fw"></i> 信息流</a>
                        </li>
                        <li>
                            <a href="${ctx}/accountsIndex"><i class="fa fa-exclamation-triangle fa-fw"></i> 黑名单</a>
                        </li>
                        <li>
                            <a href="${ctx}/accountsIndex"><i class="fa fa-picture-o fa-fw"></i> 头像审核</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 匹配用户<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${ctx}/usersIndex">所有用户</a>
                                </li>
                                <li>
                                    <a href="${ctx}/recomsIndex">推荐名单</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            注：主要展示用户头像和坦白，具体查看资料信息；选中后进行操作；性别1表示男，2表示女
                        </div>
                        <div class="panel-body">
                        	<table class="easyui-datagrid" id="users_table" title="所有用户" width="100%"
                        		toolbar="#tb"
								data-options="
									rownumbers:true,
									fitColumns:true,
									pagination:true,
									singleSelect:true,
									url:'${ctx}/xxxxx',
									method:'get'">
								<thead>
									<tr>
										<th data-options="field:'id',width:4,hidden:'true'">mongoid</th>
										<th data-options="field:'gender',width:1,hidden:'true'">gender</th>
										<th data-options="field:'userid',width:18,hidden:'true'">userid</th>
										<th data-options="field:'nickname',width:2,hidden:'true'">nickname</th>
										<th data-options="field:'picid',width:13.5">headpic</th>
										<th data-options="field:'tanbai',width:61.5">tanbai</th>
									</tr>
								</thead>
							</table>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

		<div id="tb" style="padding:5px;height:auto">
			userid: <input class="easyui-textbox" style="width:180px" id="userid_search">
			<a class="easyui-linkbutton" id="btn_search"><i class="fa fa-search fa-fw"></i>Search</a>
			<a class="easyui-linkbutton" id="btn_add" style="margin-left:20px"><i class="fa fa-plus-circle fa-fw"></i>加入推荐</a>
		</div>
		<!-- 未选中时弹出框 -->
		<div id="w_tip" class="easyui-window" title="tip" data-options="closed:true" style="width:250px;height:120px;padding:4px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:5px;">
					请选择需要添加的用户(选中行)...
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a class="easyui-linkbutton" href="javascript:void(0)" onclick="javascript:$('#w_tip').window('close')" style="width:80px">Ok</a>
				</div>
			</div>
		</div>
		<!-- 添加确认弹出框 -->
		<div id="w_add" class="easyui-window" title="info" data-options="iconCls:'fa fa-question-circle',closed:true" style="width:250px;height:120px;padding:4px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:5px;">
					确定添加到推荐名单？
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a class="easyui-linkbutton" id="btn_user_add" style="width:80px">Ok</a>
				</div>
			</div>
		</div>
		<div id="w_ok" class="easyui-window" title="ok" data-options="closed:true" style="width:250px;height:120px;padding:4px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:5px;">
					已成功添加到推荐名单！
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a class="easyui-linkbutton" href="javascript:void(0)" onclick="javascript:$('#w_ok').window('close')" style="width:80px">Ok</a>
				</div>
			</div>
		</div>
    </div>
    
    <script src="${ctx}/assets/jquery-1.11.3/jquery.min.js"></script>
    <script src="${ctx}/assets/bootstrap-3.3.6/js/bootstrap.min.js"></script>
    <script src="${ctx}/assets/metisMenu/metisMenu.min.js"></script>
    <script src="${ctx}/assets/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/assets/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="${ctx}/assets/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    <script src="${ctx}/assets/sb-admin-2/sb-admin-2.js"></script>
    
	<script type="text/javascript">
    // 搜索按钮
    $('#btn_search').click(function() {
    	var userid = $("#userid_search").val();
    	var para = {"userid":userid};
    	$('#users_table').datagrid({queryParams: para});	
    });
    // 加入推荐按钮
    $('#btn_add').click(function() {
    	var row = $('#users_table').datagrid('getSelected');
    	if(!row){
    		$('#w_tip').window('center');
        	$('#w_tip').window('open');
    		return;
    	}
    	$('#w_add').window('center');
    	$('#w_add').window('open');	
    });
    // 确定添加按钮
    $('#btn_user_add').click(function() {
    	var row = $('#users_table').datagrid('getSelected');
    	 $.ajax({ 
	            type : "post", 
	            url  :  "${ctx}/xxxx",  
	            cache : false, 
	            data : {userid:row.userid,gender:row.gender}, 
	            success : function(data){  
	                if(data.result == 0){ 	
	                	$('#w_ok').window('center');
	                	$('#w_ok').window('open');
	                	$('#w_add').window('close');	
	                }  
	            }, 
	            error : function(data){  
	                alert("系统错误");  
	            }
	     }); 	
    });
    // 自定义grid显示
    var cardview = $.extend({}, $.fn.datagrid.defaults.view, {
		renderRow: function(target, fields, frozen, rowIndex, rowData){
			var cc = [];
			cc.push('<td colspan=' + fields.length + ' style="padding:10px 5px;border:0;">');
			if (!frozen){
				var img = rowData['picid'];
				cc.push('<img src="h' + img + '" style="width:150px;float:left">');
				cc.push('<div style="float:left;margin-left:2px;">');
				cc.push('<p>坦白：' + rowData['tanbai'] + '</p>');
				cc.push('<p>性别：' + rowData['gender'] + '</p>');
				cc.push('</div>');
			}
			cc.push('</td>');
			return cc.join('');
		}
	});
    $(document).ready(function() { 
    	$('#users_table').datagrid({
			view: cardview
		}); 
    }); 
	
    </script>
    
    
</body>
</html>