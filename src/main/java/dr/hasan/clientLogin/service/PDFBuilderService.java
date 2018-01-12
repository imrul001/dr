package dr.hasan.clientLogin.service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import dr.hasan.clientLogin.modelforpdf.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PDFBuilderService {


    public byte[] buildPdf() {
        byte[] pdfByteArray = new byte[100000];
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {


            OrganizationRegistrationDTO organizationRegistrationDTO = getLoadedDTO();
            OrganizationTemp organizationTemp = organizationRegistrationDTO.getOrganizationTemp();

            Image img = Image.getInstance("/home/ihasan/programming/projects/dr/src/main/resources/images/download.png");
            PdfWriter.getInstance(document, outputStream);
            document.open();
            img.scaleAbsoluteHeight(40);
            img.scaleAbsoluteWidth(200);
            document.add(img);



            Font titlefont = FontFactory.getFont(FontFactory.COURIER_BOLD, 15, BaseColor.BLACK);
            Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 11, BaseColor.BLACK);
            Paragraph singleLineBreak = new Paragraph("\n", font);
            Paragraph twoNewLineBreak = new Paragraph("\n\n", font);
            document.add(singleLineBreak);
            Chunk chunk = new Chunk("Organization Registration (Corporate Banking)", titlefont);
            document.add(chunk);
            document.add(singleLineBreak);

            LineSeparator separator = new LineSeparator();
            document.add(separator);
            document.add(singleLineBreak);


            Chunk headerOfOrganizationTable = new Chunk("1. Organization:", font);
            document.add(headerOfOrganizationTable);
            PdfPTable organizationTable = new PdfPTable(4);
            organizationTable.setWidthPercentage(100);
            String[] organizationHeaders = {"Name", "Corporate id", "Email Address", "Business Type"};
            addTableHeader(organizationTable, organizationHeaders);
            addRows(organizationTable, organizationTemp);
            document.add(organizationTable);


            List<OrganizationContactTemp> organizationContactTemps = organizationTemp.getContactTemps();
            document.add(singleLineBreak);
            Chunk headerOfContactPersonTable = new Chunk("1.1 Contact Persons:", font);
            document.add(headerOfContactPersonTable);
            PdfPTable contactPersonsTable = new PdfPTable(5);
            contactPersonsTable.setWidthPercentage(100);
            String[] contactHeaders = {"#", "Name", "Designation", "Mobile", "Email"};
            addTableHeader(contactPersonsTable, contactHeaders);
            addContactPersons(contactPersonsTable, organizationContactTemps);
            document.add(contactPersonsTable);



            OrganizationAccountBatch organizationAccountBatch = organizationRegistrationDTO.getOrganizationAccountBatch();
            document.add(twoNewLineBreak);
            Chunk headerOfAccountsTable = new Chunk("2. Accounts:", font);
            document.add(headerOfAccountsTable);
            PdfPTable accountsTable = new PdfPTable(5);
            accountsTable.setWidthPercentage(100);
            String[] accountHeaders = {"#", "Account Name", "Account Number", "Account Type", "Features"};
            addTableHeader(accountsTable, accountHeaders);
            addAccounts(accountsTable, organizationAccountBatch.getAccountTempList());
            document.add(accountsTable);


            List<DesignationTemp> designationTemps = organizationRegistrationDTO.getDesignationTemps();
            document.add(twoNewLineBreak);
            Chunk headerOfDesignationsTable = new Chunk("3. Designations:", font);
            document.add(headerOfDesignationsTable);
            PdfPTable designationsTable = new PdfPTable(4);
            String[] designationHeaders = {"#", "Designation Name", "Rank", "Menu Access"};
            designationsTable.setWidthPercentage(100);
            addTableHeader(designationsTable, designationHeaders);
            addDesignations(designationsTable, designationTemps);
            document.add(designationsTable);


            List<CorporateUserTemp> corporateUserTemps = organizationRegistrationDTO.getCorporateUserTemp();
            document.add(twoNewLineBreak);
            Chunk headerOfCorporateUserTable = new Chunk("4. Corporate User:\n", font);
            document.add(headerOfCorporateUserTable);
            PdfPTable userTable = new PdfPTable(6);
            userTable.setWidthPercentage(100);
            String[] userHeaders = {"#", "UserID", "Name", "Email", "Designations", "Accounts"};
            addTableHeader(userTable, userHeaders);
            addCorporateUser(userTable, corporateUserTemps);
            document.add(userTable);

            DottedLineSeparator lineSeparator = new DottedLineSeparator();


            List<WorkflowRuleMasterTemp> workflowRuleMasterTemps = organizationRegistrationDTO.getWorkflowRuleMasterTemps();
            document.add(twoNewLineBreak);
            Chunk headerOfWorkflowTable = new Chunk("5. Workflow:\n", font);
            document.add(headerOfWorkflowTable);
            document.add(singleLineBreak);
            document.add(separator);
            Font workflowRuleMasterFont = FontFactory.getFont(FontFactory.COURIER, 11, BaseColor.BLACK);
            for(WorkflowRuleMasterTemp workflowRuleMasterTemp : workflowRuleMasterTemps){
                Chunk WorkflowMasterDetails = new Chunk("Feature: "+workflowRuleMasterTemp.getName()+"\n" +
                        "Account Number: "+workflowRuleMasterTemp.getAccountNumber()+"\n" +
                        "Amount: "+workflowRuleMasterTemp.getRule(), workflowRuleMasterFont);
                document.add(WorkflowMasterDetails);
                if(workflowRuleMasterTemp.getWorkflowRuleDetailsTempList()!= null){
                    PdfPTable pdfPTable = new PdfPTable(4);
                    pdfPTable.setWidthPercentage(100);
                    String[] workflowDetailsHeader = {"#", "Designation", "Number of Authorizer", "Notification Order"};
                    addTableHeader(pdfPTable, workflowDetailsHeader);
                    addWorkflowDetails(pdfPTable, workflowRuleMasterTemp.getWorkflowRuleDetailsTempList());
                    document.add(pdfPTable);
                    document.add(singleLineBreak);
                    document.add(lineSeparator);
                    document.add(twoNewLineBreak);
                }

            }
            document.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    private void addTableHeader(PdfPTable table, String[] headers) {
        Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, BaseColor.BLACK);
        for(int i = 0; i < headers.length; i++){
            PdfPCell header = new PdfPCell(new Phrase(headers[i], font));
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(1);
            table.addCell(header);
        }
    }


    private void addRows(PdfPTable table, OrganizationTemp organizationTemp) {

        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
        table.addCell(new PdfPCell(new Phrase(organizationTemp.getName(),font)));
        table.addCell(new PdfPCell(new Phrase(organizationTemp.getCorporateId(),font)));
        table.addCell(new PdfPCell(new Phrase(organizationTemp.getEmail(),font)));
        table.addCell(new PdfPCell(new Phrase(organizationTemp.getBusinessType(),font)));

    }

    private void addContactPersons(PdfPTable pTable, List<OrganizationContactTemp> contactTemps){
        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
        if(contactTemps!=null){
            long count = 1;
            for(OrganizationContactTemp contactTemp : contactTemps){
                pTable.addCell(new PdfPCell(new Phrase(String.valueOf(count),font)));
                pTable.addCell(new PdfPCell(new Phrase(contactTemp.getName(),font)));
                pTable.addCell(new PdfPCell(new Phrase(contactTemp.getDesignation(),font)));
                pTable.addCell(new PdfPCell(new Phrase(contactTemp.getMobileNo(),font)));
                pTable.addCell(new PdfPCell(new Phrase(contactTemp.getEmail(),font)));
                count++;
            }
        }
    }


    private void addAccounts(PdfPTable pTable, List<OrganizationAccountTemp> organizationAccountTemps){
        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
        if(organizationAccountTemps!=null){
            long count = 1;
            for(OrganizationAccountTemp accountTemp : organizationAccountTemps){
                pTable.addCell(new PdfPCell(new Phrase(String.valueOf(count),font)));
                pTable.addCell(new PdfPCell(new Phrase(accountTemp.getAccountName(),font)));
                pTable.addCell(new PdfPCell(new Phrase(accountTemp.getAccountNumber(),font)));
                pTable.addCell(new PdfPCell(new Phrase(accountTemp.getAccountType(),font)));
                pTable.addCell(new PdfPCell(new Phrase(getFeatures(accountTemp.getPrivilegeFeatureItems()),font)));
                count++;
            }
        }
    }

    private String getFeatures(List<FeatureItem> featureItems){
        String features = "";
        int i = 1;
        for(FeatureItem featureItem : featureItems){
            if(i == featureItems.size()){
                features = features + featureItem.getName();
            }else{
                features = features + featureItem.getName()+", ";

            }
            i++;
        }
        return features;
    }

    private void addCorporateUser(PdfPTable pTable, List<CorporateUserTemp> userTemps){
        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
        int count = 1;
        if(userTemps!= null){
            for(CorporateUserTemp corporateUserTemp : userTemps){
                pTable.addCell(new PdfPCell(new Phrase(String.valueOf(count),font)));
                pTable.addCell(new PdfPCell(new Phrase(corporateUserTemp.getCustomerUserName(),font)));
                pTable.addCell(new PdfPCell(new Phrase(corporateUserTemp.getName(),font)));
                pTable.addCell(new PdfPCell(new Phrase(corporateUserTemp.getEmail(),font)));
                pTable.addCell(new PdfPCell(new Phrase(getDesignations(corporateUserTemp.getDesignation()),font)));
                pTable.addCell(new PdfPCell(new Phrase(getAccounts(corporateUserTemp.getAccessibleAccounts()),font)));
                count++;
            }
        }
    }

    private String getDesignations(List<DesignationTemp> designationTemps){
        String designations = "";
        int i = 1;
        for(DesignationTemp designationTemp : designationTemps){
            if(i == designationTemps.size()){
                designations = designations + designationTemp.getName();
            }else{
                designations = designations + designationTemp.getName()+", ";

            }
            i++;
        }
        return designations;
    }

    private String getAccounts(List<OrganizationAccountTemp> accountTemps){
        String accounts = "";
        int i = 1;
        for(OrganizationAccountTemp accountTemp : accountTemps){
            if(i == accountTemps.size()){
                accounts = accounts + accountTemp.getAccountNumber();
            }else{
                accounts = accounts + accountTemp.getAccountNumber()+", ";
            }
            i++;
        }
        return accounts;
    }

    private void addDesignations(PdfPTable pTable, List<DesignationTemp> designationTemps){
        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
        int count = 1;
        if(designationTemps!=null){
            for(DesignationTemp designationTemp : designationTemps){
                pTable.addCell(new PdfPCell(new Phrase(String.valueOf(count),font)));
                pTable.addCell(new PdfPCell(new Phrase(designationTemp.getName(),font)));
                pTable.addCell(new PdfPCell(new Phrase(String.valueOf(designationTemp.getRank()),font)));
                pTable.addCell(new PdfPCell(new Phrase(getMenus(designationTemp.getMenuEntityList()),font)));
                count++;
            }
        }
    }

    private String getMenus(List<CustomerMenuEntity> menuEntities){
        String menus = "";
        int i = 1;
        for(CustomerMenuEntity customerMenuEntity : menuEntities){
            if(i == menuEntities.size()){
                menus = menus + customerMenuEntity.getMenuText();
            }else{
                menus = menus + customerMenuEntity.getMenuText()+", ";
            }
            i++;
        }
        return menus;
    }

    private void addWorkflowDetails(PdfPTable pTable, List<WorkflowRuleDetailsTemp> workflowRuleDetailsTemps){
        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
        int count = 1;
        for(WorkflowRuleDetailsTemp detailsTemp : workflowRuleDetailsTemps){
            pTable.addCell(new PdfPCell(new Phrase(String.valueOf(count),font)));
            pTable.addCell(new PdfPCell(new Phrase(String.valueOf(detailsTemp.getDesignationId()),font)));
            pTable.addCell(new PdfPCell(new Phrase(String.valueOf(detailsTemp.getNumberOfResponder()),font)));
            pTable.addCell(new PdfPCell(new Phrase(String.valueOf(detailsTemp.getNotificationOrder()),font)));
            count++;
        }
    }




    public OrganizationRegistrationDTO getLoadedDTO(){
        OrganizationRegistrationDTO organizationRegistrationDTO = new OrganizationRegistrationDTO();

        // organization data
        OrganizationTemp organizationTemp = new OrganizationTemp();
        organizationTemp.setName("Brain Station 23");
        organizationTemp.setBusinessType("Software Company");
        organizationTemp.setEmail("bs@gmail.com");
        organizationTemp.setCorporateId("bs-23");

        // organization contact data
        OrganizationContactTemp organizationContactTemp1 = new OrganizationContactTemp();
        organizationContactTemp1.setDesignation("Managing Director");
        organizationContactTemp1.setName("Test Contact Person1");
        organizationContactTemp1.setEmail("Test1@gmail.com");
        organizationContactTemp1.setMobileNo("01712207954");
        OrganizationContactTemp organizationContactTemp2 = new OrganizationContactTemp();
        organizationContactTemp2.setDesignation("CTO");
        organizationContactTemp2.setName("Test Contact Person2");
        organizationContactTemp2.setEmail("Test2@gmail.com");
        organizationContactTemp2.setMobileNo("01671319014");
        List<OrganizationContactTemp> tempList = new ArrayList<>();
        tempList.add(organizationContactTemp1);
        tempList.add(organizationContactTemp2);

        organizationTemp.setContactTemps(tempList);

        // featureItem data

        List<FeatureItem> featureItems1 = new ArrayList<>();
        FeatureItem featureItem1 = new FeatureItem();
        featureItem1.setId(1);
        featureItem1.setName("Other Bank Fund Transfer");

        FeatureItem featureItem2 = new FeatureItem();
        featureItem2.setId(2);
        featureItem2.setName("AB Bank Fund Transfer");

        FeatureItem featureItem3 = new FeatureItem();
        featureItem3.setId(3);
        featureItem3.setName("Bulk Payment");

        featureItems1.add(featureItem1);
        featureItems1.add(featureItem3);

        List<FeatureItem> featureItems2 = new ArrayList<>();
        featureItems2.add(featureItem2);
        featureItems2.add(featureItem3);

        // Organization batch

        OrganizationAccountBatch organizationAccountBatch = new OrganizationAccountBatch();

        // Organization account temp data

        OrganizationAccountTemp accountTemp1 = new OrganizationAccountTemp();
        accountTemp1.setAccountName("test account name1");
        accountTemp1.setAccountNumber("1234673847373");
        accountTemp1.setAccountType("LL");
        accountTemp1.setPrivilegeFeatureItems(featureItems2);
        OrganizationAccountTemp accountTemp2 = new OrganizationAccountTemp();
        accountTemp2.setAccountName("test account name2");
        accountTemp2.setAccountNumber("4049090876578909");
        accountTemp2.setAccountType("LD");
        accountTemp2.setPrivilegeFeatureItems(featureItems1);
        List<OrganizationAccountTemp> accountTemps = new ArrayList<>();
        accountTemps.add(accountTemp1);
        accountTemps.add(accountTemp2);
        organizationAccountBatch.setAccountTempList(accountTemps);


        // CustomerMenuEntity

        List<CustomerMenuEntity> customerMenuEntities1 = new ArrayList<>();

        CustomerMenuEntity customerMenuEntity1 = new CustomerMenuEntity();
        customerMenuEntity1.setFeatureItemId(1);
        customerMenuEntity1.setMenuText("Other Bank Fund Transfer");

        CustomerMenuEntity customerMenuEntity2 = new CustomerMenuEntity();
        customerMenuEntity2.setFeatureItemId(2);
        customerMenuEntity2.setMenuText("AB Bank Fund Transfer");

        CustomerMenuEntity customerMenuEntity3 = new CustomerMenuEntity();
        customerMenuEntity3.setFeatureItemId(3);
        customerMenuEntity3.setMenuText("Bulk Payment");

        customerMenuEntities1.add(customerMenuEntity1);
        customerMenuEntities1.add(customerMenuEntity2);
        customerMenuEntities1.add(customerMenuEntity3);

        // Designation temp data

        List<DesignationTemp> designationTemps = new ArrayList<>();

        DesignationTemp designationTemp1 = new DesignationTemp();
        DesignationTemp designationTemp2 = new DesignationTemp();
        DesignationTemp designationTemp3 = new DesignationTemp();
        DesignationTemp designationTemp4 = new DesignationTemp();

        designationTemp1.setName("CE0");
        designationTemp1.setRank(1);
        designationTemp1.setMenuEntityList(customerMenuEntities1);


        designationTemp2.setName("CT0");
        designationTemp2.setRank(2);
        designationTemp2.setMenuEntityList(customerMenuEntities1);


        designationTemp3.setName("CF0");
        designationTemp3.setRank(3);
        designationTemp3.setMenuEntityList(customerMenuEntities1);

        designationTemp4.setName("Accountant");
        designationTemp4.setRank(4);
        designationTemp4.setMenuEntityList(customerMenuEntities1);

        designationTemps.add(designationTemp1);
        designationTemps.add(designationTemp2);
        designationTemps.add(designationTemp3);
        designationTemps.add(designationTemp4);


        // Corporate Customer temp data

        List<CorporateUserTemp> corporateUserTemps = new ArrayList<>();
        CorporateUserTemp corporateUserTemp1 = new CorporateUserTemp();
        CorporateUserTemp corporateUserTemp2 = new CorporateUserTemp();
        CorporateUserTemp corporateUserTemp3 = new CorporateUserTemp();
        CorporateUserTemp corporateUserTemp4 = new CorporateUserTemp();

        corporateUserTemp1.setCustomerUserName("user_name1");
        corporateUserTemp1.setName("Corporate User 1");
        corporateUserTemp1.setDesignation(designationTemps);
        corporateUserTemp1.setAccessibleAccounts(accountTemps);

        corporateUserTemp2.setCustomerUserName("user_name2");
        corporateUserTemp2.setName("Corporate User 2");
        corporateUserTemp2.setDesignation(designationTemps);
        corporateUserTemp2.setAccessibleAccounts(accountTemps);

        corporateUserTemp3.setCustomerUserName("user_name3");
        corporateUserTemp3.setName("Corporate User 3");
        corporateUserTemp3.setDesignation(designationTemps);
        corporateUserTemp3.setAccessibleAccounts(accountTemps);

        corporateUserTemp4.setCustomerUserName("user_name4");
        corporateUserTemp4.setName("Corporate User 4");
        corporateUserTemp4.setDesignation(designationTemps);
        corporateUserTemp4.setAccessibleAccounts(accountTemps);

        corporateUserTemps.add(corporateUserTemp1);
        corporateUserTemps.add(corporateUserTemp2);
        corporateUserTemps.add(corporateUserTemp3);
        corporateUserTemps.add(corporateUserTemp4);

        // WorkflowRuleMasterTemp data

        List<WorkflowRuleMasterTemp> workflowRuleMasterTemps = new ArrayList<>();

        WorkflowRuleMasterTemp workflowRuleMasterTemp1 = new WorkflowRuleMasterTemp();
        workflowRuleMasterTemp1.setName("Workflow For Other bank fund transfer");
        workflowRuleMasterTemp1.setOrganizationFeatureId(1);
        workflowRuleMasterTemp1.setRule("100-1000000");


        WorkflowRuleMasterTemp workflowRuleMasterTemp2 = new WorkflowRuleMasterTemp();
        workflowRuleMasterTemp2.setName("Workflow For Bulk Payment");
        workflowRuleMasterTemp2.setOrganizationFeatureId(2);
        workflowRuleMasterTemp2.setRule("1000000-100000000");

        List<WorkflowRuleDetailsTemp> workflowRuleDetailsTemps = new ArrayList<>();
        WorkflowRuleDetailsTemp detailsTemp1 = new WorkflowRuleDetailsTemp();
        detailsTemp1.setDesignationId(1);
        detailsTemp1.setNumberOfResponder(2);
        detailsTemp1.setNotificationOrder(1);

        WorkflowRuleDetailsTemp detailsTemp2 = new WorkflowRuleDetailsTemp();
        detailsTemp2.setDesignationId(1);
        detailsTemp2.setNumberOfResponder(1);
        detailsTemp2.setNotificationOrder(2);

        workflowRuleDetailsTemps.add(detailsTemp1);
        workflowRuleDetailsTemps.add(detailsTemp2);

        workflowRuleMasterTemp1.setAccountNumber("11234567890");
        workflowRuleMasterTemp1.setWorkflowRuleDetailsTempList(workflowRuleDetailsTemps);

        workflowRuleMasterTemp2.setAccountNumber("89987678998");
        workflowRuleMasterTemp2.setWorkflowRuleDetailsTempList(workflowRuleDetailsTemps);

        workflowRuleMasterTemps.add(workflowRuleMasterTemp1);
        workflowRuleMasterTemps.add(workflowRuleMasterTemp2);

        organizationRegistrationDTO.setOrganizationTemp(organizationTemp);
        organizationRegistrationDTO.setOrganizationAccountBatch(organizationAccountBatch);
        organizationRegistrationDTO.setCorporateUserTemp(corporateUserTemps);
        organizationRegistrationDTO.setDesignationTemps(designationTemps);
        organizationRegistrationDTO.setWorkflowRuleMasterTemps(workflowRuleMasterTemps);


        return organizationRegistrationDTO;
    }




}

