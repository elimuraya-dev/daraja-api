package tech.bytespot.mpesa_api.wrappers.responses.callbacks;

import tech.bytespot.mpesa_api.wrappers.base.B2C_Resp;

/**
 * Response wrapper for transaction status query request
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class TransactionStatus_CallbackResponse extends B2C_CallbackResponse {
    public TransactionStatus_CallbackResponse() {
    }

    public TransactionStatus_CallbackResponse(B2C_Resp result) {
        super(result);
    }
}
