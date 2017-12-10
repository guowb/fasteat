<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/19
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>菜品修改页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/page-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/prettify.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        code {
            padding: 0px 4px;
            color: #d14;
            background-color: #f7f7f9;
            border: 1px solid #e1e1e8;
        }
    </style>
</head>
<body>
<div class="container">
    <legend style="color: #0c147a"><b>添加菜品</b></legend>
    <form id="J_Form" class="form-horizontal span24 bui-form-horizontal bui-form bui-form-field-container" aria-disabled="false" method="post" action="/updateFood.html" aria-pressed="false">
        <input type="hidden" value="${map.food.fid}" name="fid">
        <div class="row" style="margin-top: 2px">
            <div class="control-group span8">
                <label class="control-label"><s>*</s>菜品名称：</label>
                <div class="controls">
                    <input name="fname" value="${map.food.fname}" type="text" data-rules="{required:true}" class="input-normal control-text bui-form-field" aria-disabled="false" aria-pressed="false">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label"><s>*</s>所属菜种：</label>
                <div class="controls">
                    <select data-rules="{required:true}" name="tid" class="input-normal bui-form-field-select bui-form-field" aria-disabled="false">
                        <option value="">请选择</option>
                        <option value="${map.food.type.tid}" selected>${map.food.type.tname}</option>
                        <c:forEach items="${map.typeList}" var="type">
                            <option value="${type.tid}">${type.tname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="control-group span15">
                <label class="control-label"><s>*</s>菜品价格：</label>
                <div class="controls">
                    <input name="fprice" value="${map.food.fprice}" type="number" data-rules="{required:true}" class="input-normal control-text bui-form-field" aria-disabled="false" aria-pressed="false">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="control-group span15">
                <label class="control-label"><s>*</s>菜品介绍：</label>
                <div class="controls control-row4">
                    <textarea name="fdesc"  class="input-large bui-form-field" data-tip="{text:'请填写菜品信息！'}" type="text" aria-disabled="false" aria-pressed="false">${map.food.fdesc}</textarea>
                    <div class="bui-form-tip bui-overlay bui-ext-position x-align-cl-cl" aria-disabled="false" style="visibility: visible; left: 140px; top: 160px;" aria-pressed="false"><span class=""></span><span class="tip-text">请填写菜品信息！</span></div></div>
            </div>
        </div>


        <div class="row form-actions actions-bar">
            <div class="span13 offset3 ">
                <button type="submit" class="button button-primary">保存</button>
                <button type="reset" class="button">重置</button>
            </div>
        </div>
        <div class="row">
            <div class="control-group span15">
                <label class="control-label"><s>*</s>菜品图片：</label>
                <div class="controls" style="width: 100px;height: 100px">
                    <img src="${map.food.fphoto}" alt="" width="100px" border="1px" height="100px">
                    <input name="fphoto" type="hidden" value="${map.food.fphoto}">
                </div>
            </div>
        </div>
    </form>
    <form id="P_form" method="post" action="/PhotoUpload.html" enctype="multipart/form-data">
        <input id="pt" type="file" name="photo" onchange="preview(this)"/>
        <input type="hidden" value="${map.food.fid}" name="fid">
        <button class="button button-primary" type="submit">提交</button>
    </form>
</div>

<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
    //    function preview(file)
    //    {
    //        var prevDiv = document.getElementById('preview');
    //        if (file.files && file.files[0])
    //        {
    //            var reader = new FileReader();
    //            reader.onload = function(evt){
    //                prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';
    //            }
    //            reader.readAsDataURL(file.files[0]);
    //        }
    //        else
    //        {
    //            prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
    //        }
    //    }
    function uploadp() {
        if ($("#pt").val()!=null) {
            $("#P_form").submit();
        }
    }
</script>
</body>
</html>

