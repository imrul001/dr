<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Imrul
  Date: 10/13/2017
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row-fluid">
        <form class="form-horizontal myLoginForm" method="post" action="/j_spring_security_check">
            <fieldset>

                <!-- Form Name -->
                <legend class="myFormHeader">User Login Form</legend>

                <!-- Text input-->

                <c:if test="${not empty param.error}">
                    <div class="form-group">
                        <p class="myErrorMsg">
                            <c:out value='${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}'></c:out>
                        </p>
                    </div>
                </c:if>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">User Email</label>
                    <div class="col-md-4">
                        <input id="textinput" name="j_username" type="text" placeholder="Enter your email" class="form-control input-md">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordinput">Password</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="j_password" type="password" placeholder="Enter your password" class="form-control input-md">

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton"></label>
                    <div class="col-md-4">
                        <button id="singlebutton" name="singlebutton" class="btn btn-primary">Login</button>
                    </div>
                </div>

            </fieldset>
            <p class="myFormFooterLink">
                Don't Have an Account? <a href="/userRegistration">Click Here to Register</a>
            </p>
        </form>
    </div>
</div>