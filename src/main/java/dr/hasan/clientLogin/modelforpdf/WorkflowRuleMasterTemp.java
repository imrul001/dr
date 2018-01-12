package dr.hasan.clientLogin.modelforpdf;

import java.util.List;

public class WorkflowRuleMasterTemp{


    protected long id;

    private long organizationId;

    private long organizationFeatureId;

    private String name;

    private String rule;

    private int getBackStatus;

    private List<WorkflowRuleDetailsTemp> workflowRuleDetailsTempList;

    private long workflowRuleMasterId;

    private String accountNumber;

    private char isActive;

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public long getOrganizationFeatureId() {
        return organizationFeatureId;
    }

    public void setOrganizationFeatureId(long featureId) {
        this.organizationFeatureId = featureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getGetBackStatus() {
        return getBackStatus;
    }

    public void setGetBackStatus(int getBackStatus) {
        this.getBackStatus = getBackStatus;
    }

    public List<WorkflowRuleDetailsTemp> getWorkflowRuleDetailsTempList() {
        return workflowRuleDetailsTempList;
    }

    public void setWorkflowRuleDetailsTempList(List<WorkflowRuleDetailsTemp> workflowRuleDetailsTempList) {
        this.workflowRuleDetailsTempList = workflowRuleDetailsTempList;
    }

    public long getRuleMasterId() {
        return workflowRuleMasterId;
    }

    public void setRuleMasterId(long ruleMasterId) {
        this.workflowRuleMasterId = ruleMasterId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
