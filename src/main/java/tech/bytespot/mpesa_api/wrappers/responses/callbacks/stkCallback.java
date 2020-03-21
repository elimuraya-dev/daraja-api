package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import tech.bytespot.mpesa_api.wrappers.base.simples.StkBaseRespAlpha;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 22/11/2019 .
 */
public class stkCallback {
    @JsonProperty("stkCallback")
    private StkBaseRespAlpha stkCallback;

    public stkCallback() {
    }

    public StkBaseRespAlpha getStkCallback() {
        return stkCallback;
    }

    public void setStkCallback(StkBaseRespAlpha stkCallback) {
        this.stkCallback = stkCallback;
    }
}
