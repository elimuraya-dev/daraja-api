package tech.bytespot.mpesa_api.wrappers.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class holds common fields for balance enquiry, status enquiry and retrial requests
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class BalanceStatusRetrivalCommons {
    @JsonProperty("SecurityCredential")
    private String securityCredential;

    @JsonProperty("CommandID")
    private String commandId;

    @JsonProperty("Remarks")
    private String remarks;

    @JsonProperty("QueueTimeOutURL")
    private String queueTimeOutURL;

    @JsonProperty("ResultURL")
    private String resultURL;

    @JsonProperty("Initiator")
    private String initiator;

    public BalanceStatusRetrivalCommons() {
    }

    public BalanceStatusRetrivalCommons(String securityCredential, String commandId, String remarks, String queueTimeOutURL, String resultURL, String initiator) {
        this.securityCredential = securityCredential;
        this.commandId = commandId;
        this.remarks = remarks;
        this.queueTimeOutURL = queueTimeOutURL;
        this.resultURL = resultURL;
        this.initiator = initiator;
    }

    public String getSecurityCredential() {
        return securityCredential;
    }

    public void setSecurityCredential(String securityCredential) {
        this.securityCredential = securityCredential;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
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

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }
}
