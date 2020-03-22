package tech.bytespot.mpesa_api.wrappers.user;

/**
 * * User request parameters for account balance request
 *
 * @author eli_muraya on 28/10/2019 .
 */
public class AccountBalanceRequest {
    private String identifierType;
    private String comment;

    private AccountBalanceRequest() {
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public String getComment() {
        return comment;
    }

    /**
     * Builder defination
     */
    public static class AccountBalanceBuilder {
        private String identifierType;
        private String comment;

        public AccountBalanceBuilder() {
        }

        public AccountBalanceBuilder withIdentifierType(Integer identifierType) {
            this.identifierType = String.valueOf(identifierType);
            return this;
        }

        public AccountBalanceBuilder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public AccountBalanceRequest build() {
            AccountBalanceRequest request = new AccountBalanceRequest();
            request.identifierType = this.identifierType;
            request.comment = this.comment;
            return request;
        }
    }

    public static AccountBalanceBuilder builder() {
        return new AccountBalanceBuilder();
    }
}
