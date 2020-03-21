package tech.bytespot.mpesa_api.wrappers.base.simples;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public class StkBaseResp {
    @JsonProperty("MerchantRequestID")
    private String merchantRequestID;

    @JsonProperty("CheckoutRequestID")
    private String checkoutRequestID;

    @JsonProperty("ResultDesc")
    private String resultDesc;

    @JsonProperty("ResultCode")
    private int resultCode;

    public StkBaseResp() {
    }

    public StkBaseResp(String merchantRequestID, String checkoutRequestID, String resultDesc, int resultCode) {
        this.merchantRequestID = merchantRequestID;
        this.checkoutRequestID = checkoutRequestID;
        this.resultDesc = resultDesc;
        this.resultCode = resultCode;
    }

    public String getMerchantRequestID() {
        return merchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        this.merchantRequestID = merchantRequestID;
    }

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
