package tech.bytespot.mpesa_api.wrappers.responses.errors.bases;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 12/11/2019 .
 */
public class Envelope {
    @JsonProperty("encodingStyle")
    private String encodingStyle;

    @JsonProperty("Body")
    private Fault body;

    public Envelope() {
    }

    public Envelope(String encodingStyle, Fault body) {
        this.encodingStyle = encodingStyle;
        this.body = body;
    }

    public String getEncodingStyle() {
        return encodingStyle;
    }

    public void setEncodingStyle(String encodingStyle) {
        this.encodingStyle = encodingStyle;
    }

    public Fault getBody() {
        return body;
    }

    public void setBody(Fault body) {
        this.body = body;
    }
}
