/**
 * 
 */
function validation() {
	eTitle = document.getElementById('title');
	if (eTitle == null || eTitle.value == '') {
		alert('제목은 필수입니다');
		return false;
	}
	
	return true;
}

function deleteAttach(attachmentnum) {
	
}