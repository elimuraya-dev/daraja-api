package tech.bytespot.mpesa_api.wrappers.responses.errors.bases;

/**
 * @author eli_muraya on 12/11/2019 .
 */
public class Fault {
    private String faultcode;
    private String faultstring;
    private source detail;

    public Fault() {
    }

    public Fault(String faultcode, String faultstring, source detail) {
        this.faultcode = faultcode;
        this.faultstring = faultstring;
        this.detail = detail;
    }

    public String getFaultcode() {
        return faultcode;
    }

    public void setFaultcode(String faultcode) {
        this.faultcode = faultcode;
    }

    public String getFaultstring() {
        return faultstring;
    }

    public void setFaultstring(String faultstring) {
        this.faultstring = faultstring;
    }

    public source getDetail() {
        return detail;
    }

    public void setDetail(source detail) {
        this.detail = detail;
    }
}
