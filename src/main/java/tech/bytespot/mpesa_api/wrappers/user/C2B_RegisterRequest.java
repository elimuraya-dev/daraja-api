package tech.bytespot.mpesa_api.wrappers.user;

/**
 * User request parameters for C2B register URLs request
 *
 * @author eli_muraya on 12/11/2019 .
 */
public class C2B_RegisterRequest {

    private String responseType;

    private C2B_RegisterRequest() {
    }

    public String getResponseType() {
        return responseType;
    }

    /**
     * BUILDER defination
     */
    public static class C2BRegisterBuilder {
        private String responseType;

        public C2BRegisterBuilder() {
        }

        public C2BRegisterBuilder withResponseType(String responseType) {
            this.responseType = responseType;
            return this;
        }

        public C2B_RegisterRequest build() {
            C2B_RegisterRequest registerRequest = new C2B_RegisterRequest();
            registerRequest.responseType = this.responseType;
            return registerRequest;
        }
    }

    public static C2BRegisterBuilder builder() {
        return new C2BRegisterBuilder();
    }

}
