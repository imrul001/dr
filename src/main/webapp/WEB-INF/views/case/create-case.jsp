<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: bs197
  Date: 23/03/19
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Case Creation Page</title>
</head>
<body>
    <div class="container">
        <spring:url value="/do/create/case" var="url"/>
        <form:form class="form-horizontal myForm" action='${url}' method="post">
            <fieldset>

                <!-- Form Name -->
                <legend class="myFormHeader">Create Case</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="name">Patient Name</label>
                    <div class="col-md-4">
                        <input id="name" name="name" type="text" placeholder="Enter Patient NAME" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="name">Age</label>
                    <div class="col-md-4">
                        <input id="age" name="age" type="text" placeholder="Enter Patient's Age" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="gender">Gender</label>
                    <div class="col-md-4">
                        <select id="gender" name="gender" class="form-control">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="name">Subject</label>
                    <div class="col-md-4">
                        <input id="subject" name="subject" type="text" placeholder="Enter Patient NAME" class="form-control input-md" required="">

                    </div>
                </div>


                <!-- Textarea -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="">Case Description</label>
                    <div class="col-md-4">
                        <textarea class="form-control" id="" name="textContent" placeholder="Enter your case description"></textarea>
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="caseSubmit"></label>
                    <div class="col-md-4">
                        <button id="caseSubmit" type="submit" name="caseSubmit" class="btn btn-primary">Submit</button>
                    </div>
                </div>

            </fieldset>
        </form:form>

    </div>
</body>
</html>
