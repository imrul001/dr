package dr.hasan.clientLogin.modelforpdf;

import java.util.List;

public class OrganizationAccountBatch {


    private long id;
    private long organizationId;
    private List<OrganizationAccountTemp> accountTempList;

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

    public List<OrganizationAccountTemp> getAccountTempList() {
        return accountTempList;
    }

    public void setAccountTempList(List<OrganizationAccountTemp> accountTempList) {
        this.accountTempList = accountTempList;
    }
}
