package dr.hasan.clientLogin.modelforpdf;

import java.util.List;

public class OrganizationRegistrationDTO {

    private OrganizationTemp organizationTemp;
    private OrganizationAccountBatch organizationAccountBatch;
    private List<DesignationTemp> designationTemps;
    private List<CorporateUserTemp> corporateUserTemp;
    private List<WorkflowRuleMasterTemp> workflowRuleMasterTemps;

    public OrganizationTemp getOrganizationTemp() {
        return organizationTemp;
    }

    public void setOrganizationTemp(OrganizationTemp organizationTemp) {
        this.organizationTemp = organizationTemp;
    }

    public OrganizationAccountBatch getOrganizationAccountBatch() {
        return organizationAccountBatch;
    }

    public void setOrganizationAccountBatch(OrganizationAccountBatch organizationAccountBatch) {
        this.organizationAccountBatch = organizationAccountBatch;
    }

    public List<DesignationTemp> getDesignationTemps() {
        return designationTemps;
    }

    public void setDesignationTemps(List<DesignationTemp> designationTemps) {
        this.designationTemps = designationTemps;
    }

    public List<CorporateUserTemp> getCorporateUserTemp() {
        return corporateUserTemp;
    }

    public void setCorporateUserTemp(List<CorporateUserTemp> corporateUserTemp) {
        this.corporateUserTemp = corporateUserTemp;
    }

    public List<WorkflowRuleMasterTemp> getWorkflowRuleMasterTemps() {
        return workflowRuleMasterTemps;
    }

    public void setWorkflowRuleMasterTemps(List<WorkflowRuleMasterTemp> workflowRuleMasterTemps) {
        this.workflowRuleMasterTemps = workflowRuleMasterTemps;
    }
}
