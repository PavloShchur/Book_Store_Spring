<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
<link href="/css/main.css" rel="stylesheet"/>
</head>
<body>
  <ul>
  <li><a href="/signup" target="_blank">Sign Up</a></li>
  <li><a href="/listOfBooks" target="_blank">Books</a></li>
  <li><a href="/listOfAuthors" target="_blank">Authors</a></li>
  <li><a href="/listOfGenres" target="_blank">Genres</a></li>
  
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>

<div style="text-align: center; margin-top: 1%">

	<form action="/saveBook" method="post">
		<input type="text" name="titleOfBook" placeholder="title of book"> <br>
		<input type="text" name="priceOfBook" placeholder="priceOfBook">
		<br> <input type="text" name="nameOfAuthor" placeholder="nameOfAuthor">
		<br> <input type="text" name="surnameOfAuthor" placeholder="surnameOfAuthor">
		<br> <input type="text" name="yearOfPublishing" placeholder="yearOfPublishing"> <br> <br>

				<input type="submit" name="saveBook" value="SAVE" />
				<input type="reset" value="RESET">
		</form>
	</div>
	
	<table style="border: 1px solid black">
		<tr>
			<th style="border: 1px solid black">Title of book</th>
			<th style="border: 1px solid black">Price if book</th>
			<th style="border: 1px solid black">Name of Author</th>
			<th style="border: 1px solid black">Surname of Author</th>
			<th style="border: 1px solid black">Year of Publishing</th>			
			<th style="border: 1px solid black">Delete</th>
			<th style="border: 1px solid black">Update</th>	
		</tr>
		
		<c:forEach var="b" items="${books}">
			<tr>
				<td style="border: 1px solid black">${b.titleOfBook}</td>
				<td style="border: 1px solid black">${b.priceOfBook}</td>
				<td style="border: 1px solid black">${b.nameOfAuthor}</td>
				<td style="border: 1px solid black">${b.surnameOfAuthor}</td>
				<td style="border: 1px solid black">${b.yearOfPublishing}</td>
				<td style="border: 1px solid black"><a href="/deleteBook/${b.id}">Delete</a></td>
				<td style="border: 1px solid black "><a	href="/updateBook/${b.id}" target="_blank">Update</a></td>
					 <br>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>