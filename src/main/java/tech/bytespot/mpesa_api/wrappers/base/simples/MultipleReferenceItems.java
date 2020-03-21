package tech.bytespot.mpesa_api.wrappers.base.simples;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class MultipleReferenceItems {
    @JsonProperty("ReferenceItem")
    private List<KeyValue> referenceItem;

    public MultipleReferenceItems(List<KeyValue> referenceItem) {
        this.referenceItem = referenceItem;
    }

    public MultipleReferenceItems() {
    }

    public List<KeyValue> getReferenceItem() {
        return referenceItem;
    }

    public void setReferenceItem(List<KeyValue> referenceItem) {
        this.referenceItem = referenceItem;
    }
}
