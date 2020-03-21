package tech.bytespot.mpesa_api.utils.core;

/**
 * Class holds different Safaricom command IDs
 *
 * @author eli_muraya on 15/10/2019 .
 */
public class Commands {
    /**
     * Reversal for an erroneous C2B transaction.
     */
    public static final String TransactionReversal = "TransactionReversal";

    /**
     * Used to send money from an employer to employees e.g. salaries
     */
    public static final String SalaryPayment = "SalaryPayment";


    /**
     * Used to check the balance in a paybill/buy goods account (includes utility, MMF, Merchant, Charges paid account).
     */
    public static final String AccountBalance = "AccountBalance";

    /**
     * Used to send money when promotions take place e.g. raffle winners
     */
    public static final String PromotionPayment = "PromotionPayment";

    /**
     * Used to send money from business to customer e.g. refunds
     */
    public static final String BusinessPayment = "BusinessPayment";

    /**
     * Similar to STK push, uses M-Pesa PIN as a service.
     */
    public static final String CheckIdentity = "CheckIdentity";

    /**
     * Used to query the details of a transaction.
     */
    public static final String TransactionStatusQuery = "TransactionStatusQuery";
    /**
     * Used to simulate a transaction taking place in the case of C2B Simulate Transaction or
     * to initiate a transaction on behalf of the customer (STK Push).
     */
    public static final String CustomerPayBillOnline = "CustomerPayBillOnline";


    /**
     * Transferring funds from paybills MMF to another paybills utility account.
     */
    public static final String BusinessTransferFromMMFToUtility = "BusinessTransferFromMMFToUtility";
    /**
     * Transferring funds from one paybills MMF to another paybills MMF account.
     */
    public static final String BusinessToBusinessTransfer = "BusinessToBusinessTransfer";
    /**
     * Transfer of funds from utility to MMF account.
     */
    public static final String DisburseFundsToBusiness = "DisburseFundsToBusiness";
    /**
     * sending funds from buy goods to another buy goods.
     */
    public static final String BusinessBuyGoods = "BusinessBuyGoods";
    /**
     * Sending funds from one paybill to another paybill
     */
    public static final String BusinessPayBill = "BusinessPayBill";
}
