<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Imrul
  Date: 9/11/2017
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Page of the the Dr Application</title>
</head>
<body>
	<h1>Index Page of the the Dr Application</h1>
    <form:form commandName="clientDTO" action="/do/client/registration" method="post">
        Name: <form:input path="name"/> <br>
        Email: <form:input path="email"/> <br>
        Password: <form:input path="password"/> <br>
        Gender <form:checkbox path="gender" title="" value="1"/>
        <form:checkbox path="gender" title="" value="2"/><br>
        Date of Birth: <form:input path="dateOfBirth"/><br>
        <form:hidden path="active" value="1"/> <br>
        <form:button value="submit" name="submit"></form:button>
    </form:form>
</body>
</html>