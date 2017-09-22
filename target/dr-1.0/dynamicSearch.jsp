<%--
  Created by IntelliJ IDEA.
  User: Imrul
  Date: 9/22/2017
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dynamic Search Page</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap.table.css"/>
    <link rel="stylesheet" href="css/simple.toast.css"/>
    <script type="text/javascript" src="js/bootstrap.table.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="js/simple.toast.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="columns four">
        </div>
        <div class="columns two" style="margin-right:4px">
            <label for="fdatepicker">From Date:</label>
        </div>
        <div class="columns two">
            <label for="tdatepicker">To Date:</label>
        </div>
        <div class="columns three">
            <label for="transactiontype">Transacation Type:</label>
        </div>
        <div class="columns two">
            <label for="status">Status:</label>
        </div>
        <div class="columns two"></div>
    </div>
    <div class="row" style="margin-bottom: 7px;">
        <div class="columns four">
        </div>
        <div class="columns two" style="margin-top:5px; padding-right: 0px;">
            <input type="text" id="fdatepicker" class="form-control" readonly>
        </div>
        <div class="columns two" style="margin-top:5px; padding-right: 0px;">
            <input type="text" id="tdatepicker" class="form-control" readonly>
        </div>
        <div class="columns three" style="margin-top:5px; padding-right: 0px;">
            <select style="font-size: 13px;" id="transactiontype" class="form-control">
                <option value="0">-Select-</option>
                <%--<c:forEach var="transactionType" items="${transactionTypes}" varStatus="index">--%>
                    <%--<option value="${transactionType.key}">${transactionType.value}</option>--%>
                <%--</c:forEach>--%>
                <option value="1">-Fund Transfer-</option>
                <option value="2">-Mobile-</option>
                <option value="3">-Tution Fee-</option>
            </select>
        </div>
        <div class="columns two" style="margin-top:5px; padding-right: 0px;">
            <select style="font-size: 13px;" id="status" class="form-control">
                <option value="0">All</option>
                <option value="1">Success</option>
                <option value="2">Fail</option>
            </select>
        </div>
        <div class="columns two" style="float:left;margin-right:4px;margin-left: 17px;">
            <button class="btn btn-abbl" id="searchButton" value="Search">Search</button>
        </div>
    </div>

    <div class="row">
        <span id="ownmsg" class="text-center"></span>
    </div>
    <table style="display: none" id="siFundTransferHistoryTable" data-classes="table table-hover table-condensed"
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

    <table style="display: none" id="SiMobileHistoryTable" data-classes="table table-hover table-condensed"
           data-striped="true" data-sort-name="transactionDate"
           data-sort-order="desc"
           data-pagination="true">
        <thead>
        <tr>
            <th data-field="transactionDate" data-sortable="true">Date</th>
            <th data-field="fromAccount" data-sortable="true">From</th>
            <th data-field="toPhoneNo" data-sortable="true">To</th>
            <th data-field="connectionType" data-sortable="true">Connection Type</th>
            <th data-field="transactionAmount" data-sortable="true">Amount</th>
            <th data-field="transactionStatus" data-sortable="true">Status</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>

    <table style="display: none" id="SiTutionFeeHistoryTable" data-classes="table table-hover table-condensed"
           data-striped="true" data-sort-name="transactionDate"
           data-sort-order="desc"
           data-pagination="true">
        <thead>
        <tr>
            <th data-field="transactionDate" data-sortable="true">Date</th>
            <th data-field="fromAccount" data-sortable="true">From</th>
            <th data-field="studentName" data-sortable="true">Student Name</th>
            <th data-field="MonthofTransaction" data-sortable="true">Month</th>
            <th data-field="transactionRef" data-sortable="true">Tx Reference Number</th>
            <th data-field="transactionAmount" data-sortable="true">Amount</th>
            <th data-field="transactionStatus" data-sortable="true">Status</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>


</div>
</body>
</html>

