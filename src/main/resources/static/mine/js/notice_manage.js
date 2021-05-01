layui.use(['form','layer','table','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //通知列表
    var tableIns = table.render({
        elem: '#noticeList',
        url : '/notice/rms/list_notice',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "noticeListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth: 80},
            {field: 'userId', title: '用户ID', align:'center',minWidth: 80},
            {field: 'title', title: '标题', align:'center',minWidth: 100},
            {field: 'content', title: '内容', align:'center',minWidth: 300},
            {field: 'state', title: '状态', align:'center',minWidth: 100, templet:function(d){
                if(d.state === 0){
                    return "<span style=\"color: #ffb22a;\">未查看</span>";
                }else if(d.state === 1){
                    return "<span style=\"color: #25f585;\">已查看</span>";
                }
                return "<span style=\"color: #F581B1;\">已删除</span>";
            }},
            {field: 'createTime', title: '发送时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {title: '操作', templet:'#noticeListBar',fixed:"right",align:"center",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("noticeListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                userId: $(".searchUserId").val(),  //搜索的关键字
                state: $("#state").val()
            }
        })
    });

    table.on('tool(noticeList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        window.rowdata = obj.data;
        if(layEvent === 'alt'){
            layer.open({
                title : "修改通知",
                type : 2,
                area : ["316px","252px"],
                content : '/notice/rms/alt_notice_dialog'
            });
        }else if(layEvent === 'del'){
            layer.confirm('确定删除此通知？',{icon:3, title:'提示信息'},function(index){
                if(data.state === 2){
                    layer.msg("已是删除状态", {time: 2000});
                }else {
                    $.get("/notice/rms/del_notice",{id : data.id},function(res){
                        if(res.rs){
                            tableIns.reload();
                        }
                        layer.close(index);
                        layer.msg(res.info, {time: 2000});
                    })
                }
            });
        }
    });
});
