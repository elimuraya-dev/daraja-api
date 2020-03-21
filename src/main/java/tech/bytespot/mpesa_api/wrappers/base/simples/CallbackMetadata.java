package tech.bytespot.mpesa_api.wrappers.base.simples;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public class CallbackMetadata {
    @JsonProperty("Item")
    private List<NameValue> item;

    public CallbackMetadata() {
    }

    public CallbackMetadata(List<NameValue> item) {
        this.item = item;
    }

    public List<NameValue> getItem() {
        return item;
    }

    public void setItem(List<NameValue> item) {
        this.item = item;
    }
}
