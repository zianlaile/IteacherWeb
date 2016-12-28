<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ITeacher</title>
<jsp:include page="inc2.jsp"></jsp:include>					
</head>
<body class="easyui-layout">
	<div data-options="region:'north',href:'${ctx}/North'" style="height: 55px;overflow: hidden;"></div>

	<div data-options="region:'west',href:'${ctx}/West'" style="width: 200px;"></div>
		
	<div data-options="region:'center',border:'true',href:'${ctx}/Center'" style="padding:2px;overflow:hidden;background:#eee;"></div>

</body>
</html>