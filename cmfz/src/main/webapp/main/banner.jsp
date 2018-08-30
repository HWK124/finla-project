<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {

        var toolbar = [{
            iconCls: 'icon-edit',
            text: "添加",
            handler: function () {
                $('#dg1').dialog({
                    title: '添加',
                    iconCls: 'icon-add',
                    width: 300,
                    height: 300,
                    buttons: [{
                        text: '提交',
                        iconCls: 'icon-ok',
                        handler: function () {
                            $('#ff').submit();
                        }
                    }]
                });
                $('#ff').form({
                    url: '${pageContext.request.contextPath}/banner/add',
                    onSubmit: function (param) {
                        return true;
                    },
                    success: function (data) {
                        //关闭dialog
                        $('#dg1').dialog('close');
                        // 刷新datagrid
                        $('#dg').datagrid('load');
                    }
                });
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-help',
            handler: function () {
                /*
                 * 删除数据
                 *
                 * */
                //获取id
                //发异步请求
                //刷新当前页面
                function del(index) {  //删除操作
                    $('#dg').datagrid('deleteRow', index);  //
                }
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-help',
            handler: function () {
                /*
                 *使当前选中行可编辑模式
                 * */
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {

                    var index = $("#dg").edatagrid("getRowIndex", row)
                    //当前行可编辑
                    $("#dg").edatagrid("editRow", index)

                } else {
                    alert("请先选中行")
                }


            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-help',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        }]

        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/banner/queryAll',
            //method: "get",
            updateUrl: '',
            columns: [[

                {field: 'id', title: '编号', width: 100},
                {field: 'title', title: '名称', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'description', title: '描述', width: 100},
                {field: 'createDate', title: '时间', width: 100},
                {
                    field: 'operation', title: '删除', width: 100,
                    formatter: function (value, row, index) {
                        //console.log(value)
                        console.log(row.id)
                        //console.log(index[0])
                        return '<a href="${pageContext.request.contextPath}/banner/delete?id=' + row.id + '" onclick="">删除</a>';

                    },
                    success: function (data) {
                        // 刷新datagrid
                        $('#dg').datagrid('load');
                    }
                }
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
    })
</script>

<table id="dg"></table>

<div id="dg1" style="padding:20px;display:none;">
    <form id="ff" method="post">
        <div style="text-align: right">
            <div>
                名称:<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
            </div>
            <br/>
            <div>
                图片路径:<input class="easyui-validatebox" type="text" name="imgPath" data-options="required:true"/>
            </div>
            <br/>
            <div>
                描述:<input class="easyui-validatebox" type="text" name="description" data-options="required:true"/>
            </div>
            <br/>
            <div>
                状态:<input class="easyui-validatebox" type="text" name="status" data-options="required:true"/>
            </div>
        </div>
    </form>
</div>

