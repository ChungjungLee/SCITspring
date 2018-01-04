/**
 * JavaScript file for updateForm.jsp
 */

function validation() {
	var eCustid = document.getElementById("custid");
	if (eCustid == null || eCustid.value == "") {
		alert("아이디를 입력해 주세요");
		return false;
	}
	
	var ePassword = document.getElementById("password");
	if (ePassword == null || ePassword.value == "") {
		alert("비밀번호를 입력해 주세요");
		return false;
	}
	
	var ePassword_c = document.getElementById("password_c");
	if (ePassword_c == null || ePassword_c.value == "") {
		alert("비밀번호 확인을 입력해 주세요");
		return false;
	}
	
	var eName = document.getElementById("name");
	if (eName == null || eName.value == "") {
		alert("이름을 입력해 주세요");
		return false;
	}
	
	var eEmail = document.getElementById("email");
	if (eEmail == null || eEmail.value == "") {
		alert("이메일을 입력해 주세요");
		return false;
	}
	
	var eDivision = document.getElementsByName("division");
	var checked = false;
	for (div of eDivision) {
		if (div.checked == true) {
			checked = true;
		}
	}
	if (checked == false) {
		alert("구분을 선택해 주세요");
		return false;
	}
	
	var eIdno = document.getElementById("idno");
	if (eIdno == null || eIdno.value == "") {
		alert("주민번호 혹은 사업자번호를 입력해 주세요");
		return false;
	}
	
	var eAddress = document.getElementById("address");
	if (eAddress == null || eAddress.value == "") {
		alert("주소를 입력해 주세요");
		return false;
	}
	
	if (ePassword.value == ePassword_c.value) {
		return true;
	} else {
		alert("비밀번호와 확인이 일치하지 않습니다");
		return false;
	}
}

function idCheckPage() {
	// 첫 번째 argument는 url이다. 페이지의 직접적인 이름이 아님
	// 어떤 페이지를 보고 싶다면 그 페이지를 보여줄 controller의 메소드를 만들어 놓고
	// 그 메소드를 호출해서 페이지를 봐야 한다. MVC패턴을 항상 지켜줘야 한다.
	window.open('idCheckPage', 'checkId', 
	'top=200,left=400,width=300,height=300');
}
























