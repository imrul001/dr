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
    <table id="caseHistoryTable" data-classes="table table-hover table-condensed"
           data-striped="true" data-sort-name="transactionDate"
           data-sort-order="desc"
           data-pagination="true"
           data-page-list="[5, 10, 25, 50, 100, ALL]"
           data-page-size="3">
        <thead>
        <tr>
            <th data-field="transactionDate" data-sortable="true">Date</th>
            <th data-field="fromAccount" data-sortable="true">From</th>
            <th data-field="toAccount" data-sortable="true">To</th>
            <th data-field="transactionAmount" data-sortable="true">Amount</th>
            <th data-field="transactionStatus" data-sortable="true">Status</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<script type="text/javascript">
    $(document).ready(function(){
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



