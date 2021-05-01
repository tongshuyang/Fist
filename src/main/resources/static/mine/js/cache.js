var cacheStr = window.sessionStorage.getItem("cache");
layui.use(['form','jquery',"layer"],function() {
    var form = layui.form,
        $ = layui.jquery,
        layer = parent.layer === undefined ? layui.layer : top.layer;

    //退出
    $("#signOut").click(function(){
        window.sessionStorage.removeItem("menu");
        menu = [];
        window.sessionStorage.removeItem("curmenu");
        window.sessionStorage.removeItem("adminUser");
        $.get("/admin_user/sign_out",function(res){
            window.location.href = res.data;
        });
    });

    //功能设定
    $(".functionSetting").click(function(){
        layer.open({
            title: "功能设定",
            area: ["380px", "220px"],
            type: "1",
            content :  '<div class="functionSrtting_box">'+
                            '<form class="layui-form">'+
                                '<div class="layui-form-item">'+
                                    '<label class="layui-form-label">开启Tab缓存</label>'+
                                    '<div class="layui-input-block">'+
                                        '<input type="checkbox" name="cache" lay-skin="switch" lay-text="开|关">'+
                                        '<div class="layui-word-aux">开启后刷新页面不关闭打开的Tab页</div>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="layui-form-item">'+
                                    '<label class="layui-form-label">Tab切换刷新</label>'+
                                    '<div class="layui-input-block">'+
                                        '<input type="checkbox" name="changeRefresh" lay-skin="switch" lay-text="开|关">'+
                                        '<div class="layui-word-aux">开启后切换窗口刷新当前页面</div>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="layui-form-item" style="text-align: center;">'+
                                    '<a href="javascript:;" class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="settingSuccess">设定完成</a>'+
                                    '<a href="javascript:;" class="layui-btn layui-btn-sm layui-btn-primary" lay-submit="" lay-filter="noSetting">朕再想想</a>'+
                                '</div>'+
                            '</form>'+
                        '</div>',
            success : function(index, layero){
                //如果之前设置过，则设置它的值
                $(".functionSrtting_box input[name=cache]").prop("checked",cacheStr === "true");
                $(".functionSrtting_box input[name=changeRefresh]").prop("checked",changeRefreshStr === "true");
                //设定
                form.on("submit(settingSuccess)",function(data){
                    window.sessionStorage.setItem("cache",data.field.cache === "on" ? "true" : "false");
                    window.sessionStorage.setItem("changeRefresh",data.field.changeRefresh === "on" ? "true" : "false");
                    window.sessionStorage.removeItem("menu");
                    window.sessionStorage.removeItem("curmenu");
                    location.reload();
                    return false;
                });
                //取消设定
                form.on("submit(noSetting)",function(){
                    layer.closeAll("page");
                });
                form.render();  //表单渲染
            }
        })
    });
});