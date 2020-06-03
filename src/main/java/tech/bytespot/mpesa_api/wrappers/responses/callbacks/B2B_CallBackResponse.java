package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.bytespot.mpesa_api.wrappers.base.B2B_Resp;
import tech.bytespot.mpesa_api.wrappers.base.simples.KeyValue;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public class B2B_CallBackResponse {

    @JsonProperty("Result")
    private B2B_Resp result;

    private static String AMOUNT = "Amount";


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

    public Integer getAmount() {
        return (Integer) result.getResultParameters().getResultParameter()
            .stream()
            .filter(item -> item.getKey().equalsIgnoreCase(AMOUNT))
            .map(KeyValue::getValue)
            .findFirst()
            .orElse(null);
    }

    @Override
    public String toString() {
        return "{" +
            "Result=" + result +
            '}';
    }
}
