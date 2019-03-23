<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/11/17
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="<c:url value="../../../css/bootstrap.table.css"></c:url>"/>
<script type="text/javascript" src="<c:url value="../../../js/bootstrap.table.js"></c:url>"></script>

<div class="container">
    <div class="row">
        <button type="button" id="caseCreatButton" class="btn btn-primary" href="/create/case">New Case</button>
    </div>
    <div class="row">
        <table id="caseHistoryTable" data-classes="table table-hover table-condensed"
               data-striped="true" data-sort-name="transactionDate"
               data-sort-order="desc"s
               data-pagination="true"
               data-page-list="[5, 10, 25, 50, 100, ALL]"
               data-page-size="3">
            <thead>
            <tr>
                <th data-field="clientId" data-sortable="true">Client ID</th>
                <th data-field="subject" data-sortable="true">Subject</th>
                <th data-field="caseHistoryId" data-sortable="true">Case History ID</th>
                <th data-field="status" data-sortable="true">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="caseHistory" items="${cases}">
                <tr>
                    <td>${caseHistory.clientId}</td>
                    <td>${caseHistory.subject}</td>
                    <td>${caseHistory.caseHistoryId}</td>
                    <td>${caseHistory.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#caseHistoryTable").bootstrapTable({
            onPageChange: function (number, size) {
                var targetOffset = $("#caseHistoryTable").offset().top - $('#freezedContent').outerHeight();
                $('html, body ').animate({
                    scrollTop: targetOffset
                }, 300);
            }
        });

        $("#caseCreatButton").on("click", function () {
            window.location.href = $(this).attr("href");
        })

    })
</script>


<style>
    .fixed-table-loading{
        display : none;
    }
</style>
