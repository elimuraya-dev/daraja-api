package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import tech.bytespot.mpesa_api.wrappers.base.simples.StkCallbackBody;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper class for callback response (rejected by user) on STK request
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class STK_Failed_CallbackResponse {
    @JsonProperty("Body")
    private StkCallbackBody body;

    public STK_Failed_CallbackResponse() {
    }

    public STK_Failed_CallbackResponse(StkCallbackBody body) {
        this.body = body;
    }

    public StkCallbackBody getBody() {
        return body;
    }

    public void setBody(StkCallbackBody body) {
        this.body = body;
    }
}
