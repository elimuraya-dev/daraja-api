package tech.bytespot.mpesa_api.wrappers.responses.errors.bases;

/**
 * @author eli_muraya on 12/11/2019 .
 */
public class source {
    private String errorcode;

    public source() {
    }

    public source(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
}
