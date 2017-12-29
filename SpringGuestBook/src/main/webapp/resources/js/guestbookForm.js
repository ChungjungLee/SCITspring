/**
 * 
 */
function guestbookWrite() {
	
	location.href = "./guestbookwrite";
}

function modify(clickednum) {
	var ePwElem = document.getElementById('pw'+clickednum);
	var password = ePwElem.value;
	
	var ePassword = document.getElementById('password');
	ePassword.value = password;
		
	var eClickedNum = document.getElementById('clickednum');
	eClickedNum.value = clickednum;
	
}