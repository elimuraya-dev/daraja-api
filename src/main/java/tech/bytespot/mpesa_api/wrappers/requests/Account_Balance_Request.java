package tech.bytespot.mpesa_api.wrappers.requests;

import tech.bytespot.mpesa_api.wrappers.base.BalanceStatusRetrivalCommons;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper class for Account Balance request payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class Account_Balance_Request extends BalanceStatusRetrivalCommons {
    @JsonProperty("PartyA")
    private String partyA;

    @JsonProperty("IdentifierType")
    private String receiverIdentifierType;


    public Account_Balance_Request() {
    }

    public Account_Balance_Request(String partyA, String receiverIdentifierType) {
        this.partyA = partyA;
        this.receiverIdentifierType = receiverIdentifierType;
    }

    public Account_Balance_Request(String securityCredential, String commandID, String remarks, String queueTimeOutURL, String resultURL, String initiator, String partyA, String receiverIdentifierType) {
        super(securityCredential, commandID, remarks, queueTimeOutURL, resultURL, initiator);
        this.partyA = partyA;
        this.receiverIdentifierType = receiverIdentifierType;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getReceiverIdentifierType() {
        return receiverIdentifierType;
    }

    public void setReceiverIdentifierType(String receiverIdentifierType) {
        this.receiverIdentifierType = receiverIdentifierType;
    }

}
