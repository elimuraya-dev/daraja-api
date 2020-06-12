package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import tech.bytespot.mpesa_api.wrappers.base.B2C_Resp;

/**
 * Response wrapper for reversal request
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class Reversal_CallbackResponse extends B2C_CallbackResponse {
    public Reversal_CallbackResponse() {
    }

    public Reversal_CallbackResponse(B2C_Resp result) {
        super(result);
    }


}
