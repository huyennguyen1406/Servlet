<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2022
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Cities</h1>
<c:if test="cities.isEmpty()">
    <p style="color: red">Không có thành phố nào</p>
</c:if>
<button><a href="/CityServlet?param=createGet">Create new city</a></button>
<button><a href="/CityServlet?param=sort">Sắp xếp</a></button>
<br>
<br>
<form action="/CityServlet?param=search" method="post">
    <label><input type="text" name="search-name"></label>
    <button type="submit">Search</button>
</form>

<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Area</td>
        <td>Population</td>
        <td>GDP</td>
        <td>Country Name</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items="${cities}" var="city">
<%--        <c:if city.getGdp() < 100000>--%>
        <tr>
            <td>${city.getId()}</td>
            <td>${city.getName()}</td>
            <td>${city.getArea()}</td>
            <td>${city.getPopulation()}</td>
            <td>${city.getGdp()}</td>
            <td>${city.getCountryName()}</td>
            <td>
                <button><a href="/CityServlet?param=edit">Edit</a></button>
            </td>
            <td>
                <button><a href="/CityServlet?param=delete">Delete</a></button>
            </td>
        </tr>
<%--    </c:if>--%>
    </c:forEach>
</table>
</body>
</html>
