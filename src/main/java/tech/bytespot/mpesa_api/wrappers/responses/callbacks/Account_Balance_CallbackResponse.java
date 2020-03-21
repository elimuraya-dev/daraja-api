package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import tech.bytespot.mpesa_api.wrappers.base.B2C_Resp;

/**
 * Wrapper class for B2C response
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class Account_Balance_CallbackResponse extends B2C_CallbackResponse {
    public Account_Balance_CallbackResponse() {
    }

    public Account_Balance_CallbackResponse(B2C_Resp result) {
        super(result);
    }

    @Override
    public String toString() {
        return "Account_Balance_CallbackResponse{}";
    }
}
