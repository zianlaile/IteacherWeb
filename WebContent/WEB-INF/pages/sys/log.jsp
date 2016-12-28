<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Iteacher Login</title>
	<script type="text/javascript" src="${ctx}/assets/jquery-1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/jquery-1.11.3/jquery-form.js"></script>
    <script type="text/javascript" src="${ctx}/assets/bootstrap-3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="${ctx}/assets/bootstrap-3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/assets/jquery-easyui/themes/icon.css">
    <link rel="stylesheet" href="${ctx}/assets/jquery-easyui/themes/bootstrap/easyui.css">
</head>
<body style="width:100%">
	<div align="center" style="margin-top:50px">
	 	<div class="easyui-panel" title="Iteacher.inc" style="width:400px;padding:30px 70px 20px 70px;">
			<form id="loginForm" >
			<div style="margin-bottom:10px">
				<input id="username" name = "username" class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
			</div>
			<div style="margin-bottom:20px">
				<input id="password" name = "password" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
			</div>
				<div style="margin-bottom:20px">
				<input type="checkbox" checked="checked">
				<span>Remember me</span>
			</div>
			<div>
				<a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
					<span style="font-size:14px;">Login</span>
				</a>
			</div>
			</form>
		</div>
	</div>
	<script>
    $().ready(function() { 
    	$('#btn').bind('click', function(){ 
	        var formData = $('#loginForm').serialize();
	        $.ajax({ 
	            type : "post", 
	            url  :  "${ctx}/user/checkLoginUser",  
	            cache : false, 
	            data : formData, 
	            success : function(data){  
	                if(data.ret == 0){ 
	                	window.location='${ctx}/sessionIndex';
	                }else{ 
	                	alert(data.info); 
	                }  
	            }, 
	            error : function(data){  
	                alert("系统错误");  
	            }
	        }); 
	    });
	});
	</script>
</body>
</html>