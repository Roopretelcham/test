<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- 
아이디 : ${id} <br/><br/>

비밀번호 : ${pw}  --%>

이름 : ${list} <br/> <br/>

or

<br/> <br/>

<%
ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");
for(int i =0; i<list.size();i++){
%>

<b><%=list.get(i) %></b>
<%} %>

</body>
</html>