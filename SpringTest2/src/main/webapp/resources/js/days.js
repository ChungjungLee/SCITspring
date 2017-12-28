/**
 * 
 */

function validation() {
	var eYear = document.getElementById('year');
	var eMonth = document.getElementById('month');
	
	if (isNull(eYear) || isNull(eMonth)) {
		alert('연도 및 월 입력 바람');
		console.log('연도 및 월 입력 바람');
		return false;
	}
	
	if (isNaN(eYear.value) || isNaN(eMonth.value)) {
		alert('숫자만 입력 바람');
		console.log('숫자만 입력 바람');
		return false;
	}
	
	if ((eYear.value < 0) || (eMonth.value < 1 || 12 < eMonth.value)) {
		alert('범위 내 숫자만 입력 바람');
		console.log('범위 내 숫자만 입력 바람');
		return false;
	}
	
	return true;
}

function isNull(toCheck) {
	if (toCheck == null || toCheck.value == '') {
		return true;
	}
	
	return false;
}

