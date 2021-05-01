layui.use(['form','layer','table','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //动态列表
    table.render({
        elem: '#linkList',
        url : '/friend_link/rms/list_link',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "linkListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth: 80},
            {field: 'name', title: '网站名', align:'center',minWidth: 120},
            {field: 'logo', title: '网站LOGO', align:'center',minWidth: 120},
            {field: 'link', title: '网站地址', align:'center',minWidth: 80,templet:function(d){
                    return "<a href = '"+d.link+"' target='_blank'>"+d.link+"</a>"
                }},
            {field: 'email', title: '站长邮箱', align:'center',minWidth: 80,templet:function(d){
                    return "<a href = 'mailto:"+d.email+"'>"+d.email+"</a>"
                }},
            {field: 'createTime', title: '创建时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {title: '操作', templet:'#linkListBar',fixed:"right",align:"center",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("linkListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                name: $(".searchName").val()
            }
        })
    });

    //打开弹框
    function openDialog(){
        layer.open({
            title : "编辑友链",
            type : 2,
            area : ["316px","410px"],
            content : '/friend_link/rms/edit_link_dialog'
        });
    }

    //添加
    $(".add_btn").on("click",function(){
        window.rowdata = undefined;
        openDialog()
    });

    //操作
    table.on('tool(linkList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        window.rowdata = data;
        if(layEvent === 'alt'){
            openDialog()
        }else if(layEvent === 'del'){
            layer.confirm('确定删除友链？',{icon:3, title:'提示信息'},function(index){
                $.get("/friend_link/rms/del_link",{id : data.id},function(res){
                    if(res.rs){
                        table.reload("linkListTable");
                    }
                    layer.close(index);
                    layer.msg(res.info, {time: 2000});
                })
            });
        }

    });
});
