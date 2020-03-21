package tech.bytespot.mpesa_api.wrappers.requests;

import tech.bytespot.mpesa_api.wrappers.base.BalanceStatusRetrivalCommons;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper class for transaction status request payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class Transaction_Status_Request extends BalanceStatusRetrivalCommons {
    @JsonProperty("PartyA")
    private String partyA;

    @JsonProperty("IdentifierType")
    private String identifierType;

    @JsonProperty("TransactionID")
    private String transactionID;

    @JsonProperty("Occasion")
    private String occasion;

    public Transaction_Status_Request() {
    }

    public Transaction_Status_Request(String partyA, String identifierType, String transactionID, String occasion) {
        this.partyA = partyA;
        this.identifierType = identifierType;
        this.transactionID = transactionID;
        this.occasion = occasion;
    }

    public Transaction_Status_Request(String securityCredential, String commandId, String remarks, String queueTimeOutURL, String resultURL, String initiator, String partyA, String identifierType, String transactionID, String occasion) {
        super(securityCredential, commandId, remarks, queueTimeOutURL, resultURL, initiator);
        this.partyA = partyA;
        this.identifierType = identifierType;
        this.transactionID = transactionID;
        this.occasion = occasion;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
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
