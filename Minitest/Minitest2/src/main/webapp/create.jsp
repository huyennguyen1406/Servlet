<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/27/2022
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/ProductServlet" var="myUrl">
    <c:if test="${product != null}">
        <c:param name="action" value="editPost"/>
    </c:if>
    <c:if test="${product == null}">
        <c:param name="action" value="creatPost"/>
    </c:if>
</c:url>
<form action="${myUrl}" method="post">
    <label>ID :
        <input <c:if test="${product != null}">value="${product.getId()}"</c:if> type="text" name="id">
    </label>
    <label>Name :
        <input <c:if test="${product != null}">value="${product.getName()}"</c:if> type="text" name="name">
    </label>
    <label>Price :
        <input <c:if test="${product != null}">value="${product.getPrice()}"</c:if> type="text" name="price">
    </label>
    <label>Quantity :
        <input <c:if test="${product != null}">value="${product.getQuantity()}"</c:if> type="text" name="quantity">
    </label>
    <label>Description :
        <input <c:if test="${product != null}">value="${product.getGDP()}"</c:if> type="text" name="description">
    </label>
    <label>Brands :
        <select name="brand">
            <c:forEach items="${brand}" var="bran">
                <option value="${bran}">${bran}</option>
            </c:forEach>
        </select>
    </label>
    <label>Quantity :
        <input <c:if test="${product != null}">value="${product.getQuantity()}"</c:if> type="text" name="quantity">
    </label>
    <input type="submit" <c:if test="${product != null}">value="Edit"</c:if><c:if test="${product == null}">value="Create"</c:if> >
</form>
</body>
</html>
