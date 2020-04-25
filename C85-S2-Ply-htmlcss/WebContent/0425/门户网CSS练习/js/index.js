// JavaScript Document
var total=6;
var index=1;

function changePic(){
	index+=1;
	index=index%total;
	document.getElementById("changePic").src="images/pic_"+index+".jpg";
}

window.setInterval("changePic()",1000);