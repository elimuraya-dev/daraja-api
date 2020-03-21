package tech.bytespot.mpesa_api.wrappers.responses;

/**
 * Wrapper response for all Safaricom API calls that respond to resultURLS.
 * Thia just tells the user that the request was delivered successfully, but it isnt the actual
 * response from Safaricom
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class MpesaResponse {
    private boolean status;
    private String message;

    public MpesaResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public MpesaResponse() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
