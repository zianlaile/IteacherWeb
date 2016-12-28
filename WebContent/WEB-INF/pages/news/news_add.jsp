<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script>
	
 	$().ready(function() {
 		var editor = CKEDITOR.replace('content');
 	    $('#content').val(CKEDITOR.instances['content'].getData());
 		$("#file_upload").uploadify({
			'buttonText' : '请选择标题图片',
			'height' : 30,  
			'swf' : '${ctx}/assets/uploadify/uploadify.swf', 
			'uploader' : "${ctx}/news/addpic;jsessionid=<%=session.getId()%>",
			'width' : 120,
			//'auto' : true,
			'fileObjName' : 'file',
			'fileTypeExts': '*.jpg;*.jpeg;*.png',
			'sizeLimit':'100*100',
			'onSelect' : function(file) {
				if (file.size > 716800) {
					alert("你所选择的文件超过700K限制,请重新选择！");
				} else {
					$('#selected-file').html(file.name);
				}
			},
			onUploadSuccess : function(file, data, response) {
				console.info("file:"+file +", data:"+data + ", response:"+response); 
				if(data == 0){
					console.info("图片那么大传不上去啦！！！！");
					/* $.messager.alert("提示", "图片上传失败！","error"); */
				}else{
					$("input#picture").attr("value",data);
					var pic = data;
					$.messager.show({
						title : '提示',
						msg : file.name + ' 上传成功！ ',
					});
					submitForm();
				}
			}
		});
 	});	
 	function submitForm(){
		/* var editor = CKEDITOR.replace('content');
 	    $('#content').val(CKEDITOR.instances['content'].getData()); */
 	    
 	    
 	    $('#news_add_datagrid').form({
 	    	type : "post",
 			url : "${ctx}/news/create", 
			cache : false,
			onSubmit:function(){
				var formData = $("#news_add_datagrid").serialize();
				console.info(formData); 
	 	        return $(this).form('validate');
	 	    },
	 	   success : function(data) {
	 		    var data = eval('(' + data + ')');
				try {
					if (data.success) {
						$('#win').window('close');
						$('#news_list_datagrid').datagrid('insertRow',{
							index: 0,
							row : data.obj
						});
						$.messager.alert('系统提示', '添加成功', 'info', function() {
								 						
							/* $('#news_list_datagrid').datagrid('reload'); */
						});
					}
				} catch (e) {
					$.messager.alert('系统提示', '添加失败！！');
				}
			},
			error : function(data) {
				alert("系统错误");
			}
			
 	    })
 	}
</script>

<form class="form-horizontal" id="news_add_datagrid" style="margin-top: 20px; overflow-y: hidden; overflow-x: hidden;" method="post" enctype="multipart/form-data">
	<div class="col-sm-6">
		<div class="row">
			<input type="text" class="form-control" name="picture" id="picture" style="display: none">
			<div class="form-group">
				<label for="type" class="col-sm-4 control-label">类型</label>
				<div class="col-sm-8">
					<select class="form-control easyui-combobox" name="type" id="type" style="width: 230px; height: 34px" data-options="
					panelHeight:'auto' ">
						<option value="学术动态">学术动态</option>
						<option value="学院动态">学院动态</option>
						<option value="新鲜事">新鲜事</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="school" class="col-sm-4 control-label">学校</label>
				<div class="col-sm-8">
					<select class="form-control easyui-combobox" name="school" id="school" style="width: 230px; height: 34px" data-options="
							url:'${ctx}/contact/chooseSchool', 
							method:'post',
							valueField:'id',
							textField:'schoolname',
							panelHeight:'auto',
							onSelect: function(doc){
   							var url = '${ctx}/news/chooseCollege?schoolid='+doc.id
    						$('#college').combobox('reload', url);
    						}">
						
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-4 control-label">标题</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="title" id="title" required style="width: 230px; height: 34px">
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="row">
			<div class="form-group">
				<label for="recipient" class="col-sm-3 control-label">接收人</label>
				<div class="col-sm-8">
					<select class="form-control easyui-combobox" name="recipient" id="recipient" style="width: 230px; height: 34px" data-options="
					multiple:true,
					panelHeight:'auto' ">
						<option value="老师">老师</option>
						<option value="学生">学生</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="college" class="col-sm-3 control-label">学院</label>
				<div class="col-sm-8">
					<select class="form-control easyui-combobox" name="college" id="college" style="width: 230px; height: 34px" data-options="
						    valueField:'id',
							textField:'collegename',
							multiple:true,
							panelHeight:'auto'">
						
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="school_name" class="col-sm-3 control-label">标签</label>
				<div class="col-sm-8">
					<!-- <input type="text" class="form-control" name="tag" id="tag" required> -->
					<input class="form-control easyui-combobox" name="tag" id="tag" data-options="
						url:'${ctx}/news/chooseTag', 
						method:'post',
						valueField:'tag',
						textField:'tag',
						multiple:true, 
						panelHeight:'200',
						width:'230',
						height:'34' "> 
				</div>
			</div>
			<div class="form-group">
			<label class="col-sm-3 control-label"></label>
				<div class="col-sm-8">
					<p style="font-size: 10px; color: gray;">输入多个标签时，请用请用英文逗号隔开</p>
				</div>
			</div>
				<!-- <p style="font-size: 10px; color: gray;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入多个标签时，请用请用英文逗号隔开</p> -->
		</div>
	</div>
	<div class="col-sm-12">
		<div class="row">
			<div class="form-group">
				<label for="picture" class="col-sm-2 control-label">标题图片</label>
				<div class="col-sm-4" id="picturediv">
					<input type="file" name="fileName" id="file_upload" /> <span id="selected-file"></span>
					<!-- <input type="text" class="form-control" style="position:absolute;opacity:0;left:-15px;top:0px;" name="file_url" id="file_url"/> -->	
				</div>
			</div>
			<!-- <p style="font-size: 10px; color: gray;">标题图片大小不超过70k，尺寸满足100*100</p> -->

			<div class="form-group">
				<label for="abstr" class="col-sm-2 control-label">摘要</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="abstr" required id="abstr" placeholder="简明摘要30字以内">
				</div>
			</div>

			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">正文</label>
				<div class="col-sm-9">
					<textarea name="content" class="form-control" rows="5" id="content"></textarea>
				</div>
			</div>

		</div>
	</div>

	<div class="col-sm-12" align="center">
		<!-- <a type="submit" class="easyui-linkbutton" style="padding: 5px 0px; width: 10%;"> <span style="font-size: 14px;"> 提交</span>
		</a> -->
		<input type="submit" class="easyui-linkbutton" style="padding: 5px 0px; width: 10%;" value="提交"></input>
	</div>


</form>