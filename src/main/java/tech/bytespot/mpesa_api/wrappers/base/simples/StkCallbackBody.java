package tech.bytespot.mpesa_api.wrappers.base.simples;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public class StkCallbackBody {
    private StkBaseResp stkCallback;

    public StkCallbackBody() {
    }

    public StkCallbackBody(StkBaseResp stkCallback) {
        this.stkCallback = stkCallback;
    }

    public StkBaseResp getStkCallback() {
        return stkCallback;
    }

    public void setStkCallback(StkBaseResp stkCallback) {
        this.stkCallback = stkCallback;
    }
}
