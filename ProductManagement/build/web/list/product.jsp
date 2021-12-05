<%-- 
    Document   : product
    Created on : Dec 2, 2021, 1:53:54 PM
    Author     : Loki Kun
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>            
                <c:forEach var="pro" items="${ProductList}">
                    <tr>
                        <td>${pro.productId}</td>
                        <td>${pro.name}</td>
                        <td>${pro.price}</td>
                        <td>${pro.description}</td>
                        <td><a href="assign?proId=${pro.productId}">Change Category</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
