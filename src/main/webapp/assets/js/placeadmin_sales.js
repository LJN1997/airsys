function del (id,pid) {
	if(confirm("确定删除？")){
    	window.location.href="/airsys/placeadmin/delete/"+id+"/"+pid
	}
}

function add(id){
	window.location.href="/airsys/placeadmin/add/"+id

}

function view(id,pid){
	window.location.href="/airsys/placeadmin/view/" +id+ "/"+pid               
}

function ret(id){
	window.location.href="/airsys/placeadmin/saleticket/"+id                
}