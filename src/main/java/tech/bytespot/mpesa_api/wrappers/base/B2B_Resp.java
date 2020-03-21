package tech.bytespot.mpesa_api.wrappers.base;

import tech.bytespot.mpesa_api.wrappers.base.simples.MultipleReferenceItems;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response wrapper for B2B request
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class B2B_Resp extends BaseResult {
    @JsonProperty("ReferenceData")
    private MultipleReferenceItems referenceData;

    public B2B_Resp() {
    }

    public B2B_Resp(MultipleReferenceItems referenceData) {
        this.referenceData = referenceData;
    }

    public B2B_Resp(Integer resultType, Integer resultCode, String resultDesc, String originatorConversationID, String conversationID, String transactionID, tech.bytespot.mpesa_api.wrappers.base.simples.ResultParameters resultParameters, MultipleReferenceItems referenceData) {
        super(resultType, resultCode, resultDesc, originatorConversationID, conversationID, transactionID, resultParameters);
        this.referenceData = referenceData;
    }

    public MultipleReferenceItems getReferenceData() {
        return referenceData;
    }

    public void setReferenceData(MultipleReferenceItems referenceData) {
        this.referenceData = referenceData;
    }
}
