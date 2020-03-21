package tech.bytespot.mpesa_api.configurations;

/**
 * Class holds static values to be used with @Config annotation as named values
 */
public class MpesaUtils {

  public static final String App_Mode = "app_mode";
  public static final String Test_Mode = "test_mode";
  public static final String Prod_Mode = "prod_mode";

  /**
   * BUSINESS variables
   */
  public static final String Shortcode1 = "shortcode1";
  public static final String Shortcode2 = "shortcode2";

  /**
   * AUTH variables
   */
  public static final String App_Key = "app_key";
  public static final String App_Secret = "app_secret";
  public static final String App_Key_Secret = "app_key_secret";
  public static final String Access_Token = "acess_token";
  public static final String Initiator_Name = "initiator_name";
  public static final String Initiator_Password = "initiator_password";
  public static final String Reversal_Initiator_Name = "reversal_initiator_name";
  public static final String Reversal_Initiator_Password = "reversal_initiator_password";
  public static final String Status_Initiator_Name = "status_initiator_name";
  public static final String Status_Initiator_Password = "status_initiator_password";
  public static final String Balance_Initiator_Name = "balance_initiator_name";
  public static final String Balance_Initiator_Password = "balance_initiator_password";
  public static final String B2C_Initiator_Name = "b2c_initiator_name";
  public static final String B2C_Initiator_Password = "b2c_initiator_password";
  public static final String B2B_Initiator_Name = "b2b_initiator_name";
  public static final String B2B_Initiator_Password = "b2b_initiator_password";
  public static final String URL_for_access_token = "url_for_access_token";

  /**
   * STK Push variables
   */
  public static final String LipaNaMpesa_online_shortCode = "lipa_na_mpesa_online_shortcode";
  public static final String LipaNaMpesa_online_passkey = "lipa_na_mpesa_online_passkey";
  public static final String URL_for_stkpush_request = "url_for_stkpush_request";
  public static final String STK_push_callback_url = "stk_push_callback_url";

  /**
   * STK query variables
   */
  public static final String URL_for_stkpush_query_request = "url_for_stkpush_query_request";

  /**
   * B2C variables
   */
  public static final String URL_for_b2c_request = "url_for_b2c_request";
  public static final String URL_for_b2c_callback = "url_for_b2c_callback";
  public static final String URL_for_b2c_timeout = "url_for_b2c_timeout";

  /**
   * B2B variables
   */
  public static final String URL_for_b2b_request = "url_for_b2b_request";
  public static final String URL_for_b2b_callback = "url_for_b2b_callback";
  public static final String URL_for_b2b_timeout = "url_for_b2b_timeout";
  public static final String b2b_paybill = "b2b_paybill";

  /**
   * Reversal variables
   */
  public static final String URL_for_reversal_request = "url_for_reversal_request";
  public static final String URL_for_reversal_callback = "url_for_reversal_callback";
  public static final String URL_for_reversal_timeout = "url_for_reversal_timeout";


  /**
   * Transaction status  variables
   */
  public static final String URL_for_transaction_status_request = "url_for_transaction_status_request";
  public static final String URL_for_transaction_status_callback = "url_for_transaction_status_callback";
  public static final String URL_for_transaction_status_timeout = "url_for_transaction_status_timeout";

  /**
   * Account balance   variables
   */
  public static final String URL_for_balance_request = "url_for_balance_request";
  public static final String URL_for_balance_callback = "url_for_balance_callback";
  public static final String URL_for_balance_timeout = "url_for_balance_timeout";

  /**
   * C2B  variables
   */
  public static final String URL_for_c2b_register_request = "url_for_c2b_register_request";
  public static final String URL_for_c2b_simulate_request = "url_for_c2b_simulate_request";
  public static final String URL_for_c2b_validation = "url_for_c2b_validation";
  public static final String URL_for_c2b_confirmation = "url_for_c2b_confirmation";


}