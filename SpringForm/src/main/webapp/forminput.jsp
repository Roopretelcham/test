<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="inputprocess.bo" method="post">
		<table align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="10" maxlength="10" /></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" size="10" maxlength="10" /></td>
			</tr>
			<tr>

				<td colspan="2"><input type="submit" value="입력" /></td>
			</tr>
		</table>
	</form>
</body>
</html>