<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!-- <script type="text/javascript" charset="utf-8">
	function logout() {
		$.ajax({
			type : "post",
			url : "${ctx}/user/checkLogoutUser",
			cache : false,
			success : function() {
				window.location = '${ctx}/login';
			}
		});
	}
</script> -->

<script type="text/javascript" charset="utf-8">
	function logout() {
		$.messager.confirm('确认', '您确定要注销？', function(r) {
			if (r) {
				$.getJSON('${ctx}/user/checkLogoutUser', function(result) {
					location.replace('${ctx}/login');
				});
			}
		});
	}
</script>

<a class="navbar-brand" href="${ctx}/Index">Hello, World.</a>

<div style="position: absolute; right: 30px; bottom: 5px;">
	<a href="javascript:void(0);" class="btn btn-default" id="change-password"> <i class="fa  fa-key"></i> 修改密码
	</a> <a href="javascript:void(0);" onclick="logout()" class="btn btn-default"> <i class="fa fa-sign-out"></i>注销
	</a>
</div>