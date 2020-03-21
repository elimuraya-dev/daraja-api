package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * * Wrapper class for callback response (accepted by user) on STK request
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class STK_Success_CallbackResponse {
    @JsonProperty("Body")
    private stkCallback body;

    public STK_Success_CallbackResponse() {
    }

    public stkCallback getBody() {
        return body;
    }

    public void setBody(stkCallback body) {
        this.body = body;
    }
}
