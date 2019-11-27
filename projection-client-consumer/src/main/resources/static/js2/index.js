$(function() {
    $(".home_head_nav_fl li a").mouseover(function() {
        $(this).addClass("on").parent().siblings("li").find("a").removeClass("on");
    });
    /*轮播*/
    $('#list_mark i:first').addClass('emon');
    $('.home_content13_mian .list1 li').eq(0).css('display', 'block');
    $('#list_mark1 i:first').addClass('emon');
    $('.ban_lun_fl .list1 li').eq(0).css('display', 'block');
    lun1();
    lun2();
    /*轮播*/
    //当前可见区域的大小
    var wh = $(window).height();
    //当前滚动的地方的窗口顶端到整个页面顶端的距离
    var home4 = $(".home_content4").offset().top - wh;
    var home16 = $(".home_content16").offset().top - wh;
    $(window).scroll(function() {
        var topHeight = $(window).scrollTop();
        /*动画*/
        /*动画*/
        /*头部导航开始*/
        if (topHeight > 420) {
            $(".home_head").addClass("head_scroll");
            $(".home_head ul li a").removeClass("on");
        }
        if (topHeight < 420) {
            $(".home_head").removeClass("head_scroll");
            $(".home_head ul li").eq(0).find("a").addClass("on");
        }
        /*头部导航结束*/

        if (topHeight > home4) {
            prection();
        }
        if (topHeight > home16) {
            count();
        }
    });
    //弹窗定时弹出
    var timers2 = null;
    var timer1 = setInterval(function() {
        $(".marketAlert4").show();
        console.log("time1");
        clearInterval(timer1);
    }, 40000);
    $(".marketAlert4").on("click", ".closeBtn", function() {
        clearInterval(timer1);
        clearInterval(timers2);
        $(".marketAlert4").hide();
        timers2 = setInterval(function() {
            $(".marketAlert4").show();
            console.log("time2");
            clearInterval(timers2);
        }, 20000);
    });
    //注册弹窗
    $(".registerAlertBtn").on("click", function() {
        spreadFun();
        $(".marketAlert4").hide();
        $(".registerAlert").show();
        clearInterval(timer1);
        clearInterval(timers2);
    });
    $(".registClose").on("click", function() {
        $(".registerAlert").hide();
        clearInterval(timers2);
        timers2 = setInterval(function() {
            $(".marketAlert4").show();
            console.log("time2");
            clearInterval(timers2);
        }, 20000)
    })

    function spreadFun() {
        var spreadUrl = window.location.href;
        /*if(spreadUrl.lastIndexOf('?') == -1){
            var nameUrl = spreadUrl;
        }else{
            var nameUrl = spreadUrl.substring(0,spreadUrl.lastIndexOf('?'));
        }*/
        var nameUrl = encodeURIComponent(spreadUrl);
        var iframeStr = '<iframe src="" frameborder="0" width="100%" height="100%"></iframe>'
        $(".iframBox").empty();
        $(".iframBox").html(iframeStr);
        $(".iframBox").find("iframe").attr("src", "http://manage.yunduoketang.com/register/yxPageRegister?utm_url=" + nameUrl);
    }
})

function count() {
    $(".count0").numberRock({
        lastNumber: 10,
        duration: 1000,
        easing: 'swing', //慢快慢
    });
    $(".count1").numberRock({
        lastNumber: 70,
        duration: 1000,
        easing: 'swing', //慢快慢
    });
    $(".count2").numberRock({
        lastNumber: 160,
        duration: 1000,
        easing: 'swing', //慢快慢
    });
    $(".count3").numberRock({
        lastNumber: 3000,
        duration: 1000,
        easing: 'swing', //慢快慢
    });
    $(window).unbind('scroll');
}

function lun2() {
    autoroll();
    hookThumb();
    var i = -1;
    var offset = 3000;
    var timer = null;

    function autoroll() {
        n = $('#list_mark1 i').length - 1;
        i++;
        if (i > n) {
            i = 0;
        }
        slide(i);
        timer = window.setTimeout(autoroll, offset);
    }

    function slide(i) {
        $('#list_mark1 i').eq(i).addClass('emon').siblings().removeClass('emon');
        $('.home_content13_mian .list1 li').eq(i).css('display', 'block').siblings('.list1 li').css('display', 'none');
    }

    function hookThumb() {
        $('#list_mark1 i').hover(
            function() {
                if (timer) {
                    clearTimeout(timer);
                    i = $(this).prevAll().length;
                    slide(i);
                }
            },
            function() {
                timer = window.setTimeout(autoroll, offset);
                this.blur();
                return false;
            });
    }
}

function lun1() {
    autoroll();
    hookThumb();
    var i = -1;
    var offset = 3000;
    var timer = null;

    function autoroll() {
        n = $('#list_mark i').length - 1;
        i++;
        if (i > n) {
            i = 0;
        }
        slide(i);
        timer = window.setTimeout(autoroll, offset);
    }

    function slide(i) {
        $('#list_mark i').eq(i).addClass('emon').siblings().removeClass('emon');
        $('.ban_lun_fl .list1 li').eq(i).css('display', 'block').siblings('.list1 li').css('display', 'none');
    }

    function hookThumb() {
        $('#list_mark i').hover(
            function() {
                if (timer) {
                    clearTimeout(timer);
                    i = $(this).prevAll().length;
                    slide(i);
                }
            },
            function() {
                timer = window.setTimeout(autoroll, offset);
                this.blur();
                return false;
            });
    }
}

