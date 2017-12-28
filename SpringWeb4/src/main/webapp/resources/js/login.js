/**
 * 
 */

function validation() {
	var eId = document.getElementById('id');
	var ePw = document.getElementById('pw');
	
	if (eId == null || ePw == null) {
		alert('입력부탁 null');
		return false;
	}
	
	if (eId.value == '' || ePw.value == '') {
		alert('입력부탁');
		return false;
	}
	
	return true;
}