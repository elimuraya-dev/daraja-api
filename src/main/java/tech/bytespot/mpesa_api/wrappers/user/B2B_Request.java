package tech.bytespot.mpesa_api.wrappers.user;

/**
 * * User request parameters for B2B request
 *
 * @author eli_muraya on 27/10/2019 .
 */
public class B2B_Request {
    private String amount;
    private String comment;
    // Possible values for command id : BusinessPayBill, MerchantToMerchantTransfer, MerchantTransferFromMerchantToWorking, MerchantServicesMMFAccountTransfer, AgencyFloatAdvance
    private String commandId;
    private String receivingTillNo;
    private Integer senderIdentifierType;
    private Integer receiverIdentifierType;
    private String accountReference;

    private B2B_Request() {
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

    public String getReceivingTillNo() {
        return receivingTillNo;
    }

    public Integer getSenderIdentifierType() {
        return senderIdentifierType;
    }

    public Integer getReceiverIdentifierType() {
        return receiverIdentifierType;
    }

    public String getAccountReference() {
        return accountReference;
    }

    /**
     * Builder defination
     */
    public static class B2BBuilder {
        private String amount;
        private String comment;
        private String commandId;
        private String receivingTillNo;
        private Integer senderIdentifierType;
        private Integer receiverIdentifierType;
        private String accountReference;

        public B2BBuilder() {
        }

        public B2B_Request.B2BBuilder sendToTillNo(String receivingTillNo) {
            this.receivingTillNo = receivingTillNo;
            return this;
        }

        public B2B_Request.B2BBuilder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public B2B_Request.B2BBuilder withReferenceNo(String referenceNo) {
            this.accountReference = referenceNo;
            return this;
        }

        public B2B_Request.B2BBuilder withCommandId(String commandId) {
            this.commandId = commandId;
            return this;
        }

        public B2B_Request.B2BBuilder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public B2B_Request.B2BBuilder setSenderIdentifierType(Integer senderIdentifierType) {
            this.senderIdentifierType = senderIdentifierType;
            return this;
        }

        public B2B_Request.B2BBuilder setReceiverIdentifierType(Integer receiverIdentifierType) {
            this.receiverIdentifierType = receiverIdentifierType;
            return this;
        }

        public B2B_Request build() {
            B2B_Request request = new B2B_Request();
            request.amount = this.amount;
            request.comment = this.comment;
            request.commandId = this.commandId;
            request.receivingTillNo = this.receivingTillNo;
            request.senderIdentifierType = this.senderIdentifierType;
            request.receiverIdentifierType = this.receiverIdentifierType;
            request.accountReference = this.accountReference;
            return request;
        }


    }

    public static B2BBuilder builder() {
        return new B2BBuilder();
    }

}
