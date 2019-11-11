function del (id) {
	if(confirm("确定删除？")){
    	window.location.href="/airsys/placeadmin/delete/"+id
	}
}

function add(){
	window.location.href="/airsys/placeadmin/add/2"
}

function view(id){
	window.location.href="/airsys/placeadmin/view/" +id                
}

function ret(){
	window.location.href="/airsys/placeadmin/saleticket"                
}