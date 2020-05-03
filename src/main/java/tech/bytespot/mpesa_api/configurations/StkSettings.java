package tech.bytespot.mpesa_api.configurations;

/**
 * variables used in STK transactions
 */
public class StkSettings {
  private String lipaNaMpesaShortcode;
  private String passKey;
  private String stkCallback;

  public StkSettings(String lipaNaMpesaShortcode, String passKey, String stkCallback) {
    this.lipaNaMpesaShortcode = lipaNaMpesaShortcode;
    this.passKey = passKey;
    this.stkCallback = stkCallback;
  }

  public String getLipaNaMpesaShortcode() {
    return lipaNaMpesaShortcode;
  }

  public String getPassKey() {
    return passKey;
  }

  public String getStkCallback() {
    return stkCallback;
  }
}
