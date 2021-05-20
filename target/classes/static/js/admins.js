// 初始化Markdown
var contentEditor;
    $(function() {
        contentEditor = editormd("md-content", {
        width   : "90%",
        height  : 640,
        syncScrolling : "single",
         path   : "./static/lib/Markdown/lib/"
    });
                
    /*
    // or
    testEditor = editormd({
    id      : "test-editormd",
    width   : "90%",
    height  : 640,
    path    : "../lib/"
    });
    */
});
// 表单验证
$('.ui.form').form({
    fields :{
        // title 在HTML中对应name属性
        title :{
            identifier : 'title',
            rules :[{
                type : 'empty',
                prompt : '博客标题不可为空，请重新输入！！！',
            }]
        },
        content :{
            identifier : 'content',
            rules :[{
                type : 'empty',
                prompt : '博客内容不可为空，请重新输入！！！',
            }]
        },
    }
});

//登录验证
$('.ui.form').form({
    fields :{
        // title 在HTML中对应name属性
        username :{
            identifier : 'username',
            rules :[{
                type : 'empty',
                prompt : '用户名不可为空，请重新输入！！！',
            }]
        },
        password :{
            identifier : 'password',
            rules :[{
                type : 'empty',
                prompt : '密码不可为空，请重新输入！！！',
            }]
        },
    }
});