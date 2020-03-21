package tech.bytespot.mpesa_api.utils;

import tech.bytespot.mpesa_api.wrappers.responses.errors.MpesaErrorResponse;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class MpesaException extends Exception {
    public MpesaException(String errorMessage) {
        super(errorMessage);
    }

    public MpesaException(String errorMessage, Exception ex) {
        super(errorMessage);
    }

    public MpesaException(String errorMessage, MpesaErrorResponse ex) {
        super(errorMessage);
    }

}
