package tech.bytespot.mpesa_api.wrappers.user;

/**
 * User request parameters for B2C request
 *
 * @author eli_muraya on 20/10/2019 .
 */
public class B2C_Request {
    private String phoneNumber;
    private String amount;
    private String comment;
    private String commandId;
    private String ocassion;

    private B2C_Request() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }

    public String getCommandId() {
        return commandId;
    }

    public String getOcassion() {
        return ocassion;
    }

    /**
     * Builder pattern
     */
    public static class B2CBuilder {
        private String phoneNumber;
        private String amount;
        private String comment;
        private String commandId;
        private String ocassion;

        public B2CBuilder() {
        }

        public B2CBuilder forPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public B2CBuilder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public B2CBuilder withCommandId(String commandId) {
            this.commandId = commandId;
            return this;
        }

        public B2CBuilder withComment(String comment) {
            this.comment = comment;
            return this;
        }


        public B2CBuilder withOccasion(String occasion) {
            this.ocassion = occasion;
            return this;
        }

        public B2C_Request build() {
            B2C_Request request = new B2C_Request();
            request.phoneNumber = this.phoneNumber;
            request.amount = this.amount;
            request.commandId = commandId;
            request.comment = comment;
            request.ocassion = this.ocassion;
            return request;
        }

    }

    public static B2CBuilder builder() {
        return new B2CBuilder();
    }
}
