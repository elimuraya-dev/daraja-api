package tech.bytespot.mpesa_api.wrappers.user;

/**
 * User request parameters for C2B simaulate request
 *
 * @author eli_muraya on 12/11/2019 .
 */
public class C2B_SimulateRequest {
  private String commandId;
  private String amount;
  private String msisdn;
  private String billRefNumber;

  private C2B_SimulateRequest() {
  }

  public static C2BSimulateBuilder builder() {
    return new C2BSimulateBuilder();
  }

  public String getCommandId() {
    return commandId;
  }

  public String getAmount() {
    return amount;
  }

  public String getMsisdn() {
    return msisdn;
  }

  /**
   * BUILDER defination
   */
  public static class C2BSimulateBuilder {
    private String commandId;
    private String amount;
    private String msisdn;
    private String billRefNumber;

        public C2BSimulateBuilder() {
        }

        public C2BSimulateBuilder forPhoneNumber(String msisdn) {
            this.msisdn = msisdn;
            return this;
        }

        public C2BSimulateBuilder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public C2BSimulateBuilder withReferenceNo(String referenceNo) {
            this.billRefNumber = referenceNo;
            return this;
        }

        public C2BSimulateBuilder withCommandId(String commandId) {
            this.commandId = commandId;
            return this;
        }

    public C2B_SimulateRequest build() {
      C2B_SimulateRequest request = new C2B_SimulateRequest();
      request.amount = this.amount;
      request.billRefNumber = this.billRefNumber;
      request.msisdn = this.msisdn;
      request.commandId = this.commandId;
      return request;
    }
  }

  public String getBillRefNumber() {
    return billRefNumber;
  }
}
