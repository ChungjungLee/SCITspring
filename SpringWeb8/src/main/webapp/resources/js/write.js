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


/* 첨부파일 수정*/
function fileEdit(attachmentnum, filepath) {
	var eText = document.getElementById('file_name_' + attachmentnum);
	var filename = filepath.substring(filepath.lastIndexOf('\\') + 1);
	eText.value = filename;
}


/* 첨부파일 삭제 */
function fileDelete(attachmentnum) {
	var eToDelete = document.getElementById('file_' + attachmentnum);
	eToDelete.remove();
	
	var eDeletenums = document.getElementById('deletenums');
	var oldAtt = eDeletenums.getAttribute('value');
	
	if (oldAtt == '') {
		var newAtt = attachmentnum;
	} else {
		var newAtt = oldAtt + ', ' + attachmentnum;
	}
	
	eDeletenums.setAttribute('value', newAtt);
}


function fileAdd() {
	
}














