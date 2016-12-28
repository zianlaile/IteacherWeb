<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script type="text/javascript" charset="utf-8">
	
	var editRow = undefined;
	
	
//行编辑，增加	
function contact_list_add(){
	if (editRow != undefined) {
		$('#contact_list_datagrid').datagrid('endEdit', editRow);
	}
	//var rows = $('#contact_list_datagrid').datagrid('getRows').length-10;
	if (editRow == undefined){
		$('#contact_list_datagrid').datagrid('insertRow',{
	 		index : 0,
	 		row : {}
		});
		$('#contact_list_datagrid').datagrid('beginEdit',0); 
		editRow = 0;
	}
 	
	//var rows = $('#contact_list_datagrid').datagrid('getRows');
	//console.info(rows.length);
}	


//行编辑，保存
function contact_list_save(){
	if (editRow != undefined) {
		$('#contact_list_datagrid').datagrid('endEdit', editRow);
	}
}

//编辑结束后，将数据发送到后台
function onAfterEdit(rowIndex, rowData, changes){
	console.info(rowData);
	var inserted = $('#contact_list_datagrid').datagrid('getChanges', 'inserted');
	var updated = $('#contact_list_datagrid').datagrid('getChanges', 'updated');
	
	if(inserted.length<1 && updated.length<1){
		editRow = undefined;
		$('#contact_list_datagrid').datagrid('unselectAll');
		return;
	}
	
	var url = '';
	
	if(inserted.length > 0){
		url = '${ctx}/contact/listInsert';
	}
	if (updated.length > 0) {
		url = '${ctx}/contact/listUpdate';
	}
	$.ajax({
		type: "post",
		url : url,
		contentType: "application/json; charset=utf-8",
	    dataType: "json",
		data : JSON.stringify(rowData),
		success : function(r){
			if(r.success){
				$('#contact_list_datagrid').datagrid('acceptChanges');
				$.messager.show({
					msg : r.msg,
					title : '成功'
				});
				editRow = undefined;
				$('#contact_list_datagrid').datagrid('unselectAll');
			}else{
				$('#contact_list_datagrid').datagrid('beginEdit',editRow);
				$.messager.alert('错误',r.msg,'error');
			}
			$('#contact_list_datagrid').datagrid('unselectAll');
		} 
	});
	
}

//取消编辑
function contact_list_cancel(){
	editRow = undefined;
	$('#contact_list_datagrid').datagrid('rejectChanges');
	$('#contact_list_datagrid').datagrid('uncheckAll');
	
}

//双击开启编辑状态
function onDblClickRow(rowIndex, rowData){
	if (editRow != undefined) {
		$('#contact_list_datagrid').datagrid('endEdit', editRow);
	}  
	if (editRow == undefined){
		$('#contact_list_datagrid').datagrid('beginEdit',rowIndex); 
		editRow = rowIndex;
		$('#contact_list_datagrid').datagrid('unselectAll'); 
	}
}

//修改
function contact_list_modify(){
	var rows = $('#contact_list_datagrid').datagrid('getSelections');
	if(rows.length == 1){
		if (editRow != undefined) {
			$('#contact_list_datagrid').datagrid('endEdit', editRow);
		}  
		if (editRow == undefined){
			editRow = $('#contact_list_datagrid').datagrid('getRowIndex', rows[0]);
			$('#contact_list_datagrid').datagrid('beginEdit',editRow); 
			$('#contact_list_datagrid').datagrid('unselectAll'); 
		}
	}else {
		$.messager.alert("提示", "请选择一项进行修改！","info"); 
	}
}

