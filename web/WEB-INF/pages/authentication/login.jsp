<%-- 
    Document   : login
    Created on : Feb 23, 2023, 8:46:30 AM
    Author     : daing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plant Shop Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="input" action="login.do" method="post">
            <table>
                <tr>
                    <td>email:</td><td><input type="text" name="email" required/></td>
                </tr>
                <tr>
                    <td>Password:</td><td><input type="password" name="password" required/></td>
                </tr>
                <tr>
                    <td></td><td><input type="checkbox" name="rememberMe"/>Remember Me</td>
                </tr>
                <tr>
                    <td></td><td><button type="submit">Login</button></td>
                </tr>
            </table>
            <a href="register.do">Or sign up</a>
<<<<<<< HEAD
            <p>${message}</p>
=======
>>>>>>> 9b24420 (resolve conflict)
        </form>
    </body>
</html>