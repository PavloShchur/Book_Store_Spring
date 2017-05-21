<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="/css/main.css" rel="stylesheet"/>
<body>
<ul>
  <li><a href="/signup" target="_blank">Sign Up</a></li>
  <li><a href="/listOfBooks" target="_blank">Books</a></li>
  <li><a href="/listOfAuthors" target="_blank">Authors</a></li>
  <li><a href="/listOfGenres" target="_blank">Genres</a></li>
  
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>

<div style="text-align: center; margin-top: 10px">

	<form action="/saveGenre" method="post">
		<input type="text" name="genreOfBook" placeholder="genreOfBook"> <br>
	
				<input type="submit" name="saveGenre" value="SAVE" />
				<input type="reset" value="RESET">
		</form>
	</div>
	
	<table style="border: 1px solid black">
		<tr>
			<th style="border: 1px solid black">Genre of book</th>
			<th style="border: 1px solid black">Delete</th>
			<th style="border: 1px solid black">Update</th>	
		</tr>
		
		<c:forEach var="g" items="${genres}">
			<tr>
				<td style="border: 1px solid black">${g.genreOfBook}</td>
				<td style="border: 1px solid black"><a href="/deleteGenre/${g.id}">Delete</a></td>
				<td style="border: 1px solid black "><a	href="/updateGenre/${g.id}" target="_blank">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>