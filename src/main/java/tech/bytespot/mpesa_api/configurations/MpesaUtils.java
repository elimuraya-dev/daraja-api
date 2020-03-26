package tech.bytespot.mpesa_api.configurations;

/**
 * Class holds static values to be used with @Config annotation as named values
 */
public class MpesaUtils {

  public static final String App_Mode = "app_mode";
  public static final String Test_Mode = "test_mode";
  public static final String Prod_Mode = "prod_mode";


  /**
   * AUTH variables
   */
  public static final String App_Key_Secret = "app_key_secret";
  public static final String Access_Token = "acess_token";
  public static final String URL_for_access_token = "url_for_access_token";

  /**
   * STK Push variables
   */
  public static final String URL_for_stkpush_request = "url_for_stkpush_request";

  /**
   * STK query variables
   */
  public static final String URL_for_stkpush_query_request = "url_for_stkpush_query_request";

  /**
   * B2C variables
   */
  public static final String URL_for_b2c_request = "url_for_b2c_request";

  /**
   * B2B variables
   */
  public static final String URL_for_b2b_request = "url_for_b2b_request";

  /**
   * Reversal variables
   */
  public static final String URL_for_reversal_request = "url_for_reversal_request";


  /**
   * Transaction status  variables
   */
  public static final String URL_for_transaction_status_request = "url_for_transaction_status_request";

  /**
   * Account balance   variables
   */
  public static final String URL_for_balance_request = "url_for_balance_request";

  /**
   * C2B  variables
   */
  public static final String URL_for_c2b_register_request = "url_for_c2b_register_request";
  public static final String URL_for_c2b_simulate_request = "url_for_c2b_simulate_request";


  /**
   * Error Codes
   */
  public static final Integer CODE_SUCCESS = 0;
  public static final Integer CODE_INSUFFICIENT_FUNDS = 1;
  public static final Integer CODE_LESS_THAN_MIN_TRANSACTION_VALUE = 2;
  public static final Integer CODE_MORE_THAN_MAX_TRANSACTION_VALUE = 3;
  public static final Integer CODE_EXCEED_DAILY_TRANSFER_LIMIT = 4;
  public static final Integer CODE_EXCEED_MINIMUM_BALANCE = 5;
  public static final Integer CODE_UNRESOLVED_PRIMARY_PARTY = 6;
  public static final Integer CODE_UNRESOLVED_RECEIVER_PARTY = 7;
  public static final Integer CODE_EXCEED_MAX_BALANCE = 8;

  public static final Integer CODE_INVALID_DEBIT_ACCOUNT = 11;
  public static final Integer CODE_INVALID_CREDIT_ACCOUNT = 12;
  public static final Integer CODE_UNRESOLVED_DEBIT_ACCOUNT = 13;
  public static final Integer CODE_UNRESOLVED_CREDIT_ACCOUNT = 14;
  public static final Integer CODE_DUPLICATE_DETECTED = 15;
  public static final Integer CODE_INTERNAL_FAILURE = 17;

  public static final Integer CODE_UNRESOLVED_INITIATOR = 20;
  public static final Integer CODE_BLOCKING_INCOMMING_TRAFFIC = 26;

}