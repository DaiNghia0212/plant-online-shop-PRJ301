<%-- 
    Document   : index.jsp
    Created on : Feb 26, 2023, 2:16:55 AM
    Author     : daing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plant Shop Product Page</title>
    </head>
    <body>
        <h1>Plant Shop Product Page</h1>
        <c:forEach var="product" items="${products}">
            <p>${product.name}: $ ${product.price}</p>
        </c:forEach>
    </body>
</html>
