package tech.bytespot.mpesa_api.wrappers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * * Wrapper class for STK push status query request payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class STK_Push_Query_Request {
    @JsonProperty("BusinessShortCode")
    private String businessShortCode;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Timestamp")
    private String timestamp;

    @JsonProperty("CheckoutRequestID")
    private String checkoutRequestID;

    public STK_Push_Query_Request() {
    }

    public STK_Push_Query_Request(String businessShortCode, String password, String timestamp, String checkoutRequestID) {
        this.businessShortCode = businessShortCode;
        this.password = password;
        this.timestamp = timestamp;
        this.checkoutRequestID = checkoutRequestID;
    }

    public String getBusinessShortCode() {
        return businessShortCode;
    }

    public void setBusinessShortCode(String businessShortCode) {
        this.businessShortCode = businessShortCode;
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

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }
}
