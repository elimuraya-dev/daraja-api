package tech.bytespot.mpesa_api.wrappers.base;

import tech.bytespot.mpesa_api.wrappers.base.simples.SingleReferenceItem;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class B2C_Resp extends BaseResult {
    @JsonProperty("ReferenceData")
    private SingleReferenceItem referenceData;

    public B2C_Resp() {
    }

    public B2C_Resp(Integer resultType, Integer resultCode, String resultDesc, String originatorConversationID, String conversationID, String transactionID, tech.bytespot.mpesa_api.wrappers.base.simples.ResultParameters resultParameters) {
        super(resultType, resultCode, resultDesc, originatorConversationID, conversationID, transactionID, resultParameters);
    }

    public SingleReferenceItem getReferenceData() {
        return referenceData;
    }

    public void setReferenceData(SingleReferenceItem referenceData) {
        this.referenceData = referenceData;
    }
}

