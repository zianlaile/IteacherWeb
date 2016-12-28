<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<script type="text/javascript">
	var datagrid;
	$(function() {
		$('#news_list_datagrid').datagrid({
			toolbar : [ {
				text : '添加新鲜事',
				iconCls : 'fa fa-plus',
				handler : function() {
					news_list_addFun();
				}
			}, '-', /* {
										text : '编辑新鲜事',
										iconCls : 'fa fa-edit',
										handler : function() {
											news_list_editFun();
										}
									}, '-',  */{
				text : '删除新鲜事',
				iconCls : 'fa fa-trash-o',
				handler : function() {
					news_list_removeFun();
				}
			} ]
		});
	});

	function news_list_addFun() {
		$('#win').window({
			title : '添加新鲜事',
			height : 660,
			width : 790
		});
		$('#win').window('center');
		$('#win').window('open');
		$('#win').window('refresh', '${ctx}/NewsAdd');
	};

	function news_list_removeFun() {
		var row = $('#news_list_datagrid').datagrid('getSelected');
		if (row) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {

					$.ajax({
						url : '${ctx}/news/delete',
						data : {
							newsid : row.newsid
						},
						success : function(result) {
							if (result.success) {
								$('#news_list_datagrid').datagrid('reload');
								$('#news_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								$.messager.show({
									title : '提示',
									msg : result.msg,
								});

							} else {
								$.messager.alert('失败提示', '删除失败', 'warning');
							}
						}
					});
				}
			});
		} else {
			$.messager.alert('提示', '请选择要删除的记录!', 'warning')
		}
	}
	/* 	function news_list_addFun() {
	 $('#news_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
	 $('<div/>').dialog({
	 href : '${ctx}/NewsAdd',
	 width : 750,
	 height : 600, 
	
	 modal : true,
	 title : '添加新鲜事',
	 buttons : [ {
	 text : '保存',
	 iconCls : 'fa fa-save', 
	 handler : function() {
	 var d = $(this).closest('.window-body');
	 $('#news_list_datagrid').form('submit', {
	 url : '${ctx}/news/create',
	 success : function(result) {
	 try {
	 var r = $.parseJSON(result);
	 if (r.success) {
	 $('#news_list_datagrid').datagrid('insertRow', {
	 index : 0,
	 row : r.obj
	 });
	 d.dialog('destroy');
	 }
	 $.messager.show({
	 title : '提示',
	 msg : r.msg
	 });
	 } catch (e) {
	 $.messager.alert('提示', result);
	 }
	 } 
	 });
	 }
	 } ],  
	 onClose : function() {
	 $(this).dialog('destroy');
	 }
	 });
	 } */

	//明细列显示 
	function newsdetailFormatter(newsid) {
		return "<font color='red'>查看</font>";
	};
	
	function onNewsCellClick(index, field, value){
		if(field == 'newsid'){								
			$('#win').window({title: '新鲜事详情',width:738});
			$('#win').window('center');
			$('#win').window('open');
		    $('#win').window('refresh','${ctx}/news/show?newsid='+value);  
		}	
	};

	//日期格式变换dateFormatter
	function formatterdate(val, row) {
		if (val != null) {
			var date = new Date(val);
			return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
		}
	}
</script>





<table class="easyui-datagrid" id="news_list_datagrid" data-options="
			singleSelect : true,
			rownumbers : true,
			fitColumns : true,
		    pagination : true,
		    idField : 'newsid',
			fit : true,
			fitColumns : true,
			<%-- url : '${ctx}/test/news_list.json', --%>
		    url : '${ctx}/news/list', 
			method:'get',
			onClickCell: onNewsCellClick
			">
	<thead>
		<tr>
			<th data-options="field:'title',width:200">标题</th>
			<th data-options="field:'username',width:100">发布人</th> 
			<th data-options="field:'addtime',formatter:formatterdate,width:150">添加时间</th> 
			<th data-options="field:'tag',width:200">标签</th>
			<th data-options="field:'recipient',width:150">接收人</th>
			<th data-options="field:'newsid',width:80,formatter:newsdetailFormatter">详情</th> 
		</tr>
	</thead>
</table>
<div id="win" class="easyui-window" title="" style="width: 750px;" data-options="
		modal:true,
		closed:true
	"></div>
