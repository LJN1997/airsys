function ondelete(id){
	var isdelete = confirm("确定要删除这条数据？");
	if(isdelete){
		window.location.href="/airsys/place/delete/"+id;
	}
}
function onupdate(id){
		window.location.href="/airsys/place/update/"+id;
}
function back(){
	window.location.href="/airsys/place/back";
}
function add(){
		window.location.href="/airsys/place/add";
}