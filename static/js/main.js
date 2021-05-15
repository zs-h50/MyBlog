$('#menutoggle').click(function(){
    $('.m-item').toggleClass('m-mobile-hide')
});

// 二维码
$('#paybutton').popup({
    popup : $('#pay.popup'),
    on : 'click',
    position : 'bottom center'
});