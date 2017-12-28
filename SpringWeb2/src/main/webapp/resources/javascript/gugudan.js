/**
 * 
 */
function validation() {
	var eInput = document.getElementById('input');
	
	if (eInput == null) {
		alert('숫자를 입력하세요');
		return false;
	}
	
	var input = eInput.value;
	
	if (input == '') {
		alert('숫자를 입력하세요');
		return false;
	}
	
	if (input < 2 || 10 < input) {
		alert('구구단 범위의 숫자를 입력하세요');
		return false;
	}
	
	alert('숫자 입력됨');
	
	return true;
	
}