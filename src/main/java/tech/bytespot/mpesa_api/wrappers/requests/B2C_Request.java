package tech.bytespot.mpesa_api.wrappers.requests;

import tech.bytespot.mpesa_api.wrappers.base.B2B_B2C;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper class for B2C request payload to Safaricom API
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class B2C_Request extends B2B_B2C {
    @JsonProperty("Ocassion")
    private String ocassion;

    @JsonProperty("InitiatorName")
    private String initiatorName;


    public B2C_Request() {
    }

    public B2C_Request(String amount, String partyA, String partyB) {
        super(amount, partyA, partyB);
    }

    public String getOcassion() {
        return ocassion;
    }

    public void setOcassion(String ocassion) {
        this.ocassion = ocassion;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    @Override
    public String toString() {
        return "{" +
                "Ocassion='" + ocassion + '\'' +
                '}';
    }
}
