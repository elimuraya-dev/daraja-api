package tech.bytespot.mpesa_api.wrappers.requests;

import tech.bytespot.mpesa_api.wrappers.base.B2B_B2C;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper class for B2B request payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class B2B_Request extends B2B_B2C {
    @JsonProperty("Initiator")
    private String initiator;

    @JsonProperty("SenderIdentifierType")
    private String senderIdentifierType;

    @JsonProperty("RecieverIdentifierType")
    private String receiverIdentifierType;

    @JsonProperty("AccountReference")
    private String accountReference;

    public B2B_Request() {
    }

    public B2B_Request(String amount, String partyA, String partyB) {
        super(amount, partyA, partyB);
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getSenderIdentifierType() {
        return senderIdentifierType;
    }

    public void setSenderIdentifierType(String senderIdentifierType) {
        this.senderIdentifierType = senderIdentifierType;
    }

    public String getReceiverIdentifierType() {
        return receiverIdentifierType;
    }

    public void setReceiverIdentifierType(String receiverIdentifierType) {
        this.receiverIdentifierType = receiverIdentifierType;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public void setAccountReference(String accountReference) {
        this.accountReference = accountReference;
    }

    @Override
    public String toString() {
        return "{" +
                "Initiator='" + initiator + '\'' +
                ", SenderIdentifierType='" + senderIdentifierType + '\'' +
                ", ReceiverIdentifierType='" + receiverIdentifierType + '\'' +
                ", AccountReference='" + accountReference + '\'' +
                '}';
    }
}
