package tech.bytespot.mpesa_api.wrappers.responses.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 06/11/2019 .
 */
public class MpesaErrorResponse {
  @JsonProperty("requestId")
  private String requestId;
  @JsonProperty("errorCode")
  private String errorCode;
  @JsonProperty("errorMessage")
  private String errorMessage;

  public MpesaErrorResponse() {
  }

  public MpesaErrorResponse(String requestId, String errorCode, String errorMessage) {
    this.requestId = requestId;
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    return "{" +
            "requestId : " + requestId + '\'' +
            ", errorCode : '" + errorCode + '\'' +
            ", errorMessage : " + errorMessage + '\'' +
            '}';
  }
}
