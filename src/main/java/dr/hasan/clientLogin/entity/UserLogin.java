package dr.hasan.clientLogin.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Imrul on 10/13/2017.
 */
@Entity
@Table(name = "USER_LOGIN")
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "Token")
    private String token;

    @Column(name = "USER_LOGIN_TIME")
    private Date loginTime;

    @Column(name = "USER_LOGIN_EXPIRE_TIME")
    private Date expireTime;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
