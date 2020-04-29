package tech.bytespot.mpesa_api.configurations;

/**
 * @author eli_muraya on 24/02/2020 .
 */
public class CallbackAndCredential {
  private String callbackUrl;
  private String timeoutUrl;
  private String initiatorName;
  private String initiatorPassword;
  private String securityCredential;


  public CallbackAndCredential() {
  }

  public CallbackAndCredential(String callbackUrl, String timeoutUrl, String initiatorName, String initiatorPassword) {
    this.callbackUrl = callbackUrl;
    this.timeoutUrl = timeoutUrl;
    this.initiatorName = initiatorName;
    this.initiatorPassword = initiatorPassword;
  }

  public CallbackAndCredential(String callbackUrl, String timeoutUrl, String initiatorName, String initiatorPassword, String securityCredential) {
    this.callbackUrl = callbackUrl;
    this.timeoutUrl = timeoutUrl;
    this.initiatorName = initiatorName;
    this.initiatorPassword = initiatorPassword;
    this.securityCredential = securityCredential;
  }

  public String getCallbackUrl() {
    return callbackUrl;
  }


  public String getInitiatorName() {
    return initiatorName;
  }


  public String getTimeoutUrl() {
    return timeoutUrl;
  }

  public String getInitiatorPassword() {
    return initiatorPassword;
  }

  public void setSecurityCredential(String securityCredential) {
    this.securityCredential = securityCredential;
  }

  public String getSecurityCredential() {
    return securityCredential;
  }

  @Override
  public String toString() {
    return "{" +
            "callbackUrl : \"" + callbackUrl + "\"" +
            ", timeoutUrl : \"" + timeoutUrl + "\"" +
            ", initiatorName : \"" + initiatorName + "\"" +
            ", initiatorPassword : \"" + initiatorPassword + "\"" +
            ", securityCredential : \"" + securityCredential + "\"" +
            '}';
  }
}
