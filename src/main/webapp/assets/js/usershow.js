function ondelete(id) {
	var isdelete = confirm("是否拉黑此用户？");
	if (isdelete) {
		window.location.href = "/airsys/user/delete/" + id;
	}
}