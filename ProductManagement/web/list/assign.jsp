<%-- 
    Document   : assign
    Created on : Dec 5, 2021, 8:07:13 AM
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
        <form method="post">
            <input type="hidden" name="proId" value="${pro.productId}">  
            Do you really want to assign product: <b>${pro.name}</b>
                <select name="category">
                    <c:forEach var="item" items="${categories}">
                        <option value="${item.categoryId}">${item.name}</option>
                    </c:forEach>
                </select>
                <br/><br/>
                <input type="submit" value="Submit" />
        </form>
    </body>
</html>
