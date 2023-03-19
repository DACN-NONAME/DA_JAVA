<%-- 
    Document   : test
    Created on : Feb 21, 2023, 2:22:03 PM
    Author     : phatv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="refresh" content="3;url=<c:url value="/" />" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thông báo!</h1>
        <p>${msg}</p>
    </body>
</html>
