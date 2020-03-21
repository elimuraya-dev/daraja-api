package tech.bytespot.mpesa_api.wrappers.base.simples;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public class StkBaseRespAlpha extends StkBaseResp {

  @JsonProperty("CallbackMetadata")
  private CallbackMetadata callbackMetadata;

  public StkBaseRespAlpha() {
  }

  public StkBaseRespAlpha(tech.bytespot.mpesa_api.wrappers.base.simples.CallbackMetadata callbackMetadata) {
    this.callbackMetadata = callbackMetadata;
  }

  public StkBaseRespAlpha(String merchantRequestID, String checkoutRequestID, String resultDesc, int resultCode, tech.bytespot.mpesa_api.wrappers.base.simples.CallbackMetadata callbackMetadata) {
    super(merchantRequestID, checkoutRequestID, resultDesc, resultCode);
    this.callbackMetadata = callbackMetadata;
  }

  public tech.bytespot.mpesa_api.wrappers.base.simples.CallbackMetadata getCallbackMetadata() {
    return callbackMetadata;
  }

  public void setCallbackMetadata(tech.bytespot.mpesa_api.wrappers.base.simples.CallbackMetadata callbackMetadata) {
    this.callbackMetadata = callbackMetadata;
  }
}
