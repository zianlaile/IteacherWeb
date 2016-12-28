<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
	var datagrid;
	$(function() {
		$('#menu_sessionxx_datagrid').datagrid({
			url : '${ctx}/user/session/list',
			pagination : true,
			fit : true,
			rownumbers : true,
			fitColumns : true,
			singleSelect : true,
			method : 'get',
			nowrap : false,
			border : false,
			idField : 'id',
			columns : [ [ {
				field : 'id',
				title : 'id',
				width : 10
			}, {
				field : 'sessionid',
				title : 'sessionid',
				width : 30
			}, {
				field : 'userid',
				title : 'userid',
				width : 30
			}, {
				field : 'last_online',
				title : 'last_online',
				width : 30
			} ] ]
		});
	});
</script>

<table id="menu_sessionxx_datagrid" data-options="
	 	fit : true,
	 	border : false">
</table>
