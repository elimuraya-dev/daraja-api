package tech.bytespot.mpesa_api.wrappers.user;

/**
 * User request parameters for Reversal request
 *
 * @author eli_muraya on 28/10/2019 .
 */
public class Reversal_Request {
  private String transactionId;
  private String amount;
  private String comment;
  private String occasion;

  private Reversal_Request() {
  }

  public String getTransactionId() {
    return transactionId;
  }

  public String getAmount() {
    return amount;
  }

  public String getComment() {
    return comment;
  }

  public String getOccasion() {
    return occasion;
  }

  /**
   * Builder defination
   */
  public static class ReversalBuilder {
    private String transactionId;
    private String amount;
    private String comment;
    private String occasion;

    public ReversalBuilder() {
    }

    public ReversalBuilder forTransactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    public ReversalBuilder withAmount(String amount) {
      this.amount = amount;
      return this;
    }

    public ReversalBuilder withComment(String comment) {
      this.comment = comment;
      return this;
    }

    public ReversalBuilder withOccasion(String occasion) {
      this.occasion = occasion;
      return this;
    }

    public Reversal_Request build() {
      Reversal_Request request = new Reversal_Request();
      request.transactionId = this.transactionId;
      request.amount = this.amount;
      request.comment = this.comment;
      request.occasion = this.occasion;
      return request;
    }
  }

  public static ReversalBuilder builder() {
    return new ReversalBuilder();
  }
}
