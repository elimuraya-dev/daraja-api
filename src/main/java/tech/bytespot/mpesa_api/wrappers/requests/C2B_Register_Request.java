package tech.bytespot.mpesa_api.wrappers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper class for C2B registration request payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class C2B_Register_Request {
    @JsonProperty("ValidationURL")
    private String validationURL;

    @JsonProperty("ConfirmationURL")
    private String confirmationURL;

    @JsonProperty("ResponseType")
    private String responseType;

    @JsonProperty("ShortCode")
    private String shortCode;


    public C2B_Register_Request() {
    }

    public C2B_Register_Request(String validationURL, String confirmationURL, String responseType, String shortCode) {
        this.validationURL = validationURL;
        this.confirmationURL = confirmationURL;
        this.responseType = responseType;
        this.shortCode = shortCode;
    }

    public String getValidationURL() {
        return validationURL;
    }

    public void setValidationURL(String validationURL) {
        this.validationURL = validationURL;
    }

    public String getConfirmationURL() {
        return confirmationURL;
    }

    public void setConfirmationURL(String confirmationURL) {
        this.confirmationURL = confirmationURL;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

}
