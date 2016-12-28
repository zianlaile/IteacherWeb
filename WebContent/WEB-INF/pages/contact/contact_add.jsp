<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
	/* var datagrid; */
	 $(function() {
		$('#contact_add_datagrid').datagrid({
			toolbar: '#tb'
		}); 
	 });
	 
	 function Load() {  
		    $("<div class=\"datagrid-mask\"></div>").css({ "z-index" : "10000", display: "block", width: "100%", height: $(window).height()  }).appendTo("body");  
		    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理中，请稍候。。。").appendTo("body").css({"z-index" : "10000",display: "block", left: ($(document.body).outerWidth(true) - 190) / 2, top: ($(window).height() - 45) / 2,height:"50px" });  
		}; 
	
	 	$().ready(function() {
	 		$("#fileInput").uploadify({
				'buttonText' : '请选择Excel文件',
				'formData':{'school':'$("input[name=school]").val()','campus':'$("input[name=campus]").val()'},
				'height' : 30,  
				'swf' : '${ctx}/assets/uploadify/uploadify.swf', 
				'uploader' : "${ctx}/contact/loadExcel;jsessionid=<%=session.getId()%>",
				'width' : 120,
				'auto' : false,
				'fileObjName' : 'fileInput', //和input的name属性值保持一致就好
				'multi': false,//是否支持多文件上传
				'fileTypeExts' : '*.xls',
				/* 'onSelect' : function(file) {
					$('#selected-file').html(file.name);  
				}, */
				onUploadStart: function(file){
					 $("#fileInput").uploadify("settings", "formData",{'campus':$("input[name=campus]").val(),
						 'school':$("input[name=school]").val()});
					 
					 $("#filename").val(file.name); 
					 $.messager.progress({
						 msg: '正在上传' + file.name
					 });
				 },
				 onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal){ 
					/*  console.info("file:"+file+" bytesUploaded:"+bytesUploaded+" bytesTotal:"+bytesTotal+
							 " totalBytesUploaded:"+totalBytesUploaded+" totalBytesTotal:"+totalBytesTotal); */ 
					 var rate = 100*totalBytesUploaded/totalBytesTotal;
					 $.messager.progress('bar').progressbar("setValue", rate); 
				 },
				onUploadSuccess : function(file, data, response) {
					console.info(data);
					if(data=="1"){
						$.messager.progress('close');
						 $('#contact_add_dialog').window('close'); 
						$('#contact_add_datagrid').datagrid('reload');
						$.messager.show({
							title : '提示',
							msg : file.name + ' 上传成功！ ',
						});
					}else{
						$.messager.alert("提示", "操作失败！","error");
					}
					
				}
			});
	 	});	
	
	 function file_chooseFun(){
		 $('#contact_add_addForm').form('clear');
		 
		 $('#contact_add_dialog').window('open');
		 /* $('#contact_add_dialog').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections'); */
	 }
	 
	 function file_importFun(){
		 console.info("全部导入");
		 var data=$('#contact_add_datagrid').datagrid('getData');
		 var data_flag = $('#contact_add_datagrid').datagrid('getRows');
		 if(data.total<=0){
				$.messager.alert('系统提示', "无临时导入数据！", 'error');
			}else if(data_flag[0]['notes'] != null){
				$.messager.alert("系统提示", "请修改上传表格中有误的信息！","error");
			}else{
				
				 $.messager.progress({
					 msg: '正在导入'
				 });
				
				 console.info(data);
			     $.ajax({ 
			     	type : "post", 
			     	url  : "${ctx}/contact/importContact", 
			     	contentType: "application/json; charset=utf-8",
			     	cache : false, 
			     	dataType: "json",
			     	success : function(data){  
			        	if(data.success){ 
			        		$('#contact_add_datagrid').datagrid('reload');
			        		$.messager.progress('close');
			        		$.messager.show({
								title : '提示',
								msg : '保存成功！ ',
							});
			             }else{ 
			            	 $.messager.alert("提示", "保存失败！","error"); 
			                	//alert(data.info); 
			              }  
			            }, 
			            error : function(data){  
			                alert("系统错误");  
			            }
			      });
			}
 
		 
	 }
	 
	 function file_cancelFun(){
		 console.info("取消导入");
		 var data=$('#contact_add_datagrid').datagrid('getData');
		 if(data.total<=0){
				$.messager.alert('系统提示', "无临时导入数据！", 'error');
			}else{
				$.ajax({
				     type: "post",
				     url: "${ctx}/contact/clearContact", 
				     contentType: "application/json; charset=utf-8",
				     dataType: "json",
				     beforeSend:function() {
				    	 $.messager.progress({
							 msg: '正在取消'
						 });
					 },
				     success: function(data) {
				    	 if(data.success){ 
				        		$('#contact_add_datagrid').datagrid('reload');
				        		$.messager.progress('close');
				        		$.messager.show({
									title : '提示',
									msg : '取消成功！ ',
								});
				             }else{ 
				            	 $.messager.alert("提示", "取消失败！","error"); 
				              }
				     },
				     error : function(data){  
			                alert("系统错误");  
			            }
				 });
			}
	 }
	 /* function cellStyler(value,row,index){
			if (value != null){
				return 'color:red;';
			}
		} */
