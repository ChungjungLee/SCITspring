/**
 * Javascript file for readForm.jsp
 */
function validation() {
	eReply = document.getElementById('replytext');
	if (eReply == null || eReply.value == '') {
		alert('리플 내용을 달아주세요');
		return false;
	}
	
	return true;
}

function replyUpdate(replynum) {
	
	// 리플을 단순 출력에서 입력 받을 수 있는 form으로 변환
	var eText = document.getElementById('replyUpdateText' + replynum);
	
	var text = document.getElementById('replyText' + replynum).innerHTML;
	
	//var coutText = "<c:out value=\"" + text + "\"/>";
	var str = "<form action='../reply/updateReply' method='POST' id='replyUpdate'>";
	str = str + "<input type='text' id='replytext' name='text' value='" + text + "'>";
	str = str + "<input type='hidden' name='replynum' value='" + replynum + "'>";
	str = str + "</form>";
	
	eText.innerHTML = str;
	
	// 수정 버튼을 누르면 controller를 호출하도록 변환
	var eLink = document.getElementById('updateReplyLink' + replynum);
	
	eLink.setAttribute("onclick", "javascript:update()");
	
}

function update() {
	document.getElementById('replyUpdate').submit();
}


