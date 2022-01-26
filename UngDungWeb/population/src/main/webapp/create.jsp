<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2022
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new student</h1>
<form action="/CityServlet?param=createPost" method="post">
    <label>ID:
        <input type="text" name="id">
    </label><br>
    <label>Name:
        <input type="text" name="name">
    </label><br>
    <label>Area:
        <input type="text" name="area">
    </label><br>
    <label>Population:
        <input type="text" name="population">
    </label><br>
    <label>GDP:
        <input type="text" name="gdp">
    </label><br>
    <label>CountryName:
        <input type="text" name="countryName">
    </label><br>
    <button type="submit">Create</button>
</form>
</body>
</html>
