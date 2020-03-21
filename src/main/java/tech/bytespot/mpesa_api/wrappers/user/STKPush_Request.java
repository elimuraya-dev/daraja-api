package tech.bytespot.mpesa_api.wrappers.user;

/**
 * User request parameters for STK push
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class STKPush_Request {
  private String phoneNumber;
  private String amount;
  private String accountReference;
  private String description;

  private STKPush_Request() {
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAmount() {
    return amount;
  }

  public String getAccountReference() {
    return accountReference;
  }

  public String getDescription() {
    return description;
  }

  /**
   * Builder defination
   */
  public static class STKBuilder {
    private String phoneNumber;
    private String amount;
    private String accountReference;
    private String description;

    public STKBuilder() {
    }

    public STKBuilder forPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public STKBuilder withAmount(String amount) {
      this.amount = amount;
      return this;
    }

    public STKBuilder withAccountReference(String accountReference) {
      this.accountReference = accountReference;
      return this;
    }

    public STKBuilder withDescription(String description) {
      this.description = description;
      return this;
    }

    public STKPush_Request build() {
      STKPush_Request request = new STKPush_Request();
      request.phoneNumber = this.phoneNumber;
      request.amount = this.amount;
      request.accountReference = this.accountReference;
      request.description = this.description;
      return request;
    }
  }

  public static STKBuilder builder() {
    return new STKBuilder();
  }
}
