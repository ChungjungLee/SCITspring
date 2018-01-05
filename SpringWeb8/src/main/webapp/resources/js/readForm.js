/**
 * Javascript file for readForm.jsp
 */
function validation() {
	eReply = document.getElementById('reply');
	if (eReply == null || eReply.value == '') {
		alert('리플 내용을 달아주세요');
		return false;
	}
	
	return true;
}