/**
 * 
 */
function validation() {
	if (document.getElementById('id').value == '') {
		alert("ID를 입력해주세요")
		return false;
	}
	
	return true;
}

function use(id) {
	opener.getElementById('id').value = id;
	
	window.close();
}