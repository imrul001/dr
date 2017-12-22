<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 12/22/17
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#featureId").append(
                "<option value='-1'>--Select a Feature--</option>" +
                "<option value='100'>Within Bank Fund Transfer</option>" +
                "<option value='300'>Other Bank Fund Transfer</option>" +
                "<option value='200'>Own Bank Fund Transfer</option>"
            )
            $("#accountNumber").append(
                "<option value='-1'>--Select a Feature--</option>" +
                "<option value='40012021'>40012021</option>" +
                "<option value='40032038'>40032038</option>" +
                "<option value='40042391'>40042391</option>"
            )
            var validator = $("#testFormDto").validate({
                rules: {
                    ruleName: {
                        required: true,
                        minlength: 3
                    },
                    featureId: {
                        notNullInput: true
                    },
                    accountNumber: {
                        notNullInput: true
                    }
                },
                messages: {
                    ruleName: {
                        required: "This field is needed",
                        minlength: "Min Length is 3"
                    },
                    featureId: {
                        notNullInput: "Please select valid feature"
                    },
                    accountNumber: {
                        notNullInput: "Please select valid Account Number"
                    }
                },
                invalidHandler: function (event, validator) {
                    $(this).find("[type='submit']").removeAttr('disabled');
                },
                submitHandler: function (form) {
                    form.submit();
                }
            })

            jQuery.validator.addMethod('notNullInput', function (value, elem) {
                console.log(value);
                if (value != '-1') {
                    return true
                } else {
                    return false;
                }
            })
        })
    </script>
</head>
<body>
<h1>This is my test form</h1>
<form:form commandName="testFormDto" method="post">
    <div class="form-control">
        <label>Rule Name:</label>
        <form:input path="ruleName"/>
    </div>
    <div class="form-control">
        <label>Feature:</label>
        <form:select path="featureId">
        </form:select>
    </div>
    <div class="form-control">
        <label>Account Number:</label>
        <form:select path="accountNumber">
        </form:select>
    </div>
    <div class="form-control">
        <input type="submit" value="submit"/>
    </div>
</form:form>
</body>
</html>
