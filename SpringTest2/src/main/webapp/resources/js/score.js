/**
 * 
 */

function validation() {
	var eKor = document.getElementById('kor');
	var eEng = document.getElementById('eng');
	var eMat = document.getElementById('mat');
	
	console.log(typeof eKor);
	console.log(typeof eKor.value);
	console.log(eKor.value);
	console.log(eKor.type);
	
	if (!isNull(eKor) || !isNull(eEng) || !isNull(eMat)) {
		alert('점수를 모두 입력하세요');
		return false;
	}
	
	if (isNaN(eKor.value) || isNaN(eEng.value) || isNaN(eMat.value)) {
		alert('숫자만 입력하세요');
		return false;
	}
	
	if (!isScoreVal(eKor.value) || !isScoreVal(eEng.value) || !isScoreVal(eMat.value)) {
		alert('0-100 사이의 점수만 입력하세요');
		return false;
	}
	
	return true;
}

function isNull(toCheck) {
	if (toCheck == null || toCheck.value == '') {
		return false;
	}
	
	return true;
}

function isScoreVal(toCheck) {
	if (toCheck < 0 || toCheck > 100) {
		return false;
	}
	
	return true;
}