<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script type="text/javascript" charset="utf-8">
	
	var editRow = undefined;

	
function changeEditorAddRow() {/*添加行时，改变editor，学校和校区可编辑*/
	$('#school_list_datagrid').datagrid('addEditor', [ {
		field : 'schoolname',
		editor : {
			type : 'validatebox',
			options : {
				editable : true,
				required : true
			}
		}
	}, {
		field : 'campusname',
		editor : {
			type : 'validatebox',
			options : {
				editable : true,
				required : true
			}
		}
	} ]);
}
function changeEditorEditRow() {/*编辑行时，改变editor，学校和校区不可编辑*/
	$('#school_list_datagrid').datagrid('removeEditor', [ 'schoolname', 'campusname' ]);
}
	
	
//行编辑，增加	
function school_list_add(){
	if (editRow != undefined) {
		$('#school_list_datagrid').datagrid('endEdit', editRow);
	}
	if (editRow == undefined){
		$('#school_list_datagrid').datagrid('unselectAll');
		changeEditorAddRow();/*改变editor*/
		$('#school_list_datagrid').datagrid('insertRow',{
	 		index : 0,
	 		row : {}
		});
		$('#school_list_datagrid').datagrid('beginEdit',0); 
		editRow = 0;
	}
 }	


//行编辑，保存
function school_list_save(){
	if (editRow != undefined) {
		$('#school_list_datagrid').datagrid('endEdit', editRow);
	}
}

//编辑结束后，将数据发送到后台
function onAfterEdit(rowIndex, rowData, changes){
	console.info(rowData);
	var inserted = $('#school_list_datagrid').datagrid('getChanges', 'inserted');
	var updated = $('#school_list_datagrid').datagrid('getChanges', 'updated');
	
	if(inserted.length<1 && updated.length<1){
		editRow = undefined;
		$('#school_list_datagrid').datagrid('unselectAll');
		return;
	}
	
	var url = '';
	
	if(inserted.length > 0){
		url = '${ctx}/schoolCampus/listInsert';
	}
	if (updated.length > 0) {
		url = '${ctx}/schoolCampus/listUpdate';
	}
	$.ajax({
		type: "post",
		url : url,
		contentType: "application/json; charset=utf-8",
	    dataType: "json",
		data : JSON.stringify(rowData),
		success : function(r){
			if(r.success){
				$('#school_list_datagrid').datagrid('acceptChanges');
				$.messager.show({
					msg : r.msg,
					title : '成功'
				});
				editRow = undefined;
				$('#school_list_datagrid').datagrid('unselectAll');
			}else{
				$('#school_list_datagrid').datagrid('beginEdit',editRow);
				$.messager.alert('错误',r.msg,'error');
			}
			$('#school_list_datagrid').datagrid('unselectAll');
		} 
	});
	
}

//取消编辑
function school_list_cancel(){
	editRow = undefined;
	$('#school_list_datagrid').datagrid('rejectChanges');
	$('#school_list_datagrid').datagrid('uncheckAll');
	
}

//双击开启编辑状态
function onDblClickRow(rowIndex, rowData){
	if (editRow != undefined) {
		$('#school_list_datagrid').datagrid('endEdit', editRow);
	}  
	if (editRow == undefined){
		changeEditorEditRow();/*改变editor*/
		$('#school_list_datagrid').datagrid('beginEdit',rowIndex); 
		editRow = rowIndex;
		$('#school_list_datagrid').datagrid('unselectAll'); 
	}
}

//修改编辑
function school_list_modify(){
	var rows = $('#school_list_datagrid').datagrid('getSelections');
	if(rows.length == 1){
		if (editRow != undefined) {
			$('#school_list_datagrid').datagrid('endEdit', editRow);
		}  
		if (editRow == undefined){
			changeEditorEditRow();/*改变editor*/
			editRow = $('#school_list_datagrid').datagrid('getRowIndex', rows[0]);
			$('#school_list_datagrid').datagrid('beginEdit',editRow); 
			$('#school_list_datagrid').datagrid('unselectAll'); 
		}
	}else {
		$.messager.alert("提示", "请选择一项进行修改！","info"); 
	}
}

