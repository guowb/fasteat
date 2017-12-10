<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemeEditForm" class="itemForm" method="post">
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
			<tr>
				<td>商店编号:</td>
				<td><input class="easyui-textbox" type="text" name="rid" data-options="required:true" style="width: 280px;"></input></td>
			</tr>
	        <tr>
	            <td>商店名称:</td>
	            <td><input class="easyui-textbox" type="text" name="rname" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商店描述:</td>
	            <td><input class="easyui-textbox" name="rdesc" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商店电话</td>
	            <td><input class="easyui-numberbox" type="text" name="rphone" data-options="min:1,max:9999999999999,precision:0,required:true" /></td>
	        </tr>
	        <tr>
	            <td>二维码:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="rcode" data-options="validType:'length[1,150]',disabled:true" />
	            </td>
	        </tr>


	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var itemEditEditor ;
	/*$(function(){
		//实例化编辑器
		itemEditEditor = TAOTAO.createEditor("#itemeEditForm [name=desc]");
	});*/
	
	function submitForm(){
		if(!$('#itemeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		/*$("#itemeEditForm [name=price]").val(eval($("#itemeEditForm [name=priceView]").val()) * 1000);
		itemEditEditor.sync();
		*/
		/*var paramJson = [];
		$("#itemeEditForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		paramJson = JSON.stringify(paramJson);
		*/
		/*$("#itemeEditForm [name=itemParams]").val(paramJson);*/
		
		$.post("/rest_update",$("#itemeEditForm").serialize(), function(){
		    alert("修改完成");
		    window.location.href="http://120.78.184.134:8080/rest_goplat";
			/*if(data.status == 200){
				$.messager.alert('提示','修改商品成功!','info',function(){
					$("#itemEditWindow").window('close');
					$("#itemList").datagrid("reload");
				});
			}*/
		});
	}
</script>
