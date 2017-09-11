package dr.hasan.clientRegistration.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Imrul on 9/11/2017.
 */

@Entity(name = "ClientDetails")
@Table(name = "Client_Details")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private long id;

    @Column(name = "client_email")
    private String email;

    @Column(name = "client_date_of_birth")
    private Date dateOfBirth;

    @Column(name = "client_password")
    private String password;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_gender")
    private int gender;

    @Column(name = "isActive")
    private int active;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public void setGender(int sex) {
        this.gender = gender;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
