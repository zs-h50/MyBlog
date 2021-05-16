$('#menutoggle').click(function(){
    $('.m-item').toggleClass('m-mobile-hide')
});

// 二维码
$('#paybutton').popup({
    popup : $('#pay.popup'),
    on : 'click',
    position : 'bottom center'
});
// github
$('#github').popup({
    popup : $('#git.popup'),
    on : 'click',
    position : 'bottom center'
});
// weixin
$('#wechat').popup({
    popup : $('#weixin.popup'),
    position : 'bottom center'
});
// qq
$('#QQ').popup({
    popup : $('#q.popup'),
    position : 'bottom center'
});