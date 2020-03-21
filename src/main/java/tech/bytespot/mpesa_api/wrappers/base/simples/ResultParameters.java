package tech.bytespot.mpesa_api.wrappers.base.simples;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class ResultParameters {
    @JsonProperty("ResultParameter")
    private List<KeyValue> resultParameter;

    public ResultParameters() {
    }

    public List<KeyValue> getResultParameter() {
        return resultParameter;
    }

    public void setResultParameter(List<KeyValue> resultParameter) {
        this.resultParameter = resultParameter;
    }
}
