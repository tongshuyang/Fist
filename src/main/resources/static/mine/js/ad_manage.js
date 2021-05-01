layui.use(['form','layer','table','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //广告列表
    table.render({
        elem: '#adList',
        url : '/ad/rms/list_ad',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "adListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth: 80},
            {field: 'url', title: '图片地址', align:'center',minWidth: 120},
            {field: 'link', title: '跳转链接', align:'center',minWidth: 120},
            {field: 'alt', title: '图片描述', align:'center',minWidth: 200},
            {field: 'type', title: '所属类型', align:'center',minWidth: 100, templet:function(d){
                    if(d.type === 0){
                        return "<span style=\"color: #ffa692;\">Banner</span>";
                    }else if(d.type === 1){
                        return "<span style=\"color: #25f585;\">广告</span>";
                    }
                    return "<span style=\"color: #ff6df2;\">车标</span>";
            }},
            {field: 'sort', title: '排序', align:'center',minWidth: 80},
            {field: 'createTime', title: '创建时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
            }},
            {field: 'createTime', title: '更新时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.updateTime, 'yyyy-MM-dd HH:mm:ss')}}
            }},
            {title: '操作', templet:'#adListBar',fixed:"right",align:"center",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("adListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                type: $("#type").val()
            }
        })
    });

    //操作
    table.on('tool(adList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        window.rowdata = data;
        if(layEvent === 'alt'){
            layer.open({
                title : "修改广告",
                type : 2,
                area : ["316px","410px"],
                content : '/ad/rms/alt_ad_dialog'
            });
        }else if(layEvent === 'sort'){
            layer.prompt({formType: 0, title: '修改排序',value: data.sort}, function(sort){
                $.post("/ad/rms/sort_ad",{id: data.id,sort: sort},function (res) {
                    if(res.rs){
                        table.reload("adListTable");
                    }
                    layer.closeAll();
                    layer.msg(res.info, {time: 2000});
                });
            });
        }
    });
});
