window.onload=function () {
    var abcd = document.querySelector(".ii");
    var abc = document.querySelector(".ij");
    abcd.onclick=function () {
        abcd.style.border="1px solid red";
        abc.style.border="none";
    }
    abc.onclick=function () {
        abc.style.border="1px solid red";
        abcd.style.border="none";
    }

    /*按钮*/
    var buff3 = document.querySelector(".buff3");
    var buff1 = document.querySelector(".buff1");
    var buff2 = document.querySelector(".buff2");
    /*内容*/
    var box1 = document.querySelector(".buff1-box");
    var box3 = document.querySelector(".buff3-box");
    var box2 = document.querySelector(".buff2-box");
    buff3.onclick=function () {
        box1.style.display="none";
        box2.style.display="none";
        buff3.style.background="#E81932";
        buff1.style.background="rgba(0,0,0,.4)";
        buff2.style.background="rgba(0,0,0,.4)";
        box3.style.display="block";
    }
    buff1.onclick=function () {
        box1.style.display="block";
        buff1.style.background="#E81932";
        buff3.style.background="rgba(0,0,0,.4)";
        buff2.style.background="rgba(0,0,0,.4)";
        box3.style.display="none";
        box2.style.display="none";

    }
    buff2.onclick=function () {
        box1.style.display="none";
        box3.style.display="none";
        buff3.style.background="rgba(0,0,0,.4)";
        buff1.style.background="rgba(0,0,0,.4)";
        buff2.style.background="#E81932";
        box2.style.display="block";
    }

}