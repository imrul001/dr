package dr.hasan.clientLogin.modelforpdf;

public class WorkflowRuleDetailsTemp{

    private long ruleDetailsId;

    private WorkflowRuleMasterTemp workflowRuleMasterTemp;

    private long designationId;

    private int notificationOrder;

    private int numberOfResponder;

    private int isGroupNotification;

    public long getRuleDetailsId() {
        return ruleDetailsId;
    }

    public void setRuleDetailsId(long ruleDetailsId) {
        this.ruleDetailsId = ruleDetailsId;
    }

    public WorkflowRuleMasterTemp getWorkflowRuleMasterTemp() {
        return workflowRuleMasterTemp;
    }

    public void setWorkflowRuleMasterTemp(WorkflowRuleMasterTemp workflowRuleMasterTemp) {
        this.workflowRuleMasterTemp = workflowRuleMasterTemp;
    }

    public long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(long organogramId) {
        this.designationId = organogramId;
    }

    public int getNotificationOrder() {
        return notificationOrder;
    }

    public void setNotificationOrder(int notificationOrder) {
        this.notificationOrder = notificationOrder;
    }

    public int getNumberOfResponder() {
        return numberOfResponder;
    }

    public void setNumberOfResponder(int numberOfResponder) {
        this.numberOfResponder = numberOfResponder;
    }

    public int getIsGroupNotification() {
        return isGroupNotification;
    }

    public void setIsGroupNotification(int isGroupNotification) {
        this.isGroupNotification = isGroupNotification;
    }
}
