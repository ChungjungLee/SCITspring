/**
 * 
 */

function test1() {
	alert('안녕');
}

function test2(num) {
	alert(num + "입니다");
}

function test3(num1, num2) {
	alert(num1 + num2);
}

function test4() {
	var eLeft = document.getElementById('left');
	var eRight = document.getElementById('right');
	
	alert(eLeft.value + eRight.value);
	
	alert(
			parseInt(eLeft.value) + parseInt(eRight.value)
	);
}

function test5() {
	var eBox = document.getElementById('box');
	
	var str = "<img src='./rsrc/img/2.jpg'><br>";
	
	eBox.innerHTML += str;
}









