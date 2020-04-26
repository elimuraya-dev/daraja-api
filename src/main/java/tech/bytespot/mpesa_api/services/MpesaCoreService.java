package tech.bytespot.mpesa_api.services;

import tech.bytespot.mpesa_api.configurations.HttpConfiguration;
import tech.bytespot.mpesa_api.templates.MpesaCoreTemplate;
import tech.bytespot.mpesa_api.utils.MpesaException;
import tech.bytespot.mpesa_api.wrappers.requests.*;
import tech.bytespot.mpesa_api.wrappers.responses.C2B_Response;
import tech.bytespot.mpesa_api.wrappers.responses.MpesaGeneralResponse;
import tech.bytespot.mpesa_api.wrappers.responses.STK_Response;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public class MpesaCoreService implements MpesaCoreTemplate {

    private MpesaHelpers mpesaHelpers;

    public MpesaCoreService(MpesaHelpers mpesaHelpers) {
        this.mpesaHelpers = mpesaHelpers;
    }

  /**
   * Call MPesa API for STK Push
   *
   * @param stkPushRequest
   * @return
   */
  @Override
  public STK_Response stk_push_request(STK_Push_Request stkPushRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
    STK_Response response = (STK_Response) mpesaHelpers.httpPostRequest(url, accessToken, stkPushRequest, STK_Response.class, httpConfiguration);
    return response;
  }

    /**
     * Call MPesa API for STK Push Query
     *
     * @param stkPushQueryRequest
     * @return
     */
    @Override
    public STK_Response stk_push_query_request(STK_Push_Query_Request stkPushQueryRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
      STK_Response response = (STK_Response) mpesaHelpers.httpPostRequest(url, accessToken, stkPushQueryRequest, STK_Response.class, httpConfiguration);
      return response;
    }

  /**
   * Call Mpesa API for B2C request
   *
   * @param request
   * @param accessToken
   * @return
   */
  @Override
  public MpesaGeneralResponse b2c_request(B2C_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
    MpesaGeneralResponse response = (MpesaGeneralResponse) mpesaHelpers.httpPostRequest(url, accessToken, request, MpesaGeneralResponse.class, httpConfiguration);
    return response;
  }

  @Override
  public MpesaGeneralResponse b2b_request(B2B_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
    MpesaGeneralResponse response = (MpesaGeneralResponse) mpesaHelpers.httpPostRequest(url, accessToken, request, MpesaGeneralResponse.class, httpConfiguration);
    return response;
  }

  /**
   * Call Mpesa API for Reversal request
   *
   * @param request
   * @param accessToken
   * @param url
   * @return
   */
  @Override
  public MpesaGeneralResponse reversal_request(Reversal_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
    MpesaGeneralResponse response = (MpesaGeneralResponse) mpesaHelpers.httpPostRequest(url, accessToken, request, MpesaGeneralResponse.class, httpConfiguration);
    return response;
  }

  /**
   * Call Mpesa API for Transaction status request
   *
   * @param request
   * @param accessToken
   * @param url
   * @return
   */
  @Override
  public MpesaGeneralResponse transaction_status_request(Transaction_Status_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
    MpesaGeneralResponse response = (MpesaGeneralResponse) mpesaHelpers.httpPostRequest(url, accessToken, request, MpesaGeneralResponse.class, httpConfiguration);
    return response;
  }

  /**
   * Call Mpesa API for Account balance query request
   *
   * @param request
   * @param accessToken
   * @param url
   * @return
   */
  @Override
  public MpesaGeneralResponse account_balance_request(Account_Balance_Request request, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
    MpesaGeneralResponse response = (MpesaGeneralResponse) mpesaHelpers.httpPostRequest(url, accessToken, request, MpesaGeneralResponse.class, httpConfiguration);
    return response;
  }

  /**
   * Call Mpesa API for C2B register request
   *
   * @param registerRequest
   * @param accessToken
   * @param url
   * @return
   * @throws MpesaException
   */
  @Override
  public C2B_Response c2b_register_urls(C2B_Register_Request registerRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
    C2B_Response response = (C2B_Response) mpesaHelpers.httpPostRequest(url, accessToken, registerRequest, C2B_Response.class, httpConfiguration);
    return response;
  }

  /**
   * Call Mpesa API for C2B simulate request
   *
   * @param simulateRequest
   * @param accessToken
   * @param url
   * @return
   * @throws MpesaException
   */
  @Override
  public C2B_Response c2b_simulate(C2B_Simulate_Request simulateRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
    C2B_Response response = (C2B_Response) mpesaHelpers.httpPostRequest(url, accessToken, simulateRequest, C2B_Response.class, httpConfiguration);
    return response;
  }
}