</script>

 <div id="tb">
	<a href="${ctx}/contact/download" class="easyui-linkbutton" data-options="text:'下载模板',iconCls:'fa fa-download',plain:true"></a>
	<a onclick="file_chooseFun()" class="easyui-linkbutton" data-options="text:'选择文件',iconCls:'fa fa-folder-o',plain:true"></a>
	<a onclick="file_importFun()" class="easyui-linkbutton" data-options="text:'确认导入',iconCls:'fa fa-upload',plain:true"></a>
	<a onclick="file_cancelFun()" class="easyui-linkbutton" data-options="text:'取消导入',iconCls:'fa fa-trash-o',plain:true"></a>
</div> 
<table class="easyui-datagrid" id="contact_add_datagrid" data-options="
			singleSelect : true,
			rownumbers : true,
			fitColumns : true,
		    <!-- pagination : true, -->
			fit : true,
			url : '${ctx}/contact/showTemp',
			method:'get',
			rowStyler: function(index,row){
				if (row.notes != null){
					return 'color:red;';
				}
			}
			">
			
		<thead>
			<tr>
				<!-- <th data-options="field:'contactid',width:80,align:'left'">id</th> -->
				<th data-options="field:'school',width:200,align:'left'">学校</th>
				<th data-options="field:'campus',width:200,align:'left'">校区</th>
				<th data-options="field:'classify',width:250,align:'left'">分类</th>
				<th data-options="field:'department',width:250,align:'left'">学校学院部门</th>
				<th data-options="field:'office',width:250,align:'left'">办公室</th>
				<th data-options="field:'person',width:250,align:'left'">联系人</th>
				<th data-options="field:'phone',width:250,align:'left'">联系电话</th>
				<th data-options="field:'notes',width:250,align:'left'">备注</th>
			</tr>
		</thead>		
</table>

<div id="contact_add_dialog" class="easyui-dialog" title="导入Excel" style="width:350px;height:220px;" align="center" data-options="
		modal:true,
		closed:true,
		buttons:[{
				text : '确定',
				iconCls : 'fa fa-save',
				handler : function() {
					$('#fileInput').uploadify('upload', '*'); 
					
					 
					<!-- $('contact_add_dialog').window('close'); -->
					<!-- $('#selected-file').html(''); -->
					<!-- $('#contact_add_datagrid').datagrid('reload');   -->
				}
				}]">
	
	<form class="form-horizontal" id="contact_add_addForm" method="post" style="margin-top: 4px">
		<div class="col-sm-11">
			<div class="row">
				<div class="form-group">
					<label for="school " class="col-sm-4 control-label">学校</label>
					<div class="col-sm-4">
						<input class="form-control easyui-combobox" name="school" id="school" data-options="
							url:'${ctx}/contact/chooseSchool', 
							method:'post',
							valueField:'schoolname',
							textField:'schoolname',
							panelHeight:'auto',
							onSelect: function(re){
   							var url = '${ctx}/contact/chooseCampusAdd?schoolid='+re.id;
    						$('#campus_add').combobox('reload', url);
    						}">
					</div>
				</div>
				<div class="form-group">
					<label for="campus" class="col-sm-4 control-label">校区</label>
					<div class="col-sm-4">
						<input class="form-control easyui-combobox" name="campus" id="campus_add" data-options="
							valueField:'campusname',
							textField:'campusname',
							panelHeight:'auto' ">
					</div>
				</div>
				<div class="form-group">
					<label for="file" class="col-sm-4 control-label">浏览</label>
					<div class="col-sm-4" id="picturediv">
						 <input type="file" name="fileInput" id="fileInput" /> 
					</div>
				</div>
			</div>
		</div>
	</form>	
</div>
