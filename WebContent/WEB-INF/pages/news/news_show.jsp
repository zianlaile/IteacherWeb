<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script>
	$().ready(function() {
		var editor = CKEDITOR.replace('content');
		editor.on('instanceReady', function(){
			$('#win').window('center');
		});
		//CKFinder.setupCKEditor(editor, ctx + '/assets/ckfinder', 'notice');
	});
</script> 

<form class="form-horizontal" style="margin-top: 20px; height: 500px; overflow-y: auto; overflow-x: hidden;">
<div class="col-sm-5">
		<div class="row">		
			<input type="text" class="form-control"  name="picture" id="picture" style="display:none">				
			<div class="form-group">
				<label for="type" class="col-sm-4 control-label">类型</label>
				<div class="col-sm-8">
					<input class="form-control easyui-combobox" name="type" id="type" style="width:230px;height:34px" data-options="
					editable:'false',
					panelHeight:'auto' " value="${news.type }" >
				</div>
			</div>
			<%-- <div class="form-group">
				<label for="school" class="col-sm-4 control-label">学校</label>
				<div class="col-sm-8">
					<input class="form-control easyui-combobox" name="school" id="school" style="width: 230px; height: 34px"  value="${news.school }" >
				</div>
			</div> --%>
			<div class="form-group">
				<label for="title" class="col-sm-4 control-label">标题</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="title" id="title" style="width:230px;height:34px" value="${news.title }">
				</div>
			</div>			
		</div>
	</div>
	<div class="col-sm-6">
		<div class="row">
			<div class="form-group">
				<label for="school_name" class="col-sm-4 control-label">接收人</label>
				<div class="col-sm-8">
					<input class="form-control easyui-combobox" name="recipient" id="recipient" style="width:230px;height:34px" data-options="
					multiple:true,
					editable:'false',
					panelHeight:'auto' " value="${news.recipient }" >
				</div>
			</div>
			<%-- <div class="form-group">
				<label for="college" class="col-sm-3 control-label">学院</label>
				<div class="col-sm-8">
					<input class="form-control easyui-combobox" name="college" id="college" style="width: 230px; height: 34px" data-options="
					editable:'false',
					panelHeight:'auto' " value="${news.college }" >
				</div>
			</div> --%>
			<div class="form-group">
				<label for="school_name" class="col-sm-4 control-label">标签</label>
				<div class="col-sm-8">
					<input class="form-control easyui-combobox" name="tag" id="tag" data-options="
					valueField:'tag',
					textField:'tag',
					multiple:true,
					panelHeight:'200',
					width:'230',
					height:'34'
			" value="${news.tag }" >
				</div>
			</div>

		</div>
	</div>
	<div class="col-sm-11">
		<div class="row">
			<div class="form-group">
				<label for="file" class="col-sm-2 control-label">标题图片</label>
				<div class="col-sm-4" id="picturediv">
					<img src="/IteacherWeb/upload/picture/news/${news.picture}" width=100 height=100/>
					<span id="selected-file"></span> 
				</div>
			</div>

			<div class="form-group">
				<label for="abstr" class="col-sm-2 control-label">摘要</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="abstr" id="abstr" value="${news.abstr}">
				</div>
			</div>

			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">正文</label>
				<div class="col-sm-10">
					<textarea name="content" class="form-control" rows="5" id="content" >${news.content }</textarea>
				</div>
			</div>

		</div>
	</div>

</form>
