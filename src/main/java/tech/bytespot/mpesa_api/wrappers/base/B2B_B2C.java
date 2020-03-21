package tech.bytespot.mpesa_api.wrappers.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class B2B_B2C extends AmountAndPartys {
    @JsonProperty("SecurityCredential")
    private String securityCredential;

    @JsonProperty("CommandID")
    private String commandID;

    @JsonProperty("Remarks")
    private String remarks;

    @JsonProperty("QueueTimeOutURL")
    private String queueTimeOutURL;

    @JsonProperty("ResultURL")
    private String resultURL;

    public B2B_B2C() {
    }

    public B2B_B2C(String amount, String partyA, String partyB) {
        super(amount, partyA, partyB);
    }

    public String getSecurityCredential() {
        return securityCredential;
    }

    public void setSecurityCredential(String securityCredential) {
        this.securityCredential = securityCredential;
    }

    public String getCommandID() {
        return commandID;
    }

    public void setCommandID(String commandID) {
        this.commandID = commandID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getQueueTimeOutURL() {
        return queueTimeOutURL;
    }

    public void setQueueTimeOutURL(String queueTimeOutURL) {
        this.queueTimeOutURL = queueTimeOutURL;
    }

    public String getResultURL() {
        return resultURL;
    }

    public void setResultURL(String resultURL) {
        this.resultURL = resultURL;
    }

    @Override
    public String toString() {
        return "{" +
                "SecurityCredential='" + securityCredential + '\'' +
                ", CommandID='" + commandID + '\'' +
                ", Remarks='" + remarks + '\'' +
                ", QueueTimeOutURL='" + queueTimeOutURL + '\'' +
                ", ResultURL='" + resultURL + '\'' +
                '}';
    }
}
