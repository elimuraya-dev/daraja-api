package tech.bytespot.mpesa_api.user;

import tech.bytespot.mpesa_api.configurations.MpesaConfiguration;
import tech.bytespot.mpesa_api.utils.MpesaException;
import tech.bytespot.mpesa_api.wrappers.responses.C2B_Response;
import tech.bytespot.mpesa_api.wrappers.responses.MpesaGeneralResponse;
import tech.bytespot.mpesa_api.wrappers.responses.STK_Response;
import tech.bytespot.mpesa_api.wrappers.user.*;

/**
 * @author eli_muraya on 16/10/2019 .
 */
public interface MpesaServiceTemplate {
  /**
   * Function used to send STK Push to the provided number via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return STK_Response response format for requests
   */
  STK_Response stkPushRequest(STKPush_Request request, MpesaConfiguration configurationClass) throws MpesaException;

  /**
   * Checks the status for a previously sent STK push
   *
   * @param checkoutRequestId
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  STK_Response stkQueryRequest(String checkoutRequestId, MpesaConfiguration configurationClass) throws MpesaException;

  /**
   * Function used to send B2C request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return MpesaGeneralResponse
   * @throws MpesaException
   */
  MpesaGeneralResponse b2cRequest(B2C_Request request, MpesaConfiguration configurationClass) throws MpesaException;

  /**
   * Function used to send B2B request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  MpesaGeneralResponse b2bRequest(B2B_Request request, MpesaConfiguration configurationClass) throws MpesaException;

  /**
   * Function used to send reversal request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  MpesaGeneralResponse reversalRequest(Reversal_Request request, MpesaConfiguration configurationClass) throws MpesaException;

  /**
   * Function used to send transaction status query request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  MpesaGeneralResponse transactionStatusRequest(TransactionStatusRequest request, MpesaConfiguration configurationClass) throws MpesaException;

  /**
   * Function used to send account balance query request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  MpesaGeneralResponse accountBalanceRequest(AccountBalanceRequest request, MpesaConfiguration configurationClass) throws MpesaException;

  /**
   * Function used to send C2B registration  request via Safaricom API
   *
   * @param registerRequest
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  C2B_Response c2bRegisterRequest(C2B_RegisterRequest registerRequest, MpesaConfiguration configurationClass) throws MpesaException;

  /**
   * Function used to send C2B simulation request via Safaricom API
   *
   * @param simulateRequest
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  C2B_Response c2bSimulateRequest(C2B_SimulateRequest simulateRequest, MpesaConfiguration configurationClass) throws MpesaException;


}
