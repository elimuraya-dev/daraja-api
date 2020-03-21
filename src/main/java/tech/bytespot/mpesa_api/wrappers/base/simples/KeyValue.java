package tech.bytespot.mpesa_api.wrappers.base.simples;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class KeyValue {
    @JsonProperty("Key")
    private String key;

    @JsonProperty("Value")
    private Object value;

    public KeyValue() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
