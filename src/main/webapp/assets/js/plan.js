function ondelete(id) {
	var isdelete = confirm("确定要删除这条数据？");
	if (isdelete) {
		window.location.href = "/airsys/plan/delete/" + id;
	}
}
function onupdate(id) {
	window.location.href = "/airsys/plan/update/" + id;
}
function onshow(id) {
	window.location.href = "/airsys/plan/show/" + id;
}
function back() {
	window.location.href = "/airsys/plan/back";
}
function adds() {
	window.location.href = "/airsys/plan/add";
}