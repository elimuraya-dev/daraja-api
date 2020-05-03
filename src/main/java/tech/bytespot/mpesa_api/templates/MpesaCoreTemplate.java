package tech.bytespot.mpesa_api.templates;

import tech.bytespot.mpesa_api.configurations.HttpConfiguration;
import tech.bytespot.mpesa_api.utils.MpesaException;
import tech.bytespot.mpesa_api.wrappers.requests.*;
import tech.bytespot.mpesa_api.wrappers.responses.C2B_Response;
import tech.bytespot.mpesa_api.wrappers.responses.MpesaGeneralResponse;
import tech.bytespot.mpesa_api.wrappers.responses.STK_Response;

/**
 * @author eli_muraya on 14/10/2019 .
 */
public interface MpesaCoreTemplate {

  /**
   * Call MPesa API for STK Push
   *
   * @param stkPushRequest
   * @return
   */
  STK_Response stk_push_request(STK_Push_Request stkPushRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

    /**
     * Call MPesa API for STK Push Query
     *
     * @param stkPushQueryRequest
     * @return
     */
    STK_Response stk_push_query_request(STK_Push_Query_Request stkPushQueryRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

  /**
   * Call Mpesa API for B2C request
   *
   * @param request
   * @param accessToken
   * @return
   */
  MpesaGeneralResponse b2c_request(B2C_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

  /**
   * Call Mpesa API for B2B request
   *
   * @param request
   * @param accessToken
   * @param url
   * @return
   */
  MpesaGeneralResponse b2b_request(B2B_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

  /**
   * Call Mpesa API for Reversal request
   *
   * @param request
   * @param accessToken
   * @param url
   * @return
   */
  MpesaGeneralResponse reversal_request(Reversal_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

  /**
   * Call Mpesa API for Transaction status request
   *
   * @param request
   * @param accessToken
   * @param url
   * @return
   */
  MpesaGeneralResponse transaction_status_request(Transaction_Status_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

  /**
   * Call Mpesa API for Account balance query request
   *
   * @param request
   * @param accessToken
   * @param url
   * @return
   */
  MpesaGeneralResponse account_balance_request(Account_Balance_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

  /**
   * Call Mpesa API for C2B register request
   *
   * @param registerRequest
   * @param accessToken
   * @param url
   * @return
   * @throws MpesaException
   */
  C2B_Response c2b_register_urls(C2B_Register_Request registerRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

  /**
   * Call Mpesa API for C2B simulate request
   *
   * @param simulateRequest
   * @param accessToken
   * @param url
   * @return
   * @throws MpesaException
   */
  C2B_Response c2b_simulate(C2B_Simulate_Request simulateRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

}
