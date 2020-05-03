import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.bytespot.mpesa_api.configurations.MpesaConfiguration;
import tech.bytespot.mpesa_api.configurations.MpesaUtils;
import tech.bytespot.mpesa_api.user.MpesaService;
import tech.bytespot.mpesa_api.utils.MpesaConstants;
import tech.bytespot.mpesa_api.utils.MpesaException;
import tech.bytespot.mpesa_api.utils.core.Commands;
import tech.bytespot.mpesa_api.utils.core.Identifiers;
import tech.bytespot.mpesa_api.wrappers.user.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MpesaIntegrationTest {
  private final static Logger LOGGER = Logger.getLogger(MpesaIntegrationTest.class.getName());
  MpesaService mpesaService = new MpesaService();
  String appKey = System.getenv("TEST_APPKEY");
  String appSecret = System.getenv("TEST_APPSECRET");

  String testMsisdn = System.getenv("TEST_PHONE_NO");
  String teststkTransactionId = "ws_CO_260420202021051947";
  String testStkAmount = "1";
  String testB2CAmount = "10";
  String testB2BAmount = "10";
  String testAccountRef = "ACCOUNT123456789";
  String testTillNo = "123456";

  String testTransactionId = "ODQ41HBU28";
  String testComment = "TEST COMMENT";
  String testOccasion = "TEST OCCASION";

  String baseUrl = System.getenv("TEST_BASE_URL");
  String initiatorName = System.getenv("TEST_INITIATOR_NAME");
  String initiatorPassword = System.getenv("TEST_INITIATOR_PASSWORD");
  String securityCredential = System.getenv("TEST_SECURITY_CREDENTIAL");
  String passKey = System.getenv("TEST_PASSKEY");

  MpesaConfiguration payinMpesaConfiguration = MpesaConfiguration.builder()
          .shortcode("601468")
          .shortcode2("600000")
          .inAppMode(MpesaUtils.Test_Mode)
          .withAppKey(appKey)
          .withAppSecret(appSecret)
          .withTestMsisdn("254708374149")
          .enableSTK("174379",
                  passKey,
                  baseUrl + "stk")
          .enableC2B(baseUrl + "validation",
                  baseUrl + "confirmation")
          .enableReversal(baseUrl + "reversal",
                  baseUrl + "reversal",
                  initiatorName,
                  initiatorPassword,
                  securityCredential
          ).enableBalanceCheck(baseUrl + "balance",
                  baseUrl + "balance",
                  initiatorName,
                  initiatorPassword,
                  securityCredential
          ).enableStatusCheck(baseUrl + "status",
                  baseUrl + "status",
                  initiatorName,
                  initiatorPassword,
                  securityCredential
          ).setHttpTimeouts(15, 15, TimeUnit.SECONDS)
          .build();

  MpesaConfiguration payOutMpesaConfiguration = MpesaConfiguration.builder()
          .shortcode("601468")
          .shortcode2("600000")
          .inAppMode(MpesaUtils.Test_Mode)
          .withAppKey(appKey)
          .withAppSecret(appSecret)
          .withTestMsisdn("254708374149")
          .enableB2C(baseUrl + "b2c",
                  baseUrl + "b2c",
                  initiatorName,
                  initiatorPassword,
                  securityCredential
          )
          .enableB2B(baseUrl + "b2b",
                  baseUrl + "b2b",
                  initiatorName,
                  initiatorPassword,
                  securityCredential
          ).enableBalanceCheck(baseUrl + "balance",
                  baseUrl + "balance",
                  initiatorName,
                  initiatorPassword,
                  securityCredential
          ).enableStatusCheck(baseUrl + "status",
                  baseUrl + "status",
                  initiatorName,
                  initiatorPassword,
                  securityCredential
          ).setHttpTimeouts(15, 15, TimeUnit.SECONDS)
          .build();

  @Test
  void stkPushRequest() throws MpesaException {
    STKPush_Request request = STKPush_Request.builder()
            .forPhoneNumber(testMsisdn)
            .withAmount(testStkAmount)
            .withDescription("test STK push")
            .withAccountReference(testAccountRef)
            .build();
    var response = mpesaService.stkPushRequest(request, payinMpesaConfiguration);
    Assertions.assertTrue(response.getResponseCode().equals("0"), response.getResponseDescription());
  }

  @Test
  void stkPushQueryRequest() throws MpesaException {
    var response = mpesaService.stkQueryRequest(teststkTransactionId, payinMpesaConfiguration);
    Assertions.assertTrue(response.getResponseCode().equals("0"), response.getResponseDescription());
  }

  @Test
  void c2bRegistrationRequest() throws MpesaException {
    C2B_RegisterRequest request = C2B_RegisterRequest.builder()
            .withResponseType(MpesaConstants.ResponseType_Completed)
            .build();
    var response = mpesaService.c2bRegisterRequest(request, payinMpesaConfiguration);
    Assertions.assertTrue(response.getResponseDescription().equals("success"), response.getResponseDescription());
  }

  @Test
  void c2bSimulation() throws MpesaException {
    C2B_SimulateRequest request = C2B_SimulateRequest.builder()
            .forPhoneNumber(testMsisdn)
            .withAmount(testB2BAmount)
            .withReferenceNo(testAccountRef)
            .withCommandId(Commands.CustomerPayBillOnline)
            .build();
    var response = mpesaService.c2bSimulateRequest(request, payinMpesaConfiguration);
    Assertions.assertTrue(response.getResponseDescription().startsWith("Accept"), response.getResponseDescription());
  }

  @Test
  void reversalRequest() throws MpesaException {
    Reversal_Request request = Reversal_Request.builder()
            .forTransactionId(testTransactionId)
            .withAmount(testB2BAmount)
            .withComment(testComment)
            .withOccasion(testOccasion)
            .build();
    var response = mpesaService.reversalRequest(request, payinMpesaConfiguration);
    Assertions.assertTrue(response.getResponseCode().equals("0"), response.getResponseDescription());
  }

  @Test
  void transactionStatusRequest() throws MpesaException {
    TransactionStatusRequest request = TransactionStatusRequest.builder()
            .forTransactionId(testTransactionId)
            .useIdentifierType(String.valueOf(Identifiers.SHORTCODE))
            .withComment(testComment)
            .withOccasion(testOccasion)
            .build();
    var response = mpesaService.transactionStatusRequest(request, payinMpesaConfiguration);
    Assertions.assertTrue(response.getResponseCode().equals("0"), response.getResponseDescription());
  }

  @Test
  void accountBalanceRequest() throws MpesaException {
    AccountBalanceRequest request = AccountBalanceRequest.builder()
            .withComment(testComment)
            .withIdentifierType(Identifiers.SHORTCODE)
            .build();
    var response = mpesaService.accountBalanceRequest(request, payinMpesaConfiguration);
    Assertions.assertTrue(response.getResponseCode().equals("0"), response.getResponseDescription());
  }

  @Test
  void b2cRequest() throws MpesaException {
    B2C_Request request = B2C_Request.builder()
            .forPhoneNumber(testMsisdn)
            .withAmount(testB2CAmount)
            .withCommandId(Commands.PromotionPayment)
            .withOccasion(testOccasion)
            .withComment(testComment)
            .build();
    var response = mpesaService.b2cRequest(request, payOutMpesaConfiguration);
    Assertions.assertTrue(response.getResponseCode().equals("0"), response.getResponseDescription());
  }

  @Test
  void b2bRequest() throws MpesaException {
    B2B_Request request = B2B_Request.builder()
            .sendToTillNo(testTillNo)
            .setReceiverIdentifierType(Identifiers.SHORTCODE)
            .setSenderIdentifierType(Identifiers.SHORTCODE)
            .withAmount(testB2BAmount)
            .withReferenceNo(testAccountRef)
            .withAmount(testB2CAmount)
            .withCommandId(Commands.BusinessPayBill)
            .withComment(testComment)
            .build();

    payOutMpesaConfiguration.getB2b().setSecurityCredential(null);
    var response = mpesaService.b2bRequest(request, payOutMpesaConfiguration);
    Assertions.assertTrue(response.getResponseCode().equals("0"), response.getResponseDescription());
  }

}
