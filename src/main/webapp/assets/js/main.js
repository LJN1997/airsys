 //检查是否有session 
	
window.onload = function(){
	

	$.ajax({
		url:"/airsys/placeadmin/check",
		success:function(e){
			var result=e.replace(/\s/g, "");
			if(result=="ok"){
				window.location.href="/airsys/login/login1"
			}
		}
	})	
	
		 //退出 
		$(".exitbtn").on("click",function(){
			$.ajax({
				url:"/airsys/placeadmin/exit",
				success:function(e){
					var result=e.replace(/\s/g, "");
					if(result=="ok"){
						window.location.href="/airsys/login/login1"
					}
				}
			})		
		})
	
	
}