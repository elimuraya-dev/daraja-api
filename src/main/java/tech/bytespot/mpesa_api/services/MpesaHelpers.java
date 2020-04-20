package tech.bytespot.mpesa_api.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import tech.bytespot.mpesa_api.utils.MpesaException;
import tech.bytespot.mpesa_api.wrappers.base.simples.Password;
import tech.bytespot.mpesa_api.wrappers.responses.TokenResponse;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author eli_muraya on 09/10/2019 .
 */

public class MpesaHelpers {
  public MpesaHelpers() {
  }


  /**
   * Function encrypts  initiator password
   * * @param certificateName
   *
   * @param password
   * @return encrypted password
   */
  public String encryptInitiatorPassword(String password, String certificateName) throws MpesaException {
    String encryptedPassword;
    try {
      System.out.println("Using mpesa certificate  : " + certificateName);
      byte[] input = password.getBytes(UTF_8);
      InputStream fin = getClass()
              .getClassLoader()
              .getResourceAsStream(certificateName);

      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      X509Certificate certificate = (X509Certificate) cf.generateCertificate(fin);

      PublicKey pk = certificate.getPublicKey();
      cipher.init(Cipher.ENCRYPT_MODE, pk);

      byte[] cipherText = cipher.doFinal(input);
      // Convert the resulting encrypted byte array into a string using base64 encoding
      encryptedPassword = java.util.Base64.getEncoder().encodeToString(cipherText);

      System.out.println("password : " + encryptedPassword);

      return encryptedPassword;
    } catch (NoSuchAlgorithmException ex) {
      ex.printStackTrace();
      throw new MpesaException(ex.getMessage());

    } catch (CertificateException e) {
      e.printStackTrace();
      throw new MpesaException(e.getMessage());

    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
      throw new MpesaException(e.getMessage());

    } catch (BadPaddingException e) {
      e.printStackTrace();
      throw new MpesaException(e.getMessage());
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
      throw new MpesaException(e.getMessage());
    } catch (InvalidKeyException e) {
      e.printStackTrace();
      throw new MpesaException(e.getMessage());

    }
  }

  /**
   * Generate access_token using app_key and app_secret
   *
   * @param app_key_secret
   * @return
   */
  public TokenResponse generateAccessToken(String app_key_secret, String url) {
    byte[] bytes = app_key_secret.getBytes(StandardCharsets.ISO_8859_1);
    String encoded_key_secret = java.util.Base64.getEncoder().encodeToString(bytes);

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)

            .build();

    Request request = new Request.Builder()
            .url(url)
            .get()
            .header("authorization", "Basic " + encoded_key_secret)
            .header("cache-control", "no-cache")
            .build();

    String response = "";
    try {
      Response resp = client.newCall(request).execute();
      response = resp.body().string();

      System.out.println("MPESA Response code for token generation : " + resp.code());
      System.out.println("MPESA Response : " + response);
      var callbackResponse = mapper().readValue(response, TokenResponse.class);
      return callbackResponse;
    } catch (IOException e) {
      System.out.println("ERROR GETTING ACCESS TOKEN FROM SAFARICOM");
      e.printStackTrace();
      return new TokenResponse();
    }
  }

  /**
   * Response codes are sent from the Safaricom API.
   *
   * @return
   */
  public Map<Integer, String> resultCodes() {
    Map<Integer, String> resultCodes = new HashMap<>();
    resultCodes.put(0, "Success");
    resultCodes.put(1, "Insufficient Funds");
    resultCodes.put(2, "Less Than Minimum Transaction Value");
    resultCodes.put(3, "More Than Maximum Transaction Value");
    resultCodes.put(4, "Would Exceed Daily Transfer Limit");
    resultCodes.put(5, "Would Exceed Minimum Balance");
    resultCodes.put(6, "Unresolved Primary Party");
    resultCodes.put(7, "Unresolved Receiver Party");
    resultCodes.put(8, "Would Exceed Maxiumum Balance");

    resultCodes.put(11, "Debit Account Invalid");
    resultCodes.put(12, "Credit Account Invalid");
    resultCodes.put(13, "Unresolved Debit Account");
    resultCodes.put(14, "Unresolved Credit Account");
    resultCodes.put(15, "Duplicate Detected");
    resultCodes.put(17, "Internal Failure");

    resultCodes.put(20, "Unresolved Initiator");
    resultCodes.put(26, "Traffic blocking condition in place");
    return resultCodes;
  }

  /**
   * Response codes are sent from the clients endpoints back to the gateway.
   * This is done to acknowledge that the client has received the results.
   *
   * @return
   */
  public Map<Integer, String> responseCodes() {
    Map<Integer, String> responseCodes = new HashMap<>();
    responseCodes.put(0, "Success (for C2B)");
    responseCodes.put(00000000, "Success (For APIs that are not C2B)");
    responseCodes.put(1, "Rejecting the transaction");

    return responseCodes;
  }

  /**
   * Generic function for sending POST HTTP requests
   *
   * @param url
   * @param accessToken
   * @param body
   * @param responseClass
   * @return
   */
  public Object httpPostRequest(String url, String accessToken, Object body, Class responseClass) throws MpesaException {
    ObjectMapper mapper = mapper();
    String jsonString = null;
    try {
      jsonString = mapper.writeValueAsString(body);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new MpesaException(e.getMessage());
    }

    RequestBody requestBody = RequestBody
            .create(MediaType.parse("application/json"), jsonString);

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();

    Request request = new Request.Builder()
            .url(url)
            .post(requestBody)
            .header("authorization", "Bearer " + accessToken)
            .header("cache-control", "no-cache")
            .header("content-type", "application/json")
            .header("accept", "application/json")
            .build();

    System.out.println("MPESA Request : " + jsonString);
    String response = "";
    try {
      Response resp = client.newCall(request).execute();
      response = resp.body().string();
      System.out.println("MPESA Response : " + response);
    } catch (IOException e) {
      e.printStackTrace();
      throw new MpesaException(e.getMessage());
    }

    try {
      Object callbackResponse = new ObjectMapper().readValue(response, responseClass);
      return callbackResponse;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new MpesaException(response);

    }
  }

  /**
   * Function generates password used in STK push request
   *
   * @param businessShortCode
   * @param passkey
   * @return
   * @throws MpesaException
   */
  public Password generateStkPassword(String businessShortCode, String passkey) throws MpesaException {
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
    Date datetime = new Date(System.currentTimeMillis());
    String timestamp = sdf2.format(datetime);

    String password = businessShortCode + passkey + timestamp;
    byte[] bytes = new byte[0];
    bytes = password.getBytes(StandardCharsets.ISO_8859_1);
    String encryptedPassword = java.util.Base64.getEncoder().encodeToString(bytes);

    return new Password(encryptedPassword, timestamp);
  }


  private ObjectMapper mapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return mapper;

  }

}
