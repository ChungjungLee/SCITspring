/**
 * JavaScript file for idCheckForm.jsp
 */

function validation() {
	
	
	return true;
}

function useId(id) {
	opener.document.getElementById('custid').value = id;
	
	window.close();
}