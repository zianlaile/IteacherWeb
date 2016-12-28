<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<script type="text/javascript">
	var datagrid;
	$(function() {
		$('#menu_yhxx_datagrid').datagrid({
			url : '${ctx}/user/admin/list',
			/* title : '', */
			pagination : true,
			fit : true,
			rownumbers : false,
			fitColumns : true,
			singleSelect : false,
			method : 'get',
			nowrap : false,
			border : false,
			idField : 'id',
			columns : [ [ {
				field : 'id',
				title : 'id',
				width : 10,
				checkbox : true
			}, {
				field : 'userid',
				title : 'userid',
				width : 30
			}, {
				field : 'schoolid',
				title : 'schoolid',
				width : 30
			}, {
				field : 'password',
				title : 'password',
				width : 30
			}, {
				field : 'role',
				title : 'role',
				width : 30
			}, {
				field : 'username',
				title : 'username',
				width : 30
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_yhgl_appendFun();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'fa fa-trash fa-fw',
				handler : function() {
					admin_yhgl_removeFun();
				}
			}, '-', {
				text : '批量设置角色',
				iconCls : 'icon-edit',
				handler : function() {
					admin_yhgl_modifyRoleFun();
				}
			}, '-' ]
		});
	});
</script>


<div class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 130px; overflow: hidden;" align="center">
		<form id="admin_yhgl_searchForm">
			<table class="tableForm">
				<tr>
					<th style="width: 170px;">检索用户名称(可模糊查询)</th>
					<td><input name="name" style="width: 200px;" /></td>
				</tr>
				<tr>
					<th style="width: 170px;">学校名称</th>
					<td><input name="school" style="width: 200px;" /></td>
				</tr>
			</table>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_yhgl_searchFun();">过滤条件</a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_yhgl_cleanFun();">清空条件</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="menu_yhxx_datagrid" data-options="fit : true,border : false"></table>
	</div>
</div>
