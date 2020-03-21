package tech.bytespot.mpesa_api.wrappers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 21/10/2019 .
 */
public class MpesaGeneralResponse extends C2B_Response {

    @JsonProperty("ResponseCode")
    private String responseCode;


    public MpesaGeneralResponse() {
    }

    public MpesaGeneralResponse(String responseCode) {
        this.responseCode = responseCode;
    }

    public MpesaGeneralResponse(String conversationID, String originatorConversationID, String responseDescription, String responseCode) {
        super(conversationID, originatorConversationID, responseDescription);
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