//删除
function contact_list_delete(){
	if (editRow != undefined) {
		$('#contact_list_datagrid').datagrid('endEdit', editRow);
		return;
	}
	var rows = $('#contact_list_datagrid').datagrid('getSelections');
	var ids = [];
	if (rows.length > 0) {
		$.messager.confirm('请确认', '您要删除当前所选项目？', function(r) {
			if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].contactid);
				 }
				 console.info(ids.join(','));
				 $.ajax({
					url : '${ctx}/contact/listDelete',
					data : {
						ids : ids.join(',')
					},
					dataType : 'json',
					success : function(response) {
						if(response.success){
							$('#contact_list_datagrid').datagrid('load');
							$('#contact_list_datagrid').datagrid('unselectAll');
							$.messager.show({
								title : '提示',
								msg : '删除成功！'
							});
						}else {
							$.messager.alert('失败提示', '删除失败', 'warning');
						}
					}
				}); 
			}
		});
	} else {
		$.messager.alert('提示', '请选择要删除的记录！', 'info');
	}
}

//查询的查询按钮
function contact_list_searchFun() {
	$('#contact_list_datagrid').datagrid('load', {
		'school' : $("input[name=school]").val(),
		'campus' : $("input[name=campus]").val(),
		'classify' : $("input[name=classify]").val(),
		'department' : $("input[name=department]").val(),
		'person' : $("input[name=person]").val(),
		'phone' :  $("input[name=phone]").val()
	});
	/* var rows = $('#contact_list_datagrid').datagrid('getRows');
	   console.info(rows[0]['phone']); */
}
//查询的清空按钮
function contact_list_cleanFun() {
	$('#contact_list_searchForm').form('clear');
	$('#contact_list_datagrid').datagrid('load', {});
}

function rows_one(){
	var rows = $('#contact_list_datagrid').datagrid('getRows');
	console.info(rows[0]['school']);
}
</script>

