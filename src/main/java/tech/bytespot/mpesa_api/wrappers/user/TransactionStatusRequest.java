package tech.bytespot.mpesa_api.wrappers.user;

/**
 * User request parameters for Transaction status request
 *
 * @author eli_muraya on 28/10/2019 .
 */
public class TransactionStatusRequest {
    private String transactionId;
    private String identifierType;
    private String comment;
    private String occasion;


    private TransactionStatusRequest() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public String getComment() {
        return comment;
    }

    public String getOccasion() {
        return occasion;
    }

    /**
     * Builder defination
     */
    public static class TransactionStatusBuilder {
        private String transactionId;
        private String identifierType;
        private String comment;
        private String occasion;

        public TransactionStatusBuilder() {
        }

        public TransactionStatusRequest.TransactionStatusBuilder forTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public TransactionStatusRequest.TransactionStatusBuilder useIdentifierType(String identifierType) {
            this.identifierType = identifierType;
            return this;
        }

        public TransactionStatusRequest.TransactionStatusBuilder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public TransactionStatusRequest.TransactionStatusBuilder withOccasion(String occasion) {
            this.occasion = occasion;
            return this;
        }

        public TransactionStatusRequest build() {
            TransactionStatusRequest request = new TransactionStatusRequest();
            request.transactionId = this.transactionId;
            request.identifierType = this.identifierType;
            request.comment = this.comment;
            request.occasion = this.occasion;
            return request;
        }

    }

    public static TransactionStatusBuilder builder() {
        return new TransactionStatusBuilder();
    }
}
