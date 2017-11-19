<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/19/17
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href= "<c:url value="../../../css/topmenuCSS.css"></c:url>" type="text/css"/>
<div class="row" style="margin-left: 0;">
    <div class="menu">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#">My Doctor</a>
            </div>
            <div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/userRegistration" ><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
