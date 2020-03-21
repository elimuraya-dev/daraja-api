package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import tech.bytespot.mpesa_api.wrappers.base.B2C_Resp;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response wrapper for B2C request
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class B2C_CallbackResponse {
    @JsonProperty("Result")
    private B2C_Resp result;

    public B2C_CallbackResponse() {
    }

    public B2C_CallbackResponse(B2C_Resp result) {
        this.result = result;
    }

    public B2C_Resp getResult() {
        return result;
    }

    public void setResult(B2C_Resp result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{" +
                "Result=" + result +
                '}';
    }
}
