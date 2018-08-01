var element = document.getElementById("listeCoups");
element.scrollTop = element.scrollHeight;


if($('#score').attr('class') == 'alert alert-success'){
	$(".wrapper").css("background-color", "rgb(223,240,216")
	$(".alert").css("border", "none")
	$("#deco").css("background-color", "rgb(223,240,216")
}

if($('#listeCoups ul li:last-child').attr('class') == 'alert alert-danger'){
	$(".wrapper").css("background-color", "rgb(242,222,222")
	$(".alert").css("border", "none")
	$("#deco").css("background-color", "rgb(242,222,222")
}

if($('#listeCoups ul li:last-child').attr('class') == 'alert alert-warning'){
	$(".wrapper").css("background-color", "rgb(252,248,227")
	$(".alert").css("border", "none")
	$("#deco").css("background-color", "rgb(252,248,227")
}