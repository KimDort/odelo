<%@page import="com.ican.com.bean.OthelloBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int[][] panel = new int[10][10];
	List<?> getBeanInfo = (List<?>) request.getSession().getAttribute("bean");
	List<OthelloBean> beanList = (List<OthelloBean>) getBeanInfo;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.panel_block {
	cursor: pointer;
	position: relative;
}

.stone_black {
	position: absolute;
	width: 50px;
	height: 50px;
	border-radius: 100px;
	background: black;
}
.stone_white{
position: absolute;
	width: 50px;
	height: 50px;
	border-radius: 100px;
	background: white;
	border: 1px solid #000000;
}
</style>
<script>
$(document).ready(function(){
	var message="<%=request.getAttribute("msg")%>";
	if(message!="null"){
		alert(message);
	}
	createPanel();
});
function createPanel(){
	for(var idx=1;idx<=10;idx++){
		for(var jdx=1;jdx<=10;jdx++){
			var str='<div class="panel_block" style="width:50px;height:50px;border: 1px solid #000000;float: left;"onclick="saveArrayIndex('+jdx+','+idx+')"></div>';
			$(".panel_box").append(str);
		}
	}
}
function saveArrayIndex(x,y){
	alert("x : "+x+", y : "+y);
	$("#frm").append('<input type="hidden" value="'+x+'" name="x">');
	$("#frm").append('<input type="hidden" value="'+y+'" name="y">');
	$("#frm").submit();
}
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/index" method="post" id="frm">
	<div class="panel_box" style="width: 500px; height: 500px;">
		<%for (int idx = 0; idx < beanList.size(); idx++) {%>
		<%if(beanList.get(idx).getStoneColor()=='B'){ %>
			<div class="stone_black" style="left:<%=(beanList.get(idx).getPositionX()*50)-50%>px;top:<%=(beanList.get(idx).getPositionY()*50)-50%>px;"></div>		
		<%}else{ %>
			<div class="stone_white" style="left:<%=(beanList.get(idx).getPositionX()*50)-50%>px;top:<%=(beanList.get(idx).getPositionY()*50)-50%>px;"></div>	
		<%} %>
	<%}%>
	</div>
	</form>
</body>
</html>