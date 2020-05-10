package tech.bytespot.mpesa_api.configurations;

import java.util.concurrent.TimeUnit;

public class MpesaConfiguration {

  private String shortcode;
  private String shortcode2;
  private String appMode;
  private String appKey;
  private String appSecret;
  private String testMsisdn;
  private String minimumBalance;
  private String appAccessToken;


  private StkSettings stk;
  private CallbackAndCredential b2c;
  private CallbackAndCredential b2b;
  private CallbackAndCredential reversal;
  private CallbackAndCredential status;
  private CallbackAndCredential balance;
  private C2B c2b;
  private HttpConfiguration httpConfiguration;

  private MpesaConfiguration() {
  }

  public String getShortcode() {
    return shortcode;
  }

  public String getAppKey() {
    return appKey;
  }

  public String getAppSecret() {
    return appSecret;
  }

  public String getAppMode() {
    return appMode;
  }


  public String getTestMsisdn() {
    return testMsisdn;
  }

  public String getShortcode2() {
    return shortcode2;
  }

  public String getMinimumBalance() {
    return minimumBalance;
  }

  public String getAppAccessToken() {
    return appAccessToken;
  }

  public void setAppAccessToken(String appAccessToken) {
    this.appAccessToken = appAccessToken;
  }

  public StkSettings getStk() {
    return stk;
  }

  public CallbackAndCredential getB2c() {
    return b2c;
  }

  public CallbackAndCredential getB2b() {
    return b2b;
  }

  public CallbackAndCredential getReversal() {
    return reversal;
  }

  public CallbackAndCredential getStatus() {
    return status;
  }

  public CallbackAndCredential getBalance() {
    return balance;
  }

  public C2B getC2b() {
    return c2b;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  /**
   * Class builder defination starts here
   */

  public static class MpesaConfigurationBuilder {

    private String shortcode;
    private String shortcode2;
    private String appMode;
    private String appKey;
    private String appSecret;
    private String testMsisdn;
    private String minimumBalance;
    private String appAccessToken;


    private StkSettings stk;
    private CallbackAndCredential b2c;
    private CallbackAndCredential b2b;
    private CallbackAndCredential reversal;
    private CallbackAndCredential status;
    private CallbackAndCredential balance;
    private C2B c2b;
    private HttpConfiguration httpConfiguration;


    public MpesaConfigurationBuilder() {
    }

    // Shortcode to use
    public MpesaConfiguration.MpesaConfigurationBuilder shortcode(String shortcode) {
      this.shortcode = shortcode;
      return this;
    }

    // Shortcode to use in sandbox for B2B transactions
    public MpesaConfiguration.MpesaConfigurationBuilder shortcode2(String shortcode) {
      this.shortcode2 = shortcode;
      return this;
    }

    //    App-mode Configuration (sandbox or prod)
    public MpesaConfiguration.MpesaConfigurationBuilder inAppMode(String appMode) {
      this.appMode = appMode;
      return this;
    }

    // Shortcode app-key
    public MpesaConfiguration.MpesaConfigurationBuilder withAppKey(String appKey) {
      this.appKey = appKey;
      return this;
    }

    // Shortcode app-secret
    public MpesaConfiguration.MpesaConfigurationBuilder withAppSecret(String appSecret) {
      this.appSecret = appSecret;
      return this;
    }

    // Shortcode test phone number
    public MpesaConfiguration.MpesaConfigurationBuilder withTestMsisdn(String testMsisdn) {
      this.testMsisdn = testMsisdn;
      return this;
    }

    // Set warning paybill balance
    public MpesaConfiguration.MpesaConfigurationBuilder setWarningBalance(String minimumBalance) {
      this.minimumBalance = minimumBalance;
      return this;
    }

    // Set access token
    public MpesaConfiguration.MpesaConfigurationBuilder setAccessToken(String accessToken) {
      this.appAccessToken = accessToken;
      return this;
    }

    // STK Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableSTK(String lipaNaMpesaShortcode,
        String passkey, String stkCallback) {
      this.stk = new StkSettings(lipaNaMpesaShortcode, passkey, stkCallback);
      return this;
    }

    // B2C Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableB2C(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword) {
      this.b2c = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword);
      return this;
    }

    // B2C Configurations, with security credential
    public MpesaConfiguration.MpesaConfigurationBuilder enableB2C(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword,
        String securityCredential) {
      this.b2c = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword,
          securityCredential);
      return this;
    }

    // B2B Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableB2B(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword) {
      this.b2b = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword);
      return this;
    }

    // B2B Configurations, with security credential
    public MpesaConfiguration.MpesaConfigurationBuilder enableB2B(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword,
        String securityCrdentials) {
      this.b2b = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword,
          securityCrdentials);
      return this;
    }

    // Reversal Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableReversal(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword) {
      this.reversal = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword);
      return this;
    }

    // Reversal Configurations, with security credentials
    public MpesaConfiguration.MpesaConfigurationBuilder enableReversal(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword,
        String securityCredentials) {
      this.reversal = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword,
          securityCredentials);
      return this;
    }

    // Transaction Status Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableStatusCheck(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword) {
      this.status = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword);
      return this;
    }

    // Transaction Status Configurations, with security credential
    public MpesaConfiguration.MpesaConfigurationBuilder enableStatusCheck(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword,
        String securityCredentials) {
      this.status = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword,
          securityCredentials);
      return this;
    }


    // Balance check Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableBalanceCheck(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword) {
      this.balance = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword);
      return this;
    }

    // Balance check Configurations, with security credentials
    public MpesaConfiguration.MpesaConfigurationBuilder enableBalanceCheck(
        String callbackUrl,
        String timeoutUrl,
        String initiatorName,
        String initiatorPassword,
        String securityCredentials) {
      this.balance = new CallbackAndCredential(callbackUrl,
          timeoutUrl,
          initiatorName,
          initiatorPassword,
          securityCredentials);
      return this;
    }

    // C2B Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableC2B(
        String validationUrl,
        String confirmationUrl) {
      this.c2b = new C2B(
          validationUrl,
          confirmationUrl);
      return this;
    }

    // Configure HTTP timeouts
    public MpesaConfiguration.MpesaConfigurationBuilder setHttpTimeouts(Integer connectionTimeout,
        Integer readTimeout, TimeUnit timeUnit) {
      this.httpConfiguration = new HttpConfiguration(connectionTimeout, readTimeout, timeUnit);
      return this;
    }

    public MpesaConfiguration build() {
      MpesaConfiguration config = new MpesaConfiguration();
      config.shortcode = this.shortcode;
      config.shortcode2 = this.shortcode2;
      config.appMode = this.appMode;
      config.appKey = this.appKey;
      config.appSecret = this.appSecret;
      config.testMsisdn = this.testMsisdn;
      config.minimumBalance = this.minimumBalance;
      config.appAccessToken = this.appAccessToken;
      config.stk = this.stk;
      config.b2c = this.b2c;
      config.b2b = this.b2b;
      config.reversal = this.reversal;
      config.status = this.status;
      config.balance = this.balance;
      config.c2b = this.c2b;
      config.httpConfiguration = this.httpConfiguration;
      return config;
    }

  }

  public static MpesaConfigurationBuilder builder() {
    return new MpesaConfigurationBuilder();
  }


}
