package platform.sunshine.model;

import platform.sunshine.form.RegisterForm;
import platform.sunshine.utils.Encryption;

import java.sql.Timestamp;

/**
 * Created by sunshine on 15/8/14.
 */
public class Account {
    private String accountId;
    private String username;
    private String email;
    private String password;
    private Timestamp createAt;

    public Account() {
        createAt = new Timestamp(System.currentTimeMillis());
    }

    public Account(RegisterForm form) {
        this();
        this.email = form.getEmail();
        this.username = form.getUsername();
        this.password = Encryption.desEncode(form.getPassword(), form.getEmail());
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Account(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
