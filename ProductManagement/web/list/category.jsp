<%-- 
    Document   : category
    Created on : Dec 2, 2021, 1:54:16 PM
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
                    <th>Description</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach var="cate" items="${CategoryList}">
                    <tr>
                        <td>${cate.categoryId}</td>
                        <td>${cate.name}</td>
                        <td>${cate.description}</td>
                        <td><a href="products?cateId=${cate.categoryId}">Show product</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html> 
