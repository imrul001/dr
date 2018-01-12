package dr.hasan.clientLogin.modelforpdf;

import java.util.List;

public class DesignationTemp {

    protected long id;

    private long organizationId;

    private int rank;

    private int status;

    private int userType;

    private String name;

    private long designationId;

    private long batchId;

    private char isActive;

    private List<CustomerMenuEntity> menuEntityList;

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerMenuEntity> getMenuEntityList() {
        return menuEntityList;
    }

    public void setMenuEntityList(List<CustomerMenuEntity> menuEntityList) {
        this.menuEntityList = menuEntityList;
    }

    public long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(long designationId) {
        this.designationId = designationId;
    }

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }
}
