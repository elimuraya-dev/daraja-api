package tech.bytespot.mpesa_api.wrappers.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class AmountAndPartys {
    @JsonProperty("Amount")
    private String amount;

    @JsonProperty("PartyA")
    private String partyA;

    @JsonProperty("PartyB")
    private String partyB;

    public AmountAndPartys() {
    }

    public AmountAndPartys(String amount, String partyA, String partyB) {
        this.amount = amount;
        this.partyA = partyA;
        this.partyB = partyB;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

}
