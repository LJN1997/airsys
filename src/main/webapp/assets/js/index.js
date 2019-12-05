window.onload = function() {
	var abcd = document.querySelector(".ii");
	var abc = document.querySelector(".ij");

	var uid = $(".uid").val();
	var list = $(".usts").val();
	var info = document.querySelector(".top");
	var info1 = document.querySelector(".topp");
	var order = document.querySelector(".loginbox1");
	var login = document.querySelector(".loginbox2");
	var go = document.querySelector(".go");


	/* 按钮 */
	var buff3 = document.querySelector(".buff3");
	var buff1 = document.querySelector(".buff1");
	var buff2 = document.querySelector(".buff2");
	/* 内容 */
	var box1 = document.querySelector(".buff1-box");
	var box3 = document.querySelector(".buff3-box");
	var box2 = document.querySelector(".buff2-box");
	buff3.onclick = function() {
		box1.style.display = "none";
		box2.style.display = "none";
		buff3.style.background = "#E81932";
		buff1.style.background = "rgba(0,0,0,.4)";
		buff2.style.background = "rgba(0,0,0,.4)";
		box3.style.display = "block";
	}
	buff1.onclick = function() {
		box1.style.display = "block";
		buff1.style.background = "#E81932";
		buff3.style.background = "rgba(0,0,0,.4)";
		buff2.style.background = "rgba(0,0,0,.4)";
		box3.style.display = "none";
		box2.style.display = "none";

	}
	buff2.onclick = function() {
		box1.style.display = "none";
		box3.style.display = "none";
		buff3.style.background = "rgba(0,0,0,.4)";
		buff1.style.background = "rgba(0,0,0,.4)";
		buff2.style.background = "#E81932";
		box2.style.display = "block";

		if (uid == "" || uid == null) {
			info1.style.display = "none";
			login.style.display = "block";
		} else {
			info.style.display = "block";
		}

	}
	var exit = document.querySelector(".exit");
	if (uid == "" || uid == null) {
		exit.style.display = "none";
	} else {
		exit.style.display = "block";
		go.innerHTML = "您好," + uid + "!";
	}

}