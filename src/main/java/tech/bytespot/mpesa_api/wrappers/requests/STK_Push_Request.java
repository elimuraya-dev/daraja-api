package tech.bytespot.mpesa_api.wrappers.requests;

import tech.bytespot.mpesa_api.wrappers.base.AmountAndPartys;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * * Wrapper class for STK push request payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class STK_Push_Request extends AmountAndPartys {
    @JsonProperty("BusinessShortCode")
    private String businessShortCode;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Timestamp")
    private String timestamp;

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @JsonProperty("CallBackURL")
    private String callBackURL;

    @JsonProperty("AccountReference")
    private String accountReference;

    @JsonProperty("TransactionDesc")
    private String transactionDesc;

    public STK_Push_Request() {
    }

    public STK_Push_Request(String businessShortCode, String password, String timestamp, String transactionType, String phoneNumber, String callBackURL, String accountReference, String transactionDesc) {
        this.businessShortCode = businessShortCode;
        this.password = password;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
        this.phoneNumber = phoneNumber;
        this.callBackURL = callBackURL;
        this.accountReference = accountReference;
        this.transactionDesc = transactionDesc;
    }

    public STK_Push_Request(String amount, String partyA, String partyB, String businessShortCode, String password, String timestamp, String transactionType, String phoneNumber, String callBackURL, String accountReference, String transactionDesc) {
        super(amount, partyA, partyB);
        this.businessShortCode = businessShortCode;
        this.password = password;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
        this.phoneNumber = phoneNumber;
        this.callBackURL = callBackURL;
        this.accountReference = accountReference;
        this.transactionDesc = transactionDesc;
    }

    public String getBusinessShortCode() {
        return businessShortCode;
    }

    public void setBusinessShortCode(String businessShortCode) {
        this.businessShortCode = businessShortCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCallBackURL() {
        return callBackURL;
    }

    public void setCallBackURL(String callBackURL) {
        this.callBackURL = callBackURL;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public void setAccountReference(String accountReference) {
        this.accountReference = accountReference;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc;
    }

    @Override
    public String toString() {
        return "{" +
                "BusinessShortCode : \"" + businessShortCode + "\"" +
                ", password : \"" + password + "\"" +
                ", timestamp : \"" + timestamp + "\"" +
                ", transactionType : \"" + transactionType + "\"" +
                ", phoneNumber : \"" + phoneNumber + "\"" +
                ", callBackURL : \"" + callBackURL + "\"" +
                ", accountReference : \"" + accountReference + "\"" +
                ", transactionDesc : \"" + transactionDesc + "\"" +
                '}';
    }
}