<script type="text/javascript">
    var ownmsg;
    function loadbootStrapTableSetUp(tableID) {
        $(tableID).bootstrapTable({
            onPageChange: function (number, size) {
                var targetOffset = $(tableID).offset().top - $('#freezedContent').outerHeight();
                $('html, body ').animate({
                    scrollTop: targetOffset
                }, 300);
            }
        });
    }
    function populateAppropriateTable(showID, hideID1, hideID2) {
        loadbootStrapTableSetUp(showID);
        $(showID).show();
        $(hideID1).hide();
        $(hideID2).hide();
        $(hideID1).bootstrapTable('removeAll');
        $(hideID2).bootstrapTable('removeAll');
    }


    $(document).ready(function () {
        var siHistoryDate = new Date();
        siHistoryDate.setDate(1);
        $("#fdatepicker").datepicker({
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            yearRange: "-100:+0",
            maxDate: "0D",
            defaultDate: siHistoryDate
        });
        $("#tdatepicker").datepicker({
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            yearRange: "-100:+0",
            maxDate: "0D",
            defaultDate: new Date()
        });
        $("#fdatepicker").val($.datepicker.formatDate("dd/mm/yy", siHistoryDate));
        $("#tdatepicker").val($.datepicker.formatDate("dd/mm/yy", new Date()));

        $('#searchButton').click(function () {
            var transactionType = $("#transactiontype").val();
            var url = null;
            var historyTableID = null;
            if(transactionType == 1){
                populateAppropriateTable('#siFundTransferHistoryTable', '#SiMobileHistoryTable', '#SiTutionFeeHistoryTable')
                url = "/get/fundtransfer/si/history";
                historyTableID = '#siFundTransferHistoryTable';
            }
            if(transactionType == 2){
                populateAppropriateTable('#SiMobileHistoryTable', '#siFundTransferHistoryTable','#SiTutionFeeHistoryTable')
                url = "/get/mobileRecharge/si/history";
                historyTableID = '#SiMobileHistoryTable';
            }
            if(transactionType == 3){
                populateAppropriateTable('#SiTutionFeeHistoryTable','#SiMobileHistoryTable', '#siFundTransferHistoryTable')
                url = "/get/tuitionFee/si/history";
                historyTableID = '#SiTutionFeeHistoryTable';
            }
            var fromDate = $('#fdatepicker').val();
            var toDate = $('#tdatepicker').val();
            if(fromDate!= null && toDate!=null){
                loadOwnActData(fromDate, toDate, historyTableID, transactionType, url);
            }
        });
    });

    var loadOwnActData = function (fromDate, toDate, tableId, transactionType, dataurl) {
        $('.page-loader').show();
        var status = $('#status').val();
        $.ajax({
            url: dataurl,
            type: 'GET',
            data: 'fromDate=' + fromDate + '&toDate=' + toDate + '&status=' + status,
            success: function (resp) {
                $(tableId).bootstrapTable('removeAll');
                if (resp.error) {
                    ownmsg = $.simplyToast(resp.error, 'danger', {
                        appendTo: '#ownmsg',
                        align: 'center',
                        delay: 400,
                        offset: {from: 'top', amount: 70}
                    });
                } else {
                    if (resp.ownActData) {
                        $(tableId).bootstrapTable('load', resp.ownActData);
//                        $('tr td:nth-child(4)').css("text-align", "right");
                    }
                    if (ownmsg) {
                        $.simplyToast.remove(ownmsg);
                    }
                }
            },
            error: function (jqxhr, textStatus, error) {
                if (jqxhr.status != 901) {
                    var err = textStatus + ", " + error;
                    ownmsg = $.simplyToast(err, 'danger', {
                        appendTo: '#ownmsg',
                        align: 'center',
                        delay: -1,
                        offset: {from: 'top', amount: 70}
                    });
                }
                $('.page-loader').hide();
                $(tableId).bootstrapTable('removeAll');
            },
            complete: function () {
                $('.page-loader').hide();
            }
        });
    };


</script>
<style>
    .fixed-table-loading{
        display : none;
    }

</style>