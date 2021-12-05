<%-- 
    Document   : input
    Created on : Dec 2, 2021, 6:55:06 PM
    Author     : Loki Kun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    </head>
    <body>
        <form action="display.jsp" method="GET">
            First Name: <input type="text" name="firstName" id="firstName" required/><br/>
            Last Name: <input type="text" name="lastName" id="lastName" required/><br/>
            Enter Password: <input type="text" name="password" id="password" required/><br/>
            Re-Enter Password: <input type="text" name="confirm_password" id ="confirm_password" required/><br/>
            <input type="submit" value="Display" />
<!--            <input type="" value="Clear"/>-->
            <span id='message'></span>
        </form>
        <script>
            $('#password, #confirm_password').on('keyup', function () {
            if ($('#password').val() == $('#confirm_password').val()) {
                $('#message').html('Matching').css('color', 'green');
            } else 
                $('#message').html('Not Matching').css('color', 'red');
            });
        </script>
    </body>
</html>
