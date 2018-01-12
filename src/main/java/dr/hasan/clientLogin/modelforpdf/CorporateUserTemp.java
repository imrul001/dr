package dr.hasan.clientLogin.modelforpdf;

import java.util.Date;
import java.util.List;

public class CorporateUserTemp {

    private List<DesignationTemp> designation;
    private List<OrganizationAccountTemp> accessibleAccounts;

    private String customerUserName;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String mobileNo;

    private String motherName;

    private Date dob;

    private int status;

    private int badLoginPerDay;

    private int badLoginAttempt;

    public List<DesignationTemp> getDesignation() {
        return designation;
    }

    public void setDesignation(List<DesignationTemp> designation) {
        this.designation = designation;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBadLoginPerDay() {
        return badLoginPerDay;
    }

    public void setBadLoginPerDay(int badLoginPerDay) {
        this.badLoginPerDay = badLoginPerDay;
    }

    public int getBadLoginAttempt() {
        return badLoginAttempt;
    }

    public void setBadLoginAttempt(int badLoginAttempt) {
        this.badLoginAttempt = badLoginAttempt;
    }


    public List<OrganizationAccountTemp> getAccessibleAccounts() {
        return accessibleAccounts;
    }

    public void setAccessibleAccounts(List<OrganizationAccountTemp> accessibleAccounts) {
        this.accessibleAccounts = accessibleAccounts;
    }
}


