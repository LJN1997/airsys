function ondelete(id){
	var isdelete = confirm("确定要删除这条数据？");
	if(isdelete){
		window.location.href="/airsys/air/delete/"+id;
	}
}
function onupdate(id){
		window.location.href="/airsys/air/update/"+id;
	
}