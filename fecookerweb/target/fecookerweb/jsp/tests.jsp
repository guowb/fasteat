<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.5/themes/bootstrap/easyui.css"/>
    <!-- 图标样式 -->
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.5/themes/icon.css"/>

    <script type="application/javascript" src="/js/jquery-easyui-1.5/jquery.min.js" ></script>
    <script type="application/javascript" src="/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <script type="application/javascript" src="/js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>

</head>
</head>
<body>

<table id="dg" title="Custom DataGrid Pager" style="width:700px;height:250px"
       data-options="rownumbers:true,singleSelect:true,pagination:true,url:'/order/datagrid_data1.json',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'id',width:45">订单号</th>
        <th data-options="field:'dnum',width:45">桌号</th>
        <th data-options="field:'content',width:80,align:'right'">备注</th>
        <th data-options="field:'phone',width:80,align:'right'">手机号</th>
        <th data-options="field:'price',width:50,align:'right'">价格</th>
        <th data-options="field:'createdate',width:240" >订单时间</th>
        <th data-options="field:'   ',align:'center'">详情</th>

    </tr>
    </thead>
</table>
</body>
<script type="text/javascript">

    $(function(){
        var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
        pager.pagination({
            buttons:[{
                iconCls:'icon-search',
                handler:function(){
                    alert('search');
                }
            },{
                iconCls:'icon-add',
                handler:function(){
                    alert('add');
                }
            },{
                iconCls:'icon-edit',
                handler:function(){
                    alert('edit');
                }
            }]
        });
    })
</script>


</html>