//删除
function school_list_delete(){
	if (editRow != undefined) {
		$('#school_list_datagrid').datagrid('endEdit', editRow);
		return;
	}
	var rows = $('#school_list_datagrid').datagrid('getSelections');
	var ids = [];
	var schoolids = [];
	if (rows.length > 0) {
		$.messager.confirm('请确认', '您要删除当前所选项目？', function(r) {
			if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
					schoolids.push(rows[i].schoolid);
				 }
				 console.info(ids.join(','));
				 console.info(schoolids.join(','));
				 $.ajax({
					url : '${ctx}/schoolCampus/listDelete',
					data : {
						ids : ids.join(','),
						schoolids : schoolids.join(',')
					},
					dataType : 'json',
					success : function(response) {
						if(response.success){
							$('#school_list_datagrid').datagrid('load');
							$('#school_list_datagrid').datagrid('unselectAll');
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
function school_list_searchFun() {
	$('#school_list_datagrid').datagrid('load', {
		'schoolname' : $("input[name=schoolname]").val(),
		'campusname' : $("input[name=campusname]").val()
	});
}
//查询的清空按钮
function school_list_cleanFun() {
	$('#school_list_searchForm').form('clear');
	$('#school_list_datagrid').datagrid('load', {});
}
</script>

<div class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'查询条件',border:false,selected:false" style="height: 70px; overflow: hidden;" align="right">
		<form method="post" id="school_list_searchForm" style="margin-top: 8px">
			<div class="container">
				<div class="row">
				
		 			<div class="col-sm-3">
						<div class="form-group">
							<label for="schoolname" class="col-sm-4 control-label">学校</label>
							<div class="col-sm-7">
								<input class="form-control easyui-combobox" name="schoolname" id="schoolname" data-options="
									url:'${ctx}/contact/chooseSchool', 
									method:'post',
									valueField:'schoolname',
									textField:'schoolname',
									panelHeight:'auto',
									onSelect: function(rec){
		   							var url = '${ctx}/contact/chooseCampus?schoolid='+rec.id;
		    						$('#campusname').combobox('reload', url);
		    						}">
							</div>
						</div>
					</div>
		
					<div class="col-sm-3">
						<div class="form-group">
							<label for="campusname" class="col-sm-4 control-label">校区</label>
							<div class="col-sm-7">
								<input class="form-control easyui-combobox" name="campusname" id="campusname" data-options="
									valueField:'campusname',
									textField:'campusname',
									panelHeight:'auto' ">
							</div>
						</div>
					</div>
					
					<div class="col-sm-6">
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa fa-search',plain:true" onclick="school_list_searchFun();">查询</a>
						 &nbsp;
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa fa-remove ',plain:true" onclick="school_list_cleanFun();">清空</a>
						 &nbsp;&nbsp;
					</div>
					
				</div>
			</div>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table class="easyui-datagrid" id="school_list_datagrid" data-options="
					rownumbers : true, 
					fitColumns : true,
				    pagination : true,
					fit : true,
					fitColumns : true,
					url : '${ctx}/schoolCampus/showList',
					method:'post',
					toolbar : '#school_tb',
					onAfterEdit : onAfterEdit,
					onDblClickRow : onDblClickRow
					">
					
				<thead>
					<tr>
						<th data-options="field:'id',width:80,align:'left',checkbox:true">id</th>
						<th data-options="field:'schoolname',width:250,align:'left',editor:{type : 'validatebox',
							options : {required : true}}">学校</th>
						<th data-options="field:'campusname',width:250,align:'left',editor:{type : 'validatebox',
							options : {required : true}}">校区</th>
						<th data-options="field:'weekbegindate',width:250,align:'left',editor:{type : 'validatebox',
							options : {required : true}}">开学日期</th>
						<th data-options="field:'coursebegintime',width:250,align:'left',editor:{type : 'validatebox',
							options : {required : true}}">第一节课时间</th>
					</tr>
				</thead>	
		</table>
	</div>	
</div>	

<div id="school_tb" style="padding:5px;height:auto">
		<div>
			<a onclick="school_list_add()" class="easyui-linkbutton" data-options="iconCls:'fa fa-plus ',plain:true">增加</a>
			<a onclick="school_list_modify()" class="easyui-linkbutton" data-options="iconCls:'fa fa-edit ',plain:true">修改</a>
			<a onclick="school_list_delete()" class="easyui-linkbutton" data-options="iconCls:'fa fa-trash-o',plain:true">删除</a>
			<a onclick="school_list_save()" class="easyui-linkbutton" data-options="iconCls:'fa fa-save',plain:true">保存</a>
			<a onclick="school_list_cancel()" class="easyui-linkbutton" data-options="iconCls:'fa fa-reply-all',plain:true">取消编辑</a>
		</div>
</div>