package dr.hasan.clientLogin.modelforpdf;

import java.util.List;

public class OrganizationAccountTemp {


    private long id;

    private long organizationId;

    private String accountNumber;

    private String accountName;

    private String cbNumber;

    private String accountType;

    private int status;

    private char isActive;

    private int organizationAccountId;

    private List<FeatureItem> privilegeFeatureItems;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCbNumber() {
        return cbNumber;
    }

    public void setCbNumber(String cbNumber) {
        this.cbNumber = cbNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public int getOrganizationAccountId() {
        return organizationAccountId;
    }

    public void setOrganizationAccountId(int organizationAccountId) {
        this.organizationAccountId = organizationAccountId;
    }

    public List<FeatureItem> getPrivilegeFeatureItems() {
        return privilegeFeatureItems;
    }

    public void setPrivilegeFeatureItems(List<FeatureItem> privilegeFeatureItems) {
        this.privilegeFeatureItems = privilegeFeatureItems;
    }

}
