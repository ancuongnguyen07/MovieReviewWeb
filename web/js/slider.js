$(document).ready(function(){
    var stt = 0;
    starImg = $("img.slider1:first").attr("stt");
    endImg = $("img.slider1:last").attr("stt");
    $("img.slider1").each(function(){
        if($(this).is(':visible'))
            stt = $(this).attr("stt");
    });
    $("#next").click(function(){
        if(stt== endImg){
            stt = -1; //tăng lên 1 thì ko đúng
        }
        next = ++stt;
        $("img.slider1").hide();
        $("img.slider1").eq(next).show();
    });
    $("#prev").click(function(){
        if( stt = starImg){
            stt = endImg;
            prev= stt++;
        }
        prev = --stt;
        $("img.slider1").hide();
        $("img.slider1").eq(prev).show();
    });
    //Autu Run
    setInterval(function(){
        $("#next").click();
    },2000);
});