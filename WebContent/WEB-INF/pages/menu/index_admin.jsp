<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="page_admin">
    <meta name="author" content="zhou">
	<title>g_adm_account</title>
<jsp:include page="../inc.jsp"></jsp:include>  
</head>
<body>
	<div id="wrapper">
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="${ctx}/sessionIndex">Hello, World.</a>
            </div>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="${ctx}/sessionIndex"><i class="fa fa-user fa-fw"></i> Session</a>
                        </li>
                        <li>
                            <a href="${ctx}/AdminIndex"><i class="fa fa-file-text fa-fw"></i> 学校信息</a>
                        </li>
                        <li>
                            <a href="${ctx}/sessionIndex"><i class="fa fa-comments-o fa-fw"></i> 老师信息</a>
                        </li>
                        <li>
                            <a href="${ctx}/sessionIndex"><i class="fa fa-exclamation-triangle fa-fw"></i> 学生信息</a>
                        </li>
                        <li>
                            <a href="${ctx}/sessionIndex"><i class="fa fa-picture-o fa-fw"></i> 课程信息</a>
                        </li>

                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Blank Page</a>
                                </li>
                                <li>
                                    <a href="#">Blank Page</a>
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
                            Say hello.
                        </div>
                        <div class="panel-body">
                        	<table class="easyui-datagrid" id="table_adm" title="All Admin" width="100%"
                        		toolbar="#tb"
								data-options="
									rownumbers:true,
									fitColumns:true,
									pagination:true,
									singleSelect:true,
									url:'${ctx}/user/admin/list',
									method:'get'">
								<thead>
									<tr>
										<th data-options="field:'id',width:10">id</th>
										<th data-options="field:'userid',width:30">userid</th>
										<th data-options="field:'schoolid',width:30">schoolid</th>
										<th data-options="field:'password',width:30">password</th>
										<th data-options="field:'role',width:30">role</th>
										<th data-options="field:'username',width:30">username</th>
									</tr>
								</thead>
							</table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

 		<div id="tb" style="padding:5px;height:auto">
			<div>
				id: <input class="easyui-textbox" style="width:100px" id="id_adm">
				schoolid: <input class="easyui-textbox" style="width:150px" id="schoolid_search">
				uername: <input class="easyui-textbox" style="width:150px" id="username_search">
				<a class="easyui-linkbutton" id="btn_search"><i class="fa fa-search fa-fw"></i>Search</a>
				<a class="easyui-linkbutton" id="btn_delete" style="margin-left:10px"><i class="fa fa-trash fa-fw"></i>删除用户</a>
			</div>
		</div> 
		
    </div>
    

    
 	<script type="text/javascript">
    // 搜索按钮
    $('#btn_search').click(function() {
    	var id = $("#id_adm").val();
    	var sessionid = $("#schoolid_search").val();
    	var userid = $("#username_search").val();
    	var para = {"id":id,"schoolid":schoolid,"uername":uername};
    	$('#table_adm').datagrid({queryParams: para});	
    });
  	
    </script> 
    
    
</body>
</html>