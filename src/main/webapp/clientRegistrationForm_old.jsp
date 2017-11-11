<%--
  Created by IntelliJ IDEA.
  User: Imrul
  Date: 9/15/2017
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/my.style.css"/>
    <script type="text/javascript" src="js/angular.min.js"></script>
    <script type="text/javascript">
        var drApp = angular.module("drApp", []);
        drApp.controller('clientRegFormController', function ($scope, $http) {
            drApp.config(['$httpProvider', function ($httpProvider) {
                $httpProvider.defaults.headers.post['Content-Type'] =
                    'application/x-www-form-urlencoded; charset=UTF-8';
            }]);

            $scope.checkValue = function(){
                alert($scope.gender)
            }
            $scope.submitForm = function () {
                var clientDTO = {
                    "name":$scope.name,
                    "email":$scope.email,
                    "password":$scope.password,
                    "dateOfBirth":$scope.dateOfBirth,
                    "gender":$scope.gender,
                    "active":$scope.active,
                };
                console.log("test")
                console.log(clientDTO)
                $http.post("/do/client/registration",JSON.stringify(clientDTO)).then(
                    function (data, response) {
                        if(data.data.error){
                            alert("error")
                        }else{
                            alert("successful");
                        }
                    },function(response){
                        alert("failed"+response);
                    });
            }
        })
    </script>
</head>
<body>
<div class="container" ng-app="drApp" ng-controller="clientRegFormController">
    <div class="row-fluid">
        <form class="form-horizontal myLoginForm">
            <fieldset>

                <!-- Form Name -->
                <legend class="myFormHeader">User Registration Form</legend>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="name">Name</label>
                    <div class="controls">
                        <input id="name" ng-model="name" name="name" type="text"
                               placeholder="Enter Your Name" class="input-xlarge" required="">
                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="email">Email</label>
                    <div class="controls">
                        <input id="email" name="email" ng-model="email" type="text" placeholder="Enter Your Email"
                               class="input-xlarge" required="">

                    </div>
                </div>

                <!-- Password input-->
                <div class="control-group">
                    <label class="control-label" for="password">Password</label>
                    <div class="controls">
                        <input id="password" name="password" ng-model="password" type="password"
                               placeholder="Enter Your Password" class="input-xlarge" required="">

                    </div>
                </div>

                <!-- Password input-->
                <div class="control-group">
                    <label class="control-label" for="cpassword">Confirm Password</label>
                    <div class="controls">
                        <input id="cpassword" name="cpassword" ng-model="cpassword" type="password"
                               placeholder="Rewrite you password" class="input-xlarge" required="">

                    </div>
                </div>

                <!-- Multiple Radios -->
                <div class="control-group">
                    <label class="control-label" for="gender">Gender</label>
                    <div class="controls">
                        <label class="radio" for="gender-0">
                            <input type="radio" ng-model="gender" name="gender" id="gender-0" value="1"
                                   checked="checked">
                            Male
                        </label>
                        <label class="radio" for="gender-1">
                            <input type="radio" ng-model="gender" name="gender" id="gender-1" value="2">
                            Female
                        </label>
                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="dateOfBirth">Date of Birth</label>
                    <div class="controls">
                        <input id="dateOfBirth" ng-model="dateOfBirth" name="dateOfBirth" type="text"
                               placeholder="Select Date" class="input-xlarge" required="">
                    </div>
                </div>

                <div class="control-group">
                    <input type="hidden" ng-model="active" name="active" value="1">
                </div>

                <!-- Button -->
                <div class="control-group">
                    <label class="control-label" for="submit"></label>
                    <div class="controls">
                        <button id="submit" ng-click="submitForm()" name="submit" class="btn btn-primary">Sign Up</button>
                    </div>
                </div>
            </fieldset>
            <p class="myFormFooterLink">
                Already Have an Account? <a href="/db/webapp">Click Here to Login</a>
            </p>
        </form>
    </div>
</div>
</body>
</html>
