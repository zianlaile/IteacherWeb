<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<script type="text/javascript">
	// 自定义grid显示

	var cardview = $.extend({}, $.fn.datagrid.defaults.view, {
		renderRow : function(target, fields, frozen, rowIndex, rowData) {
			var cc = [];
			cc.push('<td colspan=' + fields.length + ' style="padding:10px 10px;border:0;">');
			if (!frozen) {
				//var img = rowData['picid'];
				var i = rowData['id'];
				var img = i+'.jpg';
				cc.push('<img src="../pic/' + img + '" style="width:150px;float:left">');
				cc.push('<div style="float:left;margin-left:2px;">');
				cc.push('<p>id：' + rowData['id'] + '</p>' + '</p>');
				cc.push('<p>busid：' + rowData['busid'] + '</p>' + '</p>');
				cc.push('<p>comment：' + rowData['comment'] + '</p>' + '</p>');
				cc.push('<p>state：' + rowData['state'] + '</p>' + '</p>');
				cc.push('</div>');
				cc.push('<div style="float:left;margin-left:30px;">');
				cc.push('<p>点赞数：：' + rowData['agree_num'] + '</p>' + '</p>');
				cc.push('<p>用户评论：' + rowData[''] + '</p>' + '</p>');
				cc.push('</div>');
			}
			cc.push('</td>');
			return cc.join('');
		}
	});
	$(document).ready(function() {
		$('#menu_xhsh_datagrid').datagrid({
			view : cardview,
			toolbar : [ {
				text : '保留',
				iconCls : 'fa fa-save fa-fw',
				handler : function() {
					menu_xcsh_reserveFun();
				}
			}, '-', {
				text : '删除',
				iconCls : 'fa fa-trash fa-fw',
				handler : function() {
					menu_xcsh_removeFun();
				}
			}, '-' ]
		});
	});

	function menu_xcsh_reserveFun() {
		var rows = $('#menu_xhsh_datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要 保留这张图片？', function(r) {
				if (r) {

				}
			});

		} else {
			$.messager.confirm('确认', '请选择要操作的图片？')
		}
	}
</script>





<table id="menu_xhsh_datagrid" data-options="
			singleSelect : true,
			fitColumns : true,
		    pagination : true,
			fit : true,
			url : '${ctx}/bus/reportAndOthers/list',
			method:'get'">
	<thead>
		<tr>
			<th data-options="field:'id',width:10">id</th>
			<th data-options="field:'busid',width:10">busid</th>
			<th data-options="field:'comment',width:30">comment</th>
			<th data-options="field:'state',width:30">state</th>
			<th data-options="field:'picid',width:10">picid</th>
			<th data-options="field:'picid',width:30">agree_num</th>
			<th data-options="field:'picture',width:30">picture</th>
		</tr>
	</thead>
</table>


