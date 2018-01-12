package dr.hasan.clientLogin.modelforpdf;

public class OrganizationContactTemp{


    private int contactType;
    private String name;
    private String designation;
    private String phone;
    private String mobileNo;
    private String email;
    private String nidPassport;
    public int getContactType() {
        return contactType;
    }

    public void setContactType(int contactType) {
        this.contactType = contactType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNidPassport() {
        return nidPassport;
    }

    public void setNidPassport(String nidPassport) {
        this.nidPassport = nidPassport;
    }
}