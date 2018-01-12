package dr.hasan.clientLogin.modelforpdf;

import java.util.List;

public class OrganizationTemp{

    private long id;

    private List<OrganizationContactTemp> contactTemps;

    private String name;

    private String corporateId;

    private String businessType;

    private String email;

    private String website;

    private byte[] logo;

    private int status;

    private char isActive;

    private long organizationId;

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<OrganizationContactTemp> getContactTemps() {
        return contactTemps;
    }

    public void setContactTemps(List<OrganizationContactTemp> contactTemps) {
        this.contactTemps = contactTemps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
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

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }
}