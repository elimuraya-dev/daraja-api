package tech.bytespot.mpesa_api.wrappers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response wrapper for C2B request
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class C2B_Response {
    @JsonProperty("ConversationID")
    private String conversationId;

    @JsonProperty("OriginatorConversationID")
    private String originatorConversationId;

    @JsonProperty("ResponseDescription")
    private String responseDescription;

    public C2B_Response() {
    }

    public C2B_Response(String conversationId, String originatorConversationId, String responseDescription) {
        this.conversationId = conversationId;
        this.originatorConversationId = originatorConversationId;
        this.responseDescription = responseDescription;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getOriginatorConversationId() {
        return originatorConversationId;
    }

    public void setOriginatorConversationId(String originatorConversationId) {
        this.originatorConversationId = originatorConversationId;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    @Override
    public String toString() {
        return "{" +
                "ConversationID='" + conversationId + '\'' +
                ", OriginatorConversationID='" + originatorConversationId + '\'' +
                ", ResponseDescription='" + responseDescription + '\'' +
                '}';
    }
}
