package tech.bytespot.mpesa_api.user;

import tech.bytespot.mpesa_api.configurations.HttpConfiguration;
import tech.bytespot.mpesa_api.configurations.MpesaConfiguration;
import tech.bytespot.mpesa_api.configurations.MpesaUtils;
import tech.bytespot.mpesa_api.services.MpesaCoreService;
import tech.bytespot.mpesa_api.services.MpesaHelpers;
import tech.bytespot.mpesa_api.services.ProcessorService;
import tech.bytespot.mpesa_api.utils.MpesaConstants;
import tech.bytespot.mpesa_api.utils.MpesaException;
import tech.bytespot.mpesa_api.utils.core.Commands;
import tech.bytespot.mpesa_api.wrappers.requests.*;
import tech.bytespot.mpesa_api.wrappers.responses.C2B_Response;
import tech.bytespot.mpesa_api.wrappers.responses.MpesaGeneralResponse;
import tech.bytespot.mpesa_api.wrappers.responses.STK_Response;
import tech.bytespot.mpesa_api.wrappers.user.B2B_Request;
import tech.bytespot.mpesa_api.wrappers.user.B2C_Request;
import tech.bytespot.mpesa_api.wrappers.user.Reversal_Request;
import tech.bytespot.mpesa_api.wrappers.user.*;

import java.util.Map;

/**
 * Class holds functions called by the end user to access the libraries functionalities
 *
 * @author eli_muraya on 16/10/2019 .
 */
public class MpesaService implements MpesaServiceTemplate {
  private ProcessorService processorService;
  private MpesaHelpers mpesaHelpers;
  private MpesaCoreService mpesaCoreService;

  public MpesaService() {
    mpesaHelpers = new MpesaHelpers();
    processorService = new ProcessorService(mpesaHelpers);
    mpesaCoreService = new MpesaCoreService(mpesaHelpers);
  }

  /**
   * Function used to send STK Push to the provided number via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return STK_Response response format for requests
   */
  @Override
  public STK_Response stkPushRequest(STKPush_Request request, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);
    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var lipa_na_mpesa_online_shortcode = configurationClass.getStk().getLipaNaMpesaShortcode();
    var lipa_na_mpesa_online_passkey = configurationClass.getStk().getPassKey();
    var stk_callback_url = configurationClass.getStk().getStkCallback();
    var stk_request_url = (String) fields.get(MpesaUtils.URL_for_stkpush_request);
    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();

    var passwordGenerator = mpesaHelpers.generateStkPassword(lipa_na_mpesa_online_shortcode, lipa_na_mpesa_online_passkey);

    STK_Push_Request stkPushRequest = new STK_Push_Request();
    stkPushRequest.setBusinessShortCode(lipa_na_mpesa_online_shortcode);
    stkPushRequest.setPassword(passwordGenerator.getPassword());
    stkPushRequest.setTimestamp(passwordGenerator.getTimestamp());
    stkPushRequest.setTransactionType(MpesaConstants.TransactionType_CustomerPayBillOnline);

    stkPushRequest.setAmount(request.getAmount());
    stkPushRequest.setPartyA(request.getPhoneNumber());
    stkPushRequest.setPartyB(lipa_na_mpesa_online_shortcode);
    stkPushRequest.setPhoneNumber(request.getPhoneNumber());
    stkPushRequest.setCallBackURL(stk_callback_url);
    stkPushRequest.setAccountReference(request.getAccountReference());
    stkPushRequest.setTransactionDesc(request.getDescription());

