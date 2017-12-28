/**
 * 
 */
function checkId() {
	/**
	 * window라는 객체가 존재(브라우저의 내용을 담고 있음)
	 * window.open(url, name, options,...);
	 */
	// 처음 파라미터는 이 창을 연 곳의 주소가 암묵적으로 들어가 있다고 생각한다
	// 그래서 /idCheck는 최상위 루트로 올라간다
	// ./ 이나 아무것도 쓰지 않으면 이 창을 연 곳의 주소
	
	
	window.open('idCheck', 'checkId', 
			'top=200,left=400,width=300,height=300');
}
