package tech.bytespot.mpesa_api.wrappers.base;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class BaseResult {


  @JsonProperty("ResultType")
  private Integer resultType;

  @JsonProperty("ResultCode")
  private Integer resultCode;

  @JsonProperty("ResultDesc")
  private String ResultDesc;

  @JsonProperty("OriginatorConversationID")
  private String originatorConversationID;

  @JsonProperty("ConversationID")
  private String conversationID;

  @JsonProperty("TransactionID")
  private String transactionID;

  @JsonProperty("ResultParameters")
  private tech.bytespot.mpesa_api.wrappers.base.simples.ResultParameters resultParameters;

  public BaseResult() {
  }

  public BaseResult(Integer resultType, Integer resultCode, String resultDesc,
      String originatorConversationID, String conversationID, String transactionID,
      tech.bytespot.mpesa_api.wrappers.base.simples.ResultParameters resultParameters) {
    this.resultType = resultType;
    this.resultCode = resultCode;
    ResultDesc = resultDesc;
    this.originatorConversationID = originatorConversationID;
    this.conversationID = conversationID;
    this.transactionID = transactionID;
    this.resultParameters = resultParameters;
  }

  public Integer getResultType() {
    return resultType;
  }

  public void setResultType(Integer resultType) {
    this.resultType = resultType;
  }

  public Integer getResultCode() {
    return resultCode;
  }

  public void setResultCode(Integer resultCode) {
    this.resultCode = resultCode;
  }

  public String getResultDesc() {
    return ResultDesc;
  }

  public void setResultDesc(String resultDesc) {
    ResultDesc = resultDesc;
  }

  public String getOriginatorConversationID() {
    return originatorConversationID;
  }

  public void setOriginatorConversationID(String originatorConversationID) {
    this.originatorConversationID = originatorConversationID;
  }

  public String getConversationID() {
    return conversationID;
  }

  public void setConversationID(String conversationID) {
    this.conversationID = conversationID;
  }

  public String getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }

  public tech.bytespot.mpesa_api.wrappers.base.simples.ResultParameters getResultParameters() {
    return resultParameters;
  }

  public void setResultParameters(
      tech.bytespot.mpesa_api.wrappers.base.simples.ResultParameters resultParameters) {
    this.resultParameters = resultParameters;
  }
}