    var response = mpesaCoreService.stk_push_request(stkPushRequest, access_token, stk_request_url, httpConfiguration);
    return response;
  }

  /**
   * Checks the status for a previously sent STK push
   *
   * @param checkoutRequestId
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  @Override
  public STK_Response stkQueryRequest(String checkoutRequestId, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);
    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var lipa_na_mpesa_online_shortcode = configurationClass.getStk().getLipaNaMpesaShortcode();
    var lipa_na_mpesa_online_passkey = configurationClass.getStk().getPassKey();
    var stk_query_request_url = (String) fields.get(MpesaUtils.URL_for_stkpush_query_request);
    var passwordGenerator = mpesaHelpers.generateStkPassword(lipa_na_mpesa_online_shortcode, lipa_na_mpesa_online_passkey);
    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();
    STK_Push_Query_Request request = new STK_Push_Query_Request();
    request.setBusinessShortCode(lipa_na_mpesa_online_shortcode);
    request.setCheckoutRequestID(checkoutRequestId);
    request.setPassword(passwordGenerator.getPassword());
    request.setTimestamp(passwordGenerator.getTimestamp());

    var response = mpesaCoreService.stk_push_query_request(request, access_token, stk_query_request_url, httpConfiguration);
    return response;
  }

  /**
   * Function used to send B2C request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  @Override
  public MpesaGeneralResponse b2cRequest(B2C_Request request, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);

    var app_mode = configurationClass.getAppMode();
    var certificateName = (app_mode.equals(MpesaUtils.Test_Mode)) ? MpesaConstants.SANDBOX_PK : MpesaConstants.PRODUCTION_PK;


    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var initiator_name = configurationClass.getB2c().getInitiatorName();
    var password = configurationClass.getB2c().getInitiatorPassword();
    var shortcode1 = configurationClass.getShortcode();
    var security_credential = (configurationClass.getB2c().getSecurityCredential() == null) ?
            mpesaHelpers.encryptInitiatorPassword(password, certificateName) : configurationClass.getB2c().getSecurityCredential();
    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();
    //In the sandbox, we use the provided test phone number by safaricom in the developer portal
    var msisdn = (configurationClass.getAppMode().equals(MpesaUtils.Test_Mode) ? configurationClass.getTestMsisdn() : request.getPhoneNumber());

    var b2c_request_url = (String) fields.get(MpesaUtils.URL_for_b2c_request);
    var timeout_request_url = configurationClass.getB2c().getTimeoutUrl();
    var b2c_callback_url = configurationClass.getB2c().getCallbackUrl();


    tech.bytespot.mpesa_api.wrappers.requests.B2C_Request b2CRequest = new tech.bytespot.mpesa_api.wrappers.requests.B2C_Request();
    b2CRequest.setInitiatorName(initiator_name);
    b2CRequest.setSecurityCredential(security_credential);
    b2CRequest.setCommandID(request.getCommandId());

    b2CRequest.setAmount(request.getAmount());
    b2CRequest.setPartyA(shortcode1);
    b2CRequest.setPartyB(msisdn);
    b2CRequest.setRemarks(request.getComment());


    b2CRequest.setQueueTimeOutURL(timeout_request_url);
    b2CRequest.setResultURL(b2c_callback_url);
    b2CRequest.setOcassion(request.getOcassion());

    var response = mpesaCoreService.b2c_request(b2CRequest, access_token, b2c_request_url, httpConfiguration);
    return response;
  }

  /**
   * Function used to send B2B request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  @Override
  public MpesaGeneralResponse b2bRequest(B2B_Request request, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);

    var app_mode = configurationClass.getAppMode();
    var certificateName = (app_mode.equals(MpesaUtils.Test_Mode)) ? MpesaConstants.SANDBOX_PK : MpesaConstants.PRODUCTION_PK;

    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var initiator_name = configurationClass.getB2b().getInitiatorName();
    var password = configurationClass.getB2b().getInitiatorPassword();
    var shortcode1 = configurationClass.getShortcode();
    var paybill = (app_mode.equals(MpesaUtils.Test_Mode) ?
            configurationClass.getShortcode2() : request.getReceivingTillNo());
    var security_credential = (configurationClass.getB2b().getSecurityCredential() == null) ?
            mpesaHelpers.encryptInitiatorPassword(password, certificateName) : configurationClass.getB2b().getSecurityCredential();
    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();


    var b2b_request_url = (String) fields.get(MpesaUtils.URL_for_b2b_request);
    var timeout_request_url = configurationClass.getB2b().getTimeoutUrl();
    var b2b_callback_url = configurationClass.getB2b().getCallbackUrl();


    tech.bytespot.mpesa_api.wrappers.requests.B2B_Request b2bRequest = new tech.bytespot.mpesa_api.wrappers.requests.B2B_Request();
    b2bRequest.setInitiator(initiator_name);
    b2bRequest.setSecurityCredential(security_credential);
    b2bRequest.setCommandID(request.getCommandId());
    b2bRequest.setAmount(request.getAmount());
    b2bRequest.setPartyA(shortcode1);
    b2bRequest.setSenderIdentifierType(String.valueOf(request.getSenderIdentifierType()));
    b2bRequest.setPartyB(paybill);
    b2bRequest.setReceiverIdentifierType(String.valueOf(request.getReceiverIdentifierType()));
    b2bRequest.setRemarks(request.getComment());
    b2bRequest.setQueueTimeOutURL(timeout_request_url);
    b2bRequest.setResultURL(b2b_callback_url);
    b2bRequest.setAccountReference(request.getAccountReference());

    var response = mpesaCoreService.b2b_request(b2bRequest, access_token, b2b_request_url, httpConfiguration);
    return response;
  }

  /**
   * Function used to send reversal request via Safaricom API
   * Reversals are only done for incoming payments ie STK Push or C2B.
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  @Override
  public MpesaGeneralResponse reversalRequest(Reversal_Request request, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);

    var app_mode = configurationClass.getAppMode();
    var certificateName = (app_mode.equals(MpesaUtils.Test_Mode)) ? MpesaConstants.SANDBOX_PK : MpesaConstants.PRODUCTION_PK;

    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var initiator_name = configurationClass.getReversal().getInitiatorName();

    var password = configurationClass.getReversal().getInitiatorPassword();
    var security_credential = (configurationClass.getReversal().getSecurityCredential() == null) ?
            mpesaHelpers.encryptInitiatorPassword(password, certificateName) : configurationClass.getReversal().getSecurityCredential();
    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();

    // As far as recipient type goes, 11 isnt in the docs but it works for reversals
    var recipient = configurationClass.getShortcode();
    var recipientType = "11";
    var occasion = (request.getOccasion() == null) ? request.getComment() : request.getOccasion();

    var reversal_request_url = (String) fields.get(MpesaUtils.URL_for_reversal_request);
    var timeout_request_url = configurationClass.getReversal().getTimeoutUrl();
    var reversal_callback_url = configurationClass.getReversal().getCallbackUrl();


    tech.bytespot.mpesa_api.wrappers.requests.Reversal_Request reversalRequest = new tech.bytespot.mpesa_api.wrappers.requests.Reversal_Request();
    reversalRequest.setInitiator(initiator_name);
    reversalRequest.setSecurityCredential(security_credential);
    reversalRequest.setCommandId(Commands.TransactionReversal);
    reversalRequest.setAmount(request.getAmount());
    reversalRequest.setReceiverParty(recipient);
    reversalRequest.setReceiverIdentifierType(recipientType);
    reversalRequest.setRemarks(request.getComment());
    reversalRequest.setQueueTimeOutURL(timeout_request_url);
    reversalRequest.setResultURL(reversal_callback_url);
    reversalRequest.setTransactionID(request.getTransactionId());
    reversalRequest.setOccasion(occasion);

    var response = mpesaCoreService.reversal_request(reversalRequest, access_token, reversal_request_url, httpConfiguration);
    return response;
  }

  /**
   * Function used to send transaction status query request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  @Override
  public MpesaGeneralResponse transactionStatusRequest(TransactionStatusRequest request, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);

    var app_mode = configurationClass.getAppMode();
    var shortcode = configurationClass.getShortcode();
    var certificateName = (app_mode.equals(MpesaUtils.Test_Mode)) ? MpesaConstants.SANDBOX_PK : MpesaConstants.PRODUCTION_PK;

    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var initiator_name = configurationClass.getStatus().getInitiatorName();

    var password = configurationClass.getStatus().getInitiatorPassword();
    var security_credential = (configurationClass.getStatus().getSecurityCredential() == null) ?
            mpesaHelpers.encryptInitiatorPassword(password, certificateName) : configurationClass.getStatus().getSecurityCredential();
    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();

    var request_url = (String) fields.get(MpesaUtils.URL_for_transaction_status_request);
    var timeout_request_url = configurationClass.getStatus().getTimeoutUrl();
    var callback_url = configurationClass.getStatus().getCallbackUrl();


    tech.bytespot.mpesa_api.wrappers.requests.Transaction_Status_Request transactionStatusRequest = new tech.bytespot.mpesa_api.wrappers.requests.Transaction_Status_Request();
    transactionStatusRequest.setInitiator(initiator_name);
    transactionStatusRequest.setSecurityCredential(security_credential);
    transactionStatusRequest.setCommandId(Commands.TransactionStatusQuery);
    transactionStatusRequest.setTransactionID(request.getTransactionId());
    transactionStatusRequest.setPartyA(shortcode);
    transactionStatusRequest.setIdentifierType(request.getIdentifierType());
    transactionStatusRequest.setRemarks(request.getComment());
    transactionStatusRequest.setQueueTimeOutURL(timeout_request_url);
    transactionStatusRequest.setResultURL(callback_url);
    transactionStatusRequest.setOccasion(request.getOccasion());

    var response = mpesaCoreService.transaction_status_request(transactionStatusRequest, access_token, request_url, httpConfiguration);
    return response;
  }

  /**
   * Function used to send account balance query request via Safaricom API
   *
   * @param request
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  @Override
  public MpesaGeneralResponse accountBalanceRequest(AccountBalanceRequest request, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);

    var app_mode = configurationClass.getAppMode();
    var certificateName = (app_mode.equals(MpesaUtils.Test_Mode)) ? MpesaConstants.SANDBOX_PK : MpesaConstants.PRODUCTION_PK;

    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var shortcode = configurationClass.getShortcode();
    var initiator_name = configurationClass.getBalance().getInitiatorName();

    var password = configurationClass.getBalance().getInitiatorPassword();
    var security_credential = (configurationClass.getBalance().getSecurityCredential() == null) ?
            mpesaHelpers.encryptInitiatorPassword(password, certificateName) : configurationClass.getBalance().getSecurityCredential();
    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();

    var request_url = (String) fields.get(MpesaUtils.URL_for_balance_request);
    var timeout_request_url = configurationClass.getBalance().getTimeoutUrl();
    var callback_url = configurationClass.getBalance().getCallbackUrl();

    Account_Balance_Request balanceRequest = new Account_Balance_Request();
    balanceRequest.setInitiator(initiator_name);
    balanceRequest.setSecurityCredential(security_credential);
    balanceRequest.setCommandId(Commands.AccountBalance);
    balanceRequest.setPartyA(shortcode);
    balanceRequest.setReceiverIdentifierType(request.getIdentifierType());
    balanceRequest.setRemarks(request.getComment());
    balanceRequest.setQueueTimeOutURL(timeout_request_url);
    balanceRequest.setResultURL(callback_url);

    var response = mpesaCoreService.account_balance_request(balanceRequest, access_token, request_url, httpConfiguration);
    return response;
  }

  /**
   * Function used to send C2B registration  request via Safaricom API
   *
   * @param registerRequest
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  @Override
  public C2B_Response c2bRegisterRequest(C2B_RegisterRequest registerRequest, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);

    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var shortcode = configurationClass.getShortcode();
    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();


    var request_url = (String) fields.get(MpesaUtils.URL_for_c2b_register_request);
    var validation_url = configurationClass.getC2b().getValidationUrl();
    var confirmation_url = configurationClass.getC2b().getConfirmationUrl();

    var responseType = (registerRequest.getResponseType() == null) ? MpesaConstants.ResponseType_Completed : registerRequest.getResponseType();

    C2B_Register_Request request = new C2B_Register_Request();
    request.setConfirmationURL(confirmation_url);
    request.setValidationURL(validation_url);
    request.setResponseType(responseType);
    request.setShortCode(shortcode);

    var response = mpesaCoreService.c2b_register_urls(request, access_token, request_url, httpConfiguration);
    return response;
  }

  /**
   * Function used to send C2B simulation request via Safaricom API
   *
   * @param simulateRequest
   * @param configurationClass
   * @return
   * @throws MpesaException
   */
  @Override
  public C2B_Response c2bSimulateRequest(C2B_SimulateRequest simulateRequest, MpesaConfiguration configurationClass) throws MpesaException {
    Map<String, Object> fields = processorService.processFields(configurationClass);

    var access_token = (String) fields.get(MpesaUtils.Access_Token);
    var request_url = (String) fields.get(MpesaUtils.URL_for_c2b_simulate_request);
    var shortcode = configurationClass.getShortcode();

    var httpConfiguration = (configurationClass.getHttpConfiguration() == null) ? new HttpConfiguration() :
            configurationClass.getHttpConfiguration();

    var billReference = simulateRequest.getBillRefNumber();
    //In the sandbox, we use the provided test phone number by Safaricom in the developer portal
    var msisdn = (configurationClass.getAppMode().equals(MpesaUtils.Test_Mode) ? configurationClass.getTestMsisdn() : simulateRequest.getMsisdn());

    C2B_Simulate_Request request = new C2B_Simulate_Request();
    request.setAmount(simulateRequest.getAmount());
    request.setBillRefNumber(billReference);
    request.setMsisdn(msisdn);
    request.setCommandId(simulateRequest.getCommandId());
    request.setShortCode(shortcode);

    var response = mpesaCoreService.c2b_simulate(request, access_token, request_url, httpConfiguration);
    return response;
  }

}
