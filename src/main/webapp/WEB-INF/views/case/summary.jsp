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
        <h2 class="section-header">Case Histories</h2>
    </div>
    <div class="row">
        <hr size="30">
    </div>
    <div class="row">
        <table id="caseHistoryTable" data-classes="table table-hover table-condensed"
               data-striped="true" data-sort-name="transactionDate"
               data-sort-order="desc"
               data-pagination="true"
               data-page-list="[5, 10, 25, 50, 100, ALL]"
               data-page-size="6">
            <thead class="mythead">
            <tr>
                <th data-field="clientId" data-sortable="true">Client ID</th>
                <th data-field="subject" data-sortable="true">Subject</th>
                <th data-field="caseHistoryId" data-sortable="true">Case History ID</th>
                <th data-field="initialDescription" data-sortable="true">Initial Description</th>
                <th data-field="detail" data-sortable="true">Detail</th>
                <th data-field="status" data-sortable="true">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="caseHistory" items="${cases}">
                <tr>
                    <td>${caseHistory.clientId}</td>
                    <td>${caseHistory.subject}</td>
                    <td>${caseHistory.caseHistoryId}</td>
                    <td>${caseHistory.conversationDTOList.get(0).textContent}</td>
                    <td><a href="/cases/history/detail/${caseHistory.caseHistoryId}">Detail</a></td>
                    <td>${caseHistory.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <hr size="30">
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
    })
</script>


<style>
    .fixed-table-loading{
        display : none;
    }
</style>
