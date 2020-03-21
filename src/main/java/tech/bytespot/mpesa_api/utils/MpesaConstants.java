package tech.bytespot.mpesa_api.utils;


/**
 * @author eli_muraya on 09/10/2019 .
 */
public class MpesaConstants {

    /**
     * TEST URLs
     */
    public static String test_acces_token_url = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
    public static String test_stkpush_url = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
    public static String test_stkpush_query_url = "https://sandbox.safaricom.co.ke/mpesa/stkpushquery/v1/query";
    public static String test_b2c_url = "https://sandbox.safaricom.co.ke/mpesa/b2c/v1/paymentrequest";
    public static String test_b2b_url = "https://sandbox.safaricom.co.ke/mpesa/b2b/v1/paymentrequest";
    public static String test_reversal_url = "https://sandbox.safaricom.co.ke/mpesa/reversal/v1/request";
    public static String test_transaction_status_url = "https://sandbox.safaricom.co.ke/mpesa/transactionstatus/v1/query";
    public static String test_balance_url = "https://sandbox.safaricom.co.ke/mpesa/accountbalance/v1/query";
    public static String test_c2b_register_url = "https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl";
    public static String test_c2b_simulate_url = "https://sandbox.safaricom.co.ke/mpesa/c2b/v1/simulate";

    /**
     * PROD URLs
     */
    //TODO replace below URLs with the actual values
    public static String prod_acces_token_url = "https://api.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
    public static String prod_stkpush_url = "https://api.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
    public static String prod_stkpush_query_url = "https://api.safaricom.co.ke/mpesa/stkpushquery/v1/query";
    public static String prod_b2c_url = "https://api.safaricom.co.ke/mpesa/b2c/v1/paymentrequest";
    public static String prod_b2b_url = "https://api.safaricom.co.ke/mpesa/b2b/v1/paymentrequest";
    public static String prod_reversal_url = "https://api.safaricom.co.ke/mpesa/reversal/v1/request";
    public static String prod_transaction_status_url = "https://api.safaricom.co.ke/mpesa/transactionstatus/v1/query";
    public static String prod_balance_url = "https://api.safaricom.co.ke/mpesa/accountbalance/v1/query";
    public static String prod_c2b_register_url = "https://api.safaricom.co.ke/mpesa/c2b/v1/registerurl";
    public static String prod_c2b_simulate_url = "https://api.safaricom.co.ke/mpesa/c2b/v1/simulate";

    /**
     * APP variables
     */
    public static String SANDBOX_PK = "sandbox.cer";
    public static String PRODUCTION_PK = "production.cer";

    public static String TransactionType_CustomerPayBillOnline = "CustomerPayBillOnline";
    public static String ResponseType_Completed = "Completed";



}
