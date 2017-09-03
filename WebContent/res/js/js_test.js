function clicked() {
alert("HELLO WORLD");
}

function openModal(id) {
	
	var xhttp;    

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("modalContent").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/TED/res/jsp/ad.jsp?id="+id, true);
	xhttp.send();
	
	document.getElementById('myModal').style.display = "block";
}

function closeModal() {
	  document.getElementById('myModal').style.display = "none";
	}

$('#about').click(function(){
alert("I'm trying to do TED!!");
});

function show_error(){

	var x = document.getElementById('error');
	if (x.style.display === 'none') {
        x.style.display = 'block';
    } /*else {
        x.style.display = 'none';
    }*/
	alert("error");
}

function welcome(){
	
	var errorW = document.getElementById("errorW");
	
	if(errorW.style.display != 'none') errorW.style.display = 'none';
	show_boxes();
}

function show_boxes(count) {
	
	var place = document.getElementById("place")
	var xhttp;    

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
			//document.getElementById('loader').style.display = "none";
		}
	};
	//xhttp.open("GET", "/TED/res/jsp/results.jsp?str="+place.value, true);
	xhttp.open("GET", "/TED/DbServlet?str="+place.value+"&count="+count, true);
	xhttp.send();
}

function show_ads(count){
	var xhttp;    
	
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/TED/DbServlet?show_ads=show&count="+count, true);
	xhttp.send();

	var x = document.getElementById('myDropdown');
    if (x.style.display !== 'none') {
        x.style.display = 'none';
    }
}

function openNewTen(count,str) {
	//alert("I'm trying to do TED!!");
	//var per=document.getElementById("newten");
	var xhttp;  
	
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
		}
	};
	//xhttp.open("GET", "/TED/res/jsp/results.jsp?count="+count+"&str="+str, true);
	xhttp.open("GET", "/TED/DbServlet?count="+count+"&str="+str, true);
	xhttp.send();
	
}

function openNewTenAds(count) {
	//alert("I'm trying to do TED!!");
	//var per=document.getElementById("newten");
	var xhttp;  
	
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
		}
	};
	//xhttp.open("GET", "/TED/res/jsp/results.jsp?count="+count+"&str="+str, true);
	xhttp.open("GET", "/TED/DbServlet?show_ads=show&count="+count, true);
	xhttp.send();
	
}

function show_settings() {
	var xhttp;    

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/TED/DbServlet?settings=show", true);
	xhttp.send();
	
	var x = document.getElementById('myDropdown');
    if (x.style.display !== 'none') {
        x.style.display = 'none';
    }
}

function show_search() {
	var xhttp;    

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/TED/res/jsp/search.jsp", true);
	xhttp.send();
}


function show_dropdown() {
	var x = document.getElementById('myDropdown');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}

function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

function match(){
	var x = document.getElementById('errorp');

	if(document.getElementById("p1").value !== document.getElementById("p2").value){
		if (x.style.display === 'none') {
	        x.style.display = 'block';
	        register_unavailable();
	    }
	}
	else{
		x.style.display = 'none'
			register_available();
	}
			
}

function search_for_user_register(str){
	var xhttp;    

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange2").innerHTML = this.responseText;
			if(document.getElementById("answer").getAttribute('value') == "no") register_unavailable();
			else register_available();
		}
	};
	xhttp.open("GET", "/TED/DbServlet?searchForUser=show&q="+str+"&func=register", true);
	xhttp.send();
}

function search_for_user_login(str){
	var xhttp;    

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this);
			document.getElementById("toChange3").innerHTML = this.responseText;
			console.log(document.getElementById("answer").getAttribute('value'));
			if(document.getElementById("answer").getAttribute('value') == "no") login_unavailable();
			else login_available();
		}
	};
	xhttp.open("GET", "/TED/DbServlet?searchForUser=show&q="+str+"&func=login", true);
	xhttp.send();
}

function info_alert(){
	alert("Changes have been saved");
}

function login_available(){
	var btn = document.getElementById("login");
	btn.disabled = false;
}

function login_unavailable(){
	
	var btn = document.getElementById("login");
	btn.disabled = true;
}

function register_available(){
	
	var btn = document.getElementById("register");
	btn.disabled = false;
}

function register_unavailable(){
	var btn = document.getElementById("register");
	btn.disabled = true;
}

function make_reservation(user,id){
	var xhttp;    

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChangeAd").innerHTML = this.responseText;
			alert("Resrvation has been comfirmed");
		}
	};
	xhttp.open("GET", "/TED/res/jsp/make_reservation.jsp?user="+user+"&id="+id, true);
	xhttp.send();
}

function show_reservations(){
	var xhttp;    

	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/TED/res/jsp/show_reservations.jsp", true);
	xhttp.send();
	
	var x = document.getElementById('myDropdown');
    if (x.style.display !== 'none') {
        x.style.display = 'none';
    }
}


function show_profile(name){
	
	var xhttp;    
	
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("modalContent").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/TED/res/jsp/user_profile.jsp?name="+name, true);
	xhttp.send();
	
	document.getElementById('myModal').style.display = "block";
}


function show_path(val){
	var path = document.getElementById("file");
	document.getElementById("path").innerHTML = val;
	document.getElementById("path").style.display = 'block';
}


function make_ad(){
	var xhttp;    
	
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
			
			//load another js file
			$.getScript('/TED/res/js/google_maps.js', function()
			{
			    // script is now loaded and executed.
			    // put your dependent JS here.
				initMap();
			});
		}
	};
	xhttp.open("GET", "/TED/res/jsp/make_ad.jsp", true);
	xhttp.send();

	var x = document.getElementById('myDropdown');
    if (x.style.display !== 'none') {
        x.style.display = 'none';
    }
}

function ad_alert(){
	alert("Ad has been registered successfully!");
}
	
function send_message(fromuser,id){
	var xhttp;    
	
	content = document.getElementById("content").value;
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		}
	};
	xhttp.open("GET", "/TED/DbServlet?send_message=send&from="+fromuser+"&id="+id+"&content="+content, true);
	xhttp.send();
	
}

function show_messages(user){
	var xhttp;    
	
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("toChange").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/TED/DbServlet?show_messages=show&user="+user, true);
	xhttp.send();
	
	var x = document.getElementById('myDropdown');
    if (x.style.display !== 'none') {
        x.style.display = 'none';
    }
}

function reply(str){
	
	var x = document.getElementById(str);
	
	if(x.style.display === 'none') x.style.display = 'block'
	else x.style.display = 'none';
}

function send_reply(from,content,to,id){
	var xhttp;    
	
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById(id).style.display = 'none'
			alert("Your message has been sent!")
		}
	};
	xhttp.open("GET", "/TED/DbServlet?send_reply=show" +
			"&from="+from+"&content="+document.getElementById(content).value+"&to="+to, true);
	xhttp.send();
	
	
}







