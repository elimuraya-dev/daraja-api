package tech.bytespot.mpesa_api.wrappers.base.simples;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class SingleReferenceItem {
    @JsonProperty("ReferenceItem")
    private KeyValue referenceItem;

    public SingleReferenceItem() {

    }

    public KeyValue getReferenceItem() {
        return referenceItem;
    }

    public void setReferenceItem(KeyValue referenceItem) {
        this.referenceItem = referenceItem;
    }
}
