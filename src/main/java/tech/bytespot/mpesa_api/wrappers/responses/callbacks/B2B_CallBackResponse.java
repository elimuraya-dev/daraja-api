package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import tech.bytespot.mpesa_api.wrappers.base.B2B_Resp;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public class B2B_CallBackResponse {
    @JsonProperty("Result")
    private B2B_Resp result;

    public B2B_CallBackResponse(B2B_Resp result) {
        this.result = result;
    }

    public B2B_CallBackResponse() {
    }

    public B2B_Resp getResult() {
        return result;
    }

    public void setResult(B2B_Resp result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{" +
                "Result=" + result +
                '}';
    }
}
