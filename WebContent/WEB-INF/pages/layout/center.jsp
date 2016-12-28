<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />



<script type="text/javascript">
	$(function() {
		$('#layout_center_tabs').tabs({
			fit : true,
			border : false,
			tools : [ {
				iconCls : 'fa fa-refresh',
				handler : function() {
					var index = $('#layout_center_tabs').tabs('getTabIndex', $('#layout_center_tabs').tabs('getSelected'));
					$('#layout_center_tabs').tabs('getTab', index).panel('refresh');
				}
			} ]
		});
	});

	function addTab(title, url) {
		var t = $('#layout_center_tabs');
		if (t.tabs('exists', title)) {
			t.tabs('select', title);
		} else {
			/* var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';  */
			t.tabs('add', {
				title : title,
				//content:content, 
				href : url,
				closable : true
			});
		}
	}
</script>


<div id="layout_center_tabs" class="easyui-tabs" data-options="fit:true,border:true">
	<div title="首页" data-options="href:'${ctx}/Porta'"></div>
</div>