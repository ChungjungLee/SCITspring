/**
 * 
 */
function gotoWriteForm() {
	location.href="write";
}

function search(page) {
	var ePage = document.getElementById('page');
	ePage.value = page;
	
	var form = document.getElementById('searchForm');
	form.submit();
}

