package dr.hasan.clientRegistration.viewmodel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Imrul on 9/11/2017.
 */
public class ClientDTO {

    private long id;
    private String email;
    private String dateOfBirth;
    private String password;
    private String name;
    private int gender;
    private int active;

    public ClientDTO() {
    }

    public ClientDTO(long id, String email, String dateOfBirth, String password, String name, int gender, int active) {
        this.id = id;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
