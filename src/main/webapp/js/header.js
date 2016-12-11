window.onload = function() {
	var xhr = null;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xhr = xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var text = "<li><a href='index'>首页</a>|</li>";
			var category1s = eval("(" + xhr.responseText + ")");
			for (var i = 0; i < category1s.length; i++) {
				var category1 = category1s[i];
				text += "<li><a href='good_listByCategory1IdPage?category1Id="
					+ category1.id + "&currentPage=1'>"
					+ category1.name + "</a>|</li>";
			}
			document.getElementById("category1").innerHTML = text;
		}
	}
	xhr.open("post", "category1_findAll");
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
}