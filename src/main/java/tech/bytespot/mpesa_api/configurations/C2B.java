package tech.bytespot.mpesa_api.configurations;

/**
 * @author eli_muraya on 24/02/2020 .
 */
public class C2B {
  private String validationUrl;
  private String confirmationUrl;

  public C2B() {
  }

  public C2B(String validationUrl, String confirmationUrl) {
    this.validationUrl = validationUrl;
    this.confirmationUrl = confirmationUrl;
  }

  public String getValidationUrl() {
    return validationUrl;
  }


  public String getConfirmationUrl() {
    return confirmationUrl;
  }


  @Override
  public String toString() {
    return "C2B{" +
            "validationUrl='" + validationUrl + '\'' +
            ", confirmationUrl='" + confirmationUrl + '\'' +
            '}';
  }
}
