package tech.bytespot.mpesa_api.wrappers.responses.errors;

import tech.bytespot.mpesa_api.wrappers.responses.errors.bases.Envelope;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eli_muraya on 12/11/2019 .
 */
public class MpesaServerError {
    @JsonProperty("Envelope")
    private Envelope Envelope;

    public MpesaServerError() {
    }

    public MpesaServerError(tech.bytespot.mpesa_api.wrappers.responses.errors.bases.Envelope envelope) {
        Envelope = envelope;
    }

    public tech.bytespot.mpesa_api.wrappers.responses.errors.bases.Envelope getEnvelope() {
        return Envelope;
    }

    public void setEnvelope(tech.bytespot.mpesa_api.wrappers.responses.errors.bases.Envelope envelope) {
        Envelope = envelope;
    }
}
