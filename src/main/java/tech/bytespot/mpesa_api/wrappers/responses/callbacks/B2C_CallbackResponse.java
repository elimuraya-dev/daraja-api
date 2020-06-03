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

  private static String PHONE_NUMBER = "ReceiverPartyPublicName";
  private static String REVERSAL_PHONE_NUMBER = "CreditPartyPublicName";
  private static String AMOUNT = "TransactionAmount";
  private static String REVERSAL_AMOUNT = "Amount";
  private static String RECEIPT = "TransactionReceipt";


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
    String substring = result.getResultParameters().getResultParameter()
        .stream()
        .filter(item -> item.getKey().equalsIgnoreCase(PHONE_NUMBER))
        .map(KeyValue::getValue)
        .findFirst()
        .orElse("")
        .toString();
    return substring.equals("") == true ? substring : substring.substring(0, 11);
  }

  public String getReversalPhoneNumber() {
    return result.getResultParameters().getResultParameter()
        .stream()
        .filter(item -> item.getKey().equalsIgnoreCase(REVERSAL_PHONE_NUMBER))
        .map(KeyValue::getValue)
        .findFirst()
        .orElse("")
        .toString()
        .substring(0, 11);
  }

  public Integer getAmount() {
    return (Integer) result.getResultParameters().getResultParameter()
        .stream()
        .filter(item -> item.getKey().equalsIgnoreCase(AMOUNT))
        .map(KeyValue::getValue)
        .findFirst()
        .orElse(null);
  }

  public Integer getReversalAmount() {
    return (Integer) result.getResultParameters().getResultParameter()
        .stream()
        .filter(item -> item.getKey().equalsIgnoreCase(REVERSAL_AMOUNT))
        .map(KeyValue::getValue)
        .findFirst()
        .orElse(null);
  }

  public Integer getReceiptNumber() {
    return (Integer) result.getResultParameters().getResultParameter()
        .stream()
        .filter(item -> item.getKey().equalsIgnoreCase(RECEIPT))
        .map(KeyValue::getValue)
        .findFirst()
        .orElse(null);
  }

  @Override
  public String toString() {
    return "{" +
        "Result=" + result +
        '}';
  }
}
