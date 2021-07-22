layui.use(['form', 'layer', 'table', 'util'], function () {
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //客户信息列表
    table.render({
        elem: '#customerList',
        url: '/customer/list_customer/verify',
        height: "full-106",
        limits: [10, 20, 30],
        limit: 20,
        id: "customerListTable",
        page: true,
        cols: [[
            {field: 'id', title: '客户ID', align: "center", minWidth: 50},
            {field: 'companyName', title: '公司名称', align: 'center', minWidth: 100},
            {field: 'saleName', title: '所属销售', align: 'center', minWidth: 60},
            {
                field: 'area', title: '所属区域', align: 'center', minWidth: 60, templet: function (d) {
                    switch (d.level) {
                        case 0:
                            return "未分类";
                        case 1:
                            return "华东";
                        case 2:
                            return "华南";
                        case 3:
                            return "华北";
                    }
                }
            },
            {
                field: 'level', title: '客户等级', align: 'center', minWidth: 60, templet: function (d) {
                    switch (d.level) {
                        case 0:
                            return "小体量";
                        case 1:
                            return "中等";
                        case 2:
                            return "重要";
                        case 3:
                            return "非常重要";
                    }
                }
            },
            {
                field: 'isSigned', title: '签约状态', align: 'center', minWidth: 60, templet: function (d) {
                    switch (d.level) {
                        case 0:
                            return "未签约";
                        case 1:
                            return "已签约";
                        case 2:
                            return "待续签";
                        case 3:
                            return "待回款";
                        case 4:
                            return "未续签";
                    }
                }
            },
            {field: 'companyDetail', title: '公司详情', hide: true},
            {field: 'buttType', title: '对接方式', hide: true},
            {field: 'buttProgress', title: '对接进度', hide: true},
            {
                field: 'createTime', title: '添加时间', align: 'center', minWidth: 100, templet: function (d) {
                    {
                        {
                            return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')
                        }
                    }
                }
            },
            {
                field: 'updateTime', title: '更新时间', align: 'center', minWidth: 100, templet: function (d) {
                    {
                        {
                            return util.toDateString(d.updateTime, 'yyyy-MM-dd HH:mm:ss')
                        }
                    }
                }
            },
            {title: '操作', templet: '#customerListBar', fixed: "right", align: "center", width: 120}
        ]]
    });

    //搜索
    $(".search_btn").on("click", function () {
        table.reload("customerListTable", {
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                companyName: $(".searchByCompanyName").val(),
                saleName: $(".searchBySaleName").val(),
                area: $("#searchByArea").val(),
                level: $("#searchByLevel").val()
            }
        })
    });

    //打开弹框
    function openDialog() {
        layer.open({
            title: "修改客户",
            type: 2,
            area: ["100%", "100%"],
            content: '/customer/edit_customer/verify'
        });
    }

    //添加
    $(".add_btn").on("click", function () {
        window.rowdata = undefined;
        openDialog()
    });

    //操作
    table.on('tool(customerList)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        window.rowdata = data;
        if (layEvent === 'alt') {
            openDialog()
        } else if (layEvent === 'searchCase') {
            layer.confirm('确定删除？', {icon: 3, title: '提示信息'}, function (index) {
                if (data.state === 2) {
                    layer.msg("已是删除状态", {time: 2000});
                } else {
                    $.get("/customer/rms/del_customer", {id: data.id}, function (res) {
                        if (res.rs) {
                            table.reload('customerListTable');
                        }
                        layer.close(index);
                        layer.msg(res.info, {time: 2000});
                    })
                }
            });
        }
    });
});
