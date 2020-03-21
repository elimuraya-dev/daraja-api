package tech.bytespot.mpesa_api.wrappers.base.simples;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public class NameValue {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Value")
    private Object value;

    public NameValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public NameValue() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
