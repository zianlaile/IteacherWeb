<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
	$(function() {

	});
</script>
<div class="easyui-accordion" data-options="fit:true,border:false">
	<%-- <div title="用户管理">
		<ul class="nav" id="side-menu">
			<li><a href="${ctx}/sessionIndex"><i class="fa fa-user fa-fw"></i> Session</a></li>
			<li><a href="${ctx}/AdminIndex"><i class="fa fa-file-text fa-fw"></i> 学校信息</a></li>
			<li><a href="${ctx}/sessionIndex"><i class="fa fa-comments-o fa-fw"></i> 老师信息</a></li>
			<li><a href="${ctx}/sessionIndex"><i class="fa fa-exclamation-triangle fa-fw"></i> 学生信息</a></li>
			<li><a href="${ctx}/sessionIndex"><i class="fa fa-picture-o fa-fw"></i> 课程信息</a></li>
			<li><a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">Blank Page</a></li>
					<li><a href="#">Blank Page</a></li>
				</ul>
			</li>
		</ul>
		<ul id="layout_west_tree"></ul>
	</div> --%>
	<div title="公告管理" data-options="selected:false">
		<ul class="nav" id="side-menu">
			<%-- <li><a onclick="addTab('添加联系人','${ctx}/AddContact')"><i class="fa fa-comments-o fa-fw"></i> 联系人</a></li> --%>
			<li><a onclick="addTab('新鲜事列表','${ctx}/NewsList')"><i class="fa fa-comments-o fa-fw"></i> 资讯发布</a></li>
			<%-- <li><a onclick="addTab('用户信息','${ctx}/Yhxx')"><i class="fa fa-comments-o fa-fw"></i> 用户信息</a></li>
			<li><a onclick="addTab('session信息','${ctx}/Sessionxx')"><i class="fa fa-comments-o fa-fw"></i> session信息</a></li>
			<li><a onclick="addTab('校车审核','${ctx}/Xcsh')"><i class="fa fa-comments-o fa-fw"></i> 校车审核</a></li> --%>
		</ul>
		<ul id="layout_west_xtgl"></ul>
	</div>
	
	<div title="联系人管理" data-options="selected:false">
		<ul class="nav" id="side-menu">
			<li><a onclick="addTab('添加联系人','${ctx}/ContactAdd')"><i class="fa fa-comments-o fa-fw"></i> 联系人导入</a></li>
			<li><a onclick="addTab('联系人列表','${ctx}/ContactList')"><i class="fa fa-comments-o fa-fw"></i> 联系人管理</a></li>
		</ul>
		<ul id="layout_west_lxr"></ul>
	</div>
	
	<div title="学校管理" data-options="selected:false">
		<ul class="nav" id="side-menu">
			<li><a onclick="addTab('学校列表','${ctx}/SchoolCourseList')"><i class="fa fa-comments-o fa-fw"></i> 学校管理</a></li>
		</ul>
		<ul id="layout_west_xxgl"></ul>
	</div>
	<div title="" data-options="selected:true" style="padding: 10px;"></div> 
</div>