/*录播授课*/
function prection() {
    $(".home_content4 ul .home_content4_0").animate({
        top: "140px",
        left: "-394px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_1").animate({
        top: "45px",
        left: "-495px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_2").animate({
        top: "20px",
        left: "-350px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_3").animate({
        top: "-75px",
        left: "-466px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_4").animate({
        top: "-150px",
        left: "-382px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_5").animate({
        top: "-215px",
        left: "-322px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_6").animate({
        top: "-212px",
        left: "246px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_7").animate({
        top: "-148px",
        left: "306px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_8").animate({
        top: "-74px",
        left: "385px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_9").animate({
        top: "20px",
        left: "272px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_10").animate({
        top: "40px",
        left: "412px",
        opacity: '1'
    }, 1500);
    $(".home_content4 ul .home_content4_11").animate({
        top: "134px",
        left: "322px",
        opacity: '1'
    }, 1500);
}
/*录播授课*/

/*WOW.JS*/
new WOW().init();
/*WOW.JS*/

/*立体*/
var $a = $(".buttons a");
var $s = $(".buttons span");
var cArr = ["p7", "p6", "p5", "p4", "p3"];
var index = 0;
$(".next").click(
    function() {
        nextimg();
    }
)
$(".prev").click(
    function() {
        previmg();
    }
)
//上一张
function previmg() {
    cArr.unshift(cArr[4]);
    cArr.pop();
    //i是元素的索引，从0开始
    //e为当前处理的元素
    //each循环，当前处理的元素移除所有的class，然后添加数组索引i的class
    $(".home_content12 ul li").each(function(i, e) {
        $(e).removeClass().addClass(cArr[i]);
    })
    index--;
    if (index < 0) {
        index = 4;
    }
    show();
}

//下一张
function nextimg() {
    cArr.push(cArr[0]);
    cArr.shift();
    $(".home_content12 li").each(function(i, e) {
        $(e).removeClass().addClass(cArr[i]);
    })
    index++;
    if (index > 4) {
        index = 0;
    }
    show();
}

//通过底下按钮点击切换
$a.each(function() {
    $(this).click(function() {
        var myindex = $(this).index();
        var b = myindex - index;
        if (b == 0) {
            return;
        } else if (b > 0) {
            /*
             * splice(0,b)的意思是从索引0开始,取出数量为b的数组
             * 因为每次点击之后数组都被改变了,所以当前显示的这个照片的索引才是0
             * 所以取出从索引0到b的数组,就是从原本的这个照片到需要点击的照片的数组
             * 这时候原本的数组也将这部分数组进行移除了
             * 再把移除的数组添加的原本的数组的后面
             */
            var newarr = cArr.splice(0, b);
            cArr = $.merge(cArr, newarr);
            $(".home_content12 ul li").each(function(i, e) {
                $(e).removeClass().addClass(cArr[i]);
            })
            index = myindex;
            show();
        } else if (b < 0) {
            /*
             * 因为b<0,所以取数组的时候是倒序来取的,也就是说我们可以先把数组的顺序颠倒一下
             * 而b现在是负值,所以取出索引0到-b即为需要取出的数组
             * 也就是从原本的照片到需要点击的照片的数组
             * 然后将原本的数组跟取出的数组进行拼接
             * 再次倒序,使原本的倒序变为正序
             */
            cArr.reverse();
            var oldarr = cArr.splice(0, -b)
            cArr = $.merge(cArr, oldarr);
            cArr.reverse();
            $(".home_content12 ul li").each(function(i, e) {
                $(e).removeClass().addClass(cArr[i]);
            })
            index = myindex;
            show();
        }
    })
})

//改变底下按钮的背景色
function show() {
    $($s).eq(index).addClass("blue").parent().siblings().children().removeClass("blue");
}

//点击class为p2的元素触发上一张照片的函数
$(document).on("click", ".p2", function() {
    previmg();
    return false; //返回一个false值，让a标签不跳转
});

//点击class为p4的元素触发下一张照片的函数
$(document).on("click", ".p4", function() {
    nextimg();
    return false;
});

//			鼠标移入box时清除定时器
$(".home_content12 .box").mouseover(function() {
    clearInterval(timer);
})

//			鼠标移出box时开始定时器
$(".home_content12  .box").mouseleave(function() {
    timer = setInterval(nextimg, 4000);
})

//			进入页面自动开始定时器
timer = setInterval(nextimg, 4000);
/*3D*/

/*免费试用*/
function gotoRegister() {
    var url = 'http://manage.yunduoketang.com/register/registerNewPage';
    var params = location.href.split("?")[1];

    url += '?';
    url += "utm_url=" + encodeURI(location.href);
    //location.href=url;
    window.open(url);
}
//左右两边的挂件轮播
var bgNumber = 1;
timer2 = setInterval(function() {
    var bgUrl = "img/guaJian" + bgNumber + ".png";
    if (bgNumber < 5) {
        // $(".left-fixed").css("background-image","url("+bgUrl+")");
        $(".left-fixed").removeClass('active' + (bgNumber !== 1 ? bgNumber - 1 : '5')).addClass('active' + bgNumber)
        bgNumber++;
    } else {
        bgNumber = 1;
        $(".left-fixed").removeClass('active4').addClass('active' + bgNumber)
    };
}, 3000);
