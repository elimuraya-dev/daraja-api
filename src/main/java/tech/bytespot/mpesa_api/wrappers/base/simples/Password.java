package tech.bytespot.mpesa_api.wrappers.base.simples;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public class Password {
    private String password;
    private String timestamp;

    public Password() {
    }

    public Password(String password, String timestamp) {
        this.password = password;
        this.timestamp = timestamp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
