function ondelete(id) {
	var isdelete = confirm("确定要删除这条数据？");
	if (isdelete) {
		window.location.href = "/airsys/flight/delete/" + id;
	}
}
