<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/11/17
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Doctor App.</title>
    <link rel="stylesheet" href= "<c:url value="../../../css/bootstrap.min1.css"></c:url>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="../../../css/my.style.css"></c:url>" type="text/css"/>
</head>
<body>

<%--<tiles:insertAttribute name="header"/>--%>

<%--main content--%>
<tiles:insertAttribute name="content"/>

<%--footer--%>
<%--<tiles:insertAttribute name="footer"/>--%>

</body>
</html>