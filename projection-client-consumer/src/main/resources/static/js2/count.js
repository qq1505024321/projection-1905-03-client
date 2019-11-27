(function($){
    $.fn.numberRock=function(options){
        var defaults={
            lastNumber:100,
            duration:2000,
            easing:'swing'  //swing(榛樿 : 缂撳啿 : 鎱㈠揩鎱�)  linear(鍖€閫熺殑)
        };
        var opts=$.extend({}, defaults, options);

        $(this).animate({
            num : "numberRock",
            // width : 300,
            // height : 300,
        },{
            duration : opts.duration,
            easing : opts.easing,
            complete : function(){
//              console.log("success");
            },
            step : function(a,b){  //鍙互妫€娴嬫垜浠畾鏃跺櫒鐨勬瘡涓€娆″彉鍖�
                //console.log(a);
                //console.log(b.pos);   //杩愬姩杩囩▼涓殑姣斾緥鍊�(0~1)
                $(this).html(parseInt(b.pos * opts.lastNumber));
            }
        });

    }

})(jQuery);