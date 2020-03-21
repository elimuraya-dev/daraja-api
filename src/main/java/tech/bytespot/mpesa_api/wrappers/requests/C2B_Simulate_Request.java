package tech.bytespot.mpesa_api.wrappers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * * Wrapper class for C2B simulation request  payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class C2B_Simulate_Request {
    @JsonProperty("CommandID")
    private String commandId;

    @JsonProperty("Amount")
    private String amount;

    @JsonProperty("Msisdn")
    private String msisdn;
    @JsonProperty("BillRefNumber")
    private String billRefNumber;

    @JsonProperty("ShortCode")
    private String shortCode;

    public C2B_Simulate_Request() {
    }

    public C2B_Simulate_Request(String commandId, String amount, String msisdn, String billRefNumber, String shortCode) {
        this.commandId = commandId;
        this.amount = amount;
        this.msisdn = msisdn;
        this.billRefNumber = billRefNumber;
        this.shortCode = shortCode;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getBillRefNumber() {
        return billRefNumber;
    }

    public void setBillRefNumber(String billRefNumber) {
        this.billRefNumber = billRefNumber;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Override
    public String toString() {
        return "{" +
                "commandId='" + commandId + '\'' +
                ", amount='" + amount + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", billRefNumber='" + billRefNumber + '\'' +
                ", shortCode='" + shortCode + '\'' +
                '}';
    }
}
