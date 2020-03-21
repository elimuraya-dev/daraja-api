package tech.bytespot.mpesa_api.wrappers.responses;

/**
 * * Response wrapper for access_token generation request
 *
 * @author eli_muraya on 09/10/2019 .
 */
public class TokenResponse {
    private String access_token;
    private String expires_in;

    public TokenResponse() {
    }

    public TokenResponse(String access_token, String expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
}
