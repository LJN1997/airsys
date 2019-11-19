
	$.ajax({
	url:"aa",
	dataType:"json",

	success:function(e){
		console.log(e)
		var table = document.querySelector("table");
		var thead = document.querySelector("thead");
		for (var i = 0; i < e.length; i++) {
			
			var tr = document.createElement("tr");
            var td="";
            
            td+="<td attr='snumber'>"+e[i].snumber+"</td>";   
            td+="<td attr='sname'>"+e[i].sname+"</td>";
             
            tr.innerHTML=td;
            thead.appendChild(tr);
		}                                  
		                              
	}
})
