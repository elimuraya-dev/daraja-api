package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.bytespot.mpesa_api.wrappers.base.B2C_Resp;
import tech.bytespot.mpesa_api.wrappers.base.simples.KeyValue;

/**
 * Response wrapper for B2C request
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class B2C_CallbackResponse {

  @JsonProperty("Result")
  private B2C_Resp result;

  private static final String PHONE_NUMBER = "ReceiverPartyPublicName";
  private static final String REVERSAL_PHONE_NUMBER = "CreditPartyPublicName";
  private static final String AMOUNT = "TransactionAmount";
  private static final String REVERSAL_AMOUNT = "Amount";
  private static final String RECEIPT = "TransactionReceipt";


  public B2C_CallbackResponse() {
  }

  public B2C_CallbackResponse(B2C_Resp result) {
    this.result = result;
  }

  public B2C_Resp getResult() {
    return result;
  }

  public void setResult(B2C_Resp result) {
    this.result = result;
  }

  public String getPhoneNumber() {
    String phoneNumber = "";
    try {
      var listings = result.getResultParameters().getResultParameter();
      phoneNumber = listings
          .stream()
          .filter(item -> item.getKey().equalsIgnoreCase(PHONE_NUMBER))
          .map(KeyValue::getValue)
          .findFirst()
          .orElse("")
          .toString();
      return phoneNumber.equals("") == true ? phoneNumber : phoneNumber.substring(0, 12);
    } catch (Exception ex) {
      ex.printStackTrace();
      return phoneNumber;
    }
  }

  public String getReversalPhoneNumber() {
    String phoneNumber = "";
    try {
      phoneNumber = result.getResultParameters().getResultParameter()
          .stream()
          .filter(item -> item.getKey().equalsIgnoreCase(REVERSAL_PHONE_NUMBER))
          .map(KeyValue::getValue)
          .findFirst()
          .orElse("")
          .toString();
      return phoneNumber.equals("") == true ? phoneNumber : phoneNumber.substring(0, 12);
    } catch (Exception ex) {
      ex.printStackTrace();
      return phoneNumber;
    }

  }

  public Integer getAmount() {
    Integer amount = 0;
    try {
      var listings = result.getResultParameters().getResultParameter();
      amount = (Integer) listings
          .stream()
          .filter(item -> item.getKey().equalsIgnoreCase(AMOUNT))
          .map(KeyValue::getValue)
          .findFirst()
          .orElse(0);
      return amount;
    } catch (Exception ex) {
      ex.printStackTrace();
      return amount;
    }
  }

  public Integer getReversalAmount() {
    Integer amount = 0;
    try {
      amount = (Integer) result.getResultParameters().getResultParameter()
          .stream()
          .filter(item -> item.getKey().equalsIgnoreCase(REVERSAL_AMOUNT))
          .map(KeyValue::getValue)
          .findFirst()
          .orElse(0);
      return amount;
    } catch (Exception ex) {
      ex.printStackTrace();
      return amount;
    }
  }

  public String getReceiptNumber() {
    String receipt = "";
    try {
      receipt = result.getResultParameters().getResultParameter()
          .stream()
          .filter(item -> item.getKey().equalsIgnoreCase(RECEIPT))
          .map(KeyValue::getValue)
          .findFirst()
          .orElse("")
          .toString();
      return receipt;
    } catch (Exception ex) {
      ex.printStackTrace();
      return receipt;
    }
  }

  @Override
  public String toString() {
    return "{" +
        "Result=" + result +
        '}';
  }
}
