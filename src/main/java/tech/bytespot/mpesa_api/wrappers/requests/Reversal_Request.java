package tech.bytespot.mpesa_api.wrappers.requests;

import tech.bytespot.mpesa_api.wrappers.base.BalanceStatusRetrivalCommons;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * * Wrapper class for reversal request payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class Reversal_Request extends BalanceStatusRetrivalCommons {
    @JsonProperty("ReceiverParty")
    private String receiverParty;

    @JsonProperty("Amount")
    private String amount;

    @JsonProperty("RecieverIdentifierType")
    private String receiverIdentifierType;

    @JsonProperty("TransactionID")
    private String transactionID;

    @JsonProperty("Occasion")
    private String occasion;

    public Reversal_Request() {
    }

    public Reversal_Request(String receiverParty, String amount, String receiverIdentifierType, String transactionID, String occasion) {
        this.receiverParty = receiverParty;
        this.amount = amount;
        this.receiverIdentifierType = receiverIdentifierType;
        this.transactionID = transactionID;
        this.occasion = occasion;
    }

    public Reversal_Request(String securityCredential, String commandId, String remarks, String queueTimeOutURL, String resultURL, String initiator, String receiverParty, String amount, String receiverIdentifierType, String transactionID, String occasion) {
        super(securityCredential, commandId, remarks, queueTimeOutURL, resultURL, initiator);
        this.receiverParty = receiverParty;
        this.amount = amount;
        this.receiverIdentifierType = receiverIdentifierType;
        this.transactionID = transactionID;
        this.occasion = occasion;
    }

    public String getReceiverParty() {
        return receiverParty;
    }

    public void setReceiverParty(String receiverParty) {
        this.receiverParty = receiverParty;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReceiverIdentifierType() {
        return receiverIdentifierType;
    }

    public void setReceiverIdentifierType(String receiverIdentifierType) {
        this.receiverIdentifierType = receiverIdentifierType;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }
}