<div class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'查询条件',border:false,selected:false" style="height: 100px; overflow: hidden;" align="right">
		<form method="post" id="contact_list_searchForm" style="margin-top: 8px">
			<div class="container">
				<div class="row">
				
		 			<div class="col-sm-3">
						<div class="form-group">
							<label for="contact.school" class="col-sm-4 control-label">学校</label>
							<div class="col-sm-7">
								<input class="form-control easyui-combobox" name="school" id="school" data-options="
									url:'${ctx}/contact/chooseSchool', 
									method:'post',
									valueField:'schoolname',
									textField:'schoolname',
									panelHeight:'auto',
									onSelect: function(rec){
		   							var url = '${ctx}/contact/chooseCampus?schoolid='+rec.id;
		    						$('#campus').combobox('reload', url);
		    						}">
							</div>
						</div>
					</div>
		
					<div class="col-sm-3">
						<div class="form-group">
							<label for="campus" class="col-sm-4 control-label">校区</label>
							<div class="col-sm-7">
								<input class="form-control easyui-combobox" name="campus" id="campus" data-options="
									valueField:'campusname',
									textField:'campusname',
									panelHeight:'auto' ">
							</div>
						</div>
					</div>
		
					<div class="col-sm-3">
						<div class="form-group">
							<label for="classify" class="col-sm-4 control-label">分类</label>
							<div class="col-sm-7">
								<select class="form-control easyui-combobox" name="classify" id="classify" data-options="
									multiple:false,
									panelHeight:'auto' ">
										<option  value=""></option>
										<option value="校级部门">校级部门</option>
										<option value="学院级部门">学院级部门</option>
								</select>
							</div>
						</div>
					</div> 
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="department" class="col-sm-4 control-label">部门</label>
							<div class="col-sm-7">
								<input class="form-control easyui-combobox" name="department" id="department" data-options="
									url:'${ctx}/contact/chooseDepartment', 
									valueField:'department',
									textField:'department',
									panelHeight:180 ">
							</div>
						</div>
					</div> 
				</div>
				
				<div class="row">
		 			<div class="col-sm-3">
						<div class="form-group">
							<label for="person" class="col-sm-4 control-label">联系人</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="person" id="person" style="width: 153px; height: 24px">
							</div>
						</div>
					</div>
		
					<div class="col-sm-3">
						<div class="form-group">
							<label for="phone" class="col-sm-4 control-label">电话</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="phone" id="phone" style="width: 153px; height: 24px">
							</div>
						</div>
					</div>
					
					<div class="col-sm-6">
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa fa-search',plain:true" onclick="contact_list_searchFun();">查询</a>
						 &nbsp;
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa fa-remove ',plain:true" onclick="contact_list_cleanFun();">清空</a>
						 &nbsp;&nbsp;
					</div>
					
				</div>
			</div>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table class="easyui-datagrid" id="contact_list_datagrid" data-options="
					rownumbers : true, 
					fitColumns : true,
				    pagination : true,
					fit : true,
					fitColumns : true,
					url : '${ctx}/contact/showList',
					method:'post',
					toolbar : '#contact_tb',
					onAfterEdit : onAfterEdit,
					onDblClickRow : onDblClickRow
					">
					
				<thead>
					<tr>
						<th data-options="field:'contactid',width:80,align:'left',checkbox:true">id</th>
						<th data-options="field:'school',width:200,align:'left',editor:{
							type : 'combobox',
							options : {
								   url : '${ctx}/contact/chooseSchool',
								   method:'get',
								   valueField:'schoolname',
								   textField:'schoolname',
								   panelHeight:'auto',
								   required : true,
								   onSelect: function(rec){
		                           var name = $('#contact_list_datagrid').datagrid('getEditor', {
		                           		index : 0,
		                           		field : 'campus' 
		                           });
		   						   var url = '${ctx}/contact/chooseCampus?schoolid='+rec.id;
		    					   $(name.target).combobox('reload', url);
		    					   $('#contact_list_datagrid').datagrid('unselectAll'); 
		    					   }
		   					 }	
						}
						">学校</th>
						<th data-options="field:'campus',width:200,align:'left',editor:{
							type : 'combobox',
							options : {
								required : true,
								valueField:'campusname',
								textField:'campusname',
								panelHeight:'auto'
							}
						}">校区</th>
						<th data-options="field:'classify',width:250,align:'left',editor:{
							type : 'combobox',
							options : {
								required : true,
								panelHeight:'auto',
								data:[{
									value:'校级部门',
									text:'校级部门'
								},{
									value:'学院级部门',
									text:'学院级部门'
								}]
							}
						}">分类</th>
						<th data-options="field:'department',width:250,align:'left',editor:{type : 'validatebox',
							options : {required : true}}">学校学院部门</th>
						<th data-options="field:'office',width:250,align:'left',editor:{type : 'validatebox',
							options : {required : true}}">办公室</th>
						<th data-options="field:'person',width:250,align:'left',editor:{type : 'validatebox',
							options : {required : true}}">联系人</th>
						<th data-options="field:'phone',width:250,align:'left',editor:{type : 'validatebox',
							options : {required : true}}">联系电话</th>
					</tr>
				</thead>	
		</table>
	</div>	
</div>	

<div id="contact_tb" style="padding:5px;height:auto">
		<div>
			<a onclick="contact_list_add()" class="easyui-linkbutton" data-options="iconCls:'fa fa-plus ',plain:true">增加</a>
			<a onclick="contact_list_modify()" class="easyui-linkbutton" data-options="iconCls:'fa fa-edit ',plain:true">修改</a>
			<a onclick="contact_list_delete()" class="easyui-linkbutton" data-options="iconCls:'fa fa-trash-o',plain:true">删除</a>
			<a onclick="contact_list_save()" class="easyui-linkbutton" data-options="iconCls:'fa fa-save',plain:true">保存</a>
			<a onclick="contact_list_cancel()" class="easyui-linkbutton" data-options="iconCls:'fa fa-reply-all',plain:true">取消编辑</a>
			<!-- <input type="text" id="" value="">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'fa fa-search'">查询</a> -->
		</div>
</div>