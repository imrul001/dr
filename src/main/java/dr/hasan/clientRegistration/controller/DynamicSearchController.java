package dr.hasan.clientRegistration.controller;

import dr.hasan.clientRegistration.viewmodel.FundTransferSIHistoryItem;
import dr.hasan.clientRegistration.viewmodel.MobileRechargeSiHistoryItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Imrul on 9/22/2017.
 */

@Controller
public class DynamicSearchController {

    @RequestMapping(value= "/get/fundtransfer/si/history", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSiFundTransferHistory(@RequestParam("fromDate") String fromDate,
                                                       @RequestParam("toDate") String toDate,
                                                       @RequestParam("status") int status){
        Map<String, Object> resp = new HashMap<String, Object>();
        List<FundTransferSIHistoryItem> items = new ArrayList<FundTransferSIHistoryItem>();
        FundTransferSIHistoryItem fundTransferSIHistoryItem1 = new FundTransferSIHistoryItem();
        fundTransferSIHistoryItem1.setFromAccount("12345678");
        fundTransferSIHistoryItem1.setToAccount("87654321");
        fundTransferSIHistoryItem1.setTransactionAmount("10");
        fundTransferSIHistoryItem1.setTransactionDate("01/10/2017");
        fundTransferSIHistoryItem1.setTransactionStatus("Success");
        items.add(fundTransferSIHistoryItem1);

        FundTransferSIHistoryItem fundTransferSIHistoryItem2 = new FundTransferSIHistoryItem();
        fundTransferSIHistoryItem2.setFromAccount("123456789");
        fundTransferSIHistoryItem2.setToAccount("987654321");
        fundTransferSIHistoryItem2.setTransactionAmount("20");
        fundTransferSIHistoryItem2.setTransactionDate("01/11/2017");
        fundTransferSIHistoryItem2.setTransactionStatus("Failed");
        items.add(fundTransferSIHistoryItem2);

        FundTransferSIHistoryItem fundTransferSIHistoryItem3 = new FundTransferSIHistoryItem();
        fundTransferSIHistoryItem3.setFromAccount("123456789");
        fundTransferSIHistoryItem3.setToAccount("987654321");
        fundTransferSIHistoryItem3.setTransactionAmount("20");
        fundTransferSIHistoryItem3.setTransactionDate("01/11/2017");
        fundTransferSIHistoryItem3.setTransactionStatus("Failed");
        items.add(fundTransferSIHistoryItem3);

        FundTransferSIHistoryItem fundTransferSIHistoryItem4 = new FundTransferSIHistoryItem();
        fundTransferSIHistoryItem4.setFromAccount("123456789");
        fundTransferSIHistoryItem4.setToAccount("987654321");
        fundTransferSIHistoryItem4.setTransactionAmount("20");
        fundTransferSIHistoryItem4.setTransactionDate("01/11/2017");
        fundTransferSIHistoryItem4.setTransactionStatus("Failed");
        items.add(fundTransferSIHistoryItem4);

        FundTransferSIHistoryItem fundTransferSIHistoryItem5 = new FundTransferSIHistoryItem();
        fundTransferSIHistoryItem5.setFromAccount("123456789");
        fundTransferSIHistoryItem5.setToAccount("987654321");
        fundTransferSIHistoryItem5.setTransactionAmount("20");
        fundTransferSIHistoryItem5.setTransactionDate("01/11/2017");
        fundTransferSIHistoryItem5.setTransactionStatus("Failed");
        items.add(fundTransferSIHistoryItem5);

        FundTransferSIHistoryItem fundTransferSIHistoryItem6 = new FundTransferSIHistoryItem();
        fundTransferSIHistoryItem6.setFromAccount("123456789");
        fundTransferSIHistoryItem6.setToAccount("987654321");
        fundTransferSIHistoryItem6.setTransactionAmount("20");
        fundTransferSIHistoryItem6.setTransactionDate("01/11/2017");
        fundTransferSIHistoryItem6.setTransactionStatus("Failed");
        items.add(fundTransferSIHistoryItem6);

        FundTransferSIHistoryItem fundTransferSIHistoryItem7 = new FundTransferSIHistoryItem();
        fundTransferSIHistoryItem7.setFromAccount("123456789");
        fundTransferSIHistoryItem7.setToAccount("987654321");
        fundTransferSIHistoryItem7.setTransactionAmount("20");
        fundTransferSIHistoryItem7.setTransactionDate("01/11/2017");
        fundTransferSIHistoryItem7.setTransactionStatus("Failed");
        items.add(fundTransferSIHistoryItem7);

        resp.put("ownActData", items);
        resp.put("error", "ami tomare chini na");
        return resp;
    }

    @RequestMapping(value= "/get/mobileRecharge/si/history", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSiMobileRechargeHistory(@RequestParam("fromDate") String fromDate,
                                                        @RequestParam("toDate") String toDate,
                                                        @RequestParam("status") int status){
        Map<String, Object> resp = new HashMap<String, Object>();
        List<MobileRechargeSiHistoryItem> items = new ArrayList<MobileRechargeSiHistoryItem>();
        MobileRechargeSiHistoryItem mobileRechargeSiHistoryItem1 = new MobileRechargeSiHistoryItem();
        mobileRechargeSiHistoryItem1.setConnectionType("Prepaid");
        mobileRechargeSiHistoryItem1.setFromAccount("12345678");
        mobileRechargeSiHistoryItem1.setToPhoneNo("01717815224");
        mobileRechargeSiHistoryItem1.setTransactionAmount("50");
        mobileRechargeSiHistoryItem1.setTransactionStatus("Success");
        mobileRechargeSiHistoryItem1.setTransactionDate("01/070/2017");

        items.add(mobileRechargeSiHistoryItem1);
        MobileRechargeSiHistoryItem mobileRechargeSiHistoryItem2 = new MobileRechargeSiHistoryItem();
        mobileRechargeSiHistoryItem2.setConnectionType("Prepaid");
        mobileRechargeSiHistoryItem2.setFromAccount("12345678");
        mobileRechargeSiHistoryItem2.setToPhoneNo("01717815224");
        mobileRechargeSiHistoryItem2.setTransactionAmount("50");
        mobileRechargeSiHistoryItem2.setTransactionStatus("Success");
        mobileRechargeSiHistoryItem2.setTransactionDate("03/070/2017");
        items.add(mobileRechargeSiHistoryItem2);

        MobileRechargeSiHistoryItem mobileRechargeSiHistoryItem3 = new MobileRechargeSiHistoryItem();
        mobileRechargeSiHistoryItem3.setConnectionType("Prepaid");
        mobileRechargeSiHistoryItem3.setFromAccount("12345678");
        mobileRechargeSiHistoryItem3.setToPhoneNo("01712815224");
        mobileRechargeSiHistoryItem3.setTransactionAmount("150");
        mobileRechargeSiHistoryItem3.setTransactionStatus("Failed");
        mobileRechargeSiHistoryItem3.setTransactionDate("02/07/2017");
        items.add(mobileRechargeSiHistoryItem3);

        resp.put("ownActData", items);
        return resp;
    }



}
