<%-- 
    Document   : display
    Created on : Dec 2, 2021, 7:11:56 PM
    Author     : Loki Kun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie firstName = new Cookie("firstName", request.getParameter("firstName"));
            Cookie lastName = new Cookie("lastName", request.getParameter("lastName"));
            Cookie password = new Cookie("password", request.getParameter("password"));
            
            firstName.setMaxAge(60*60*10);
            lastName.setMaxAge(60*60*10);
            password.setMaxAge(60*60*10);
            
            response.addCookie(firstName);
            response.addCookie(lastName);
            response.addCookie(password);
        %>
        <b>First Name</b>
            <%= request.getParameter("firstName")%>
        <b>Last Name</b>
            <%= request.getParameter("lastName")%>
        <b>Password</b>
            <%= request.getParameter("password")%>
    </body>
</html>
