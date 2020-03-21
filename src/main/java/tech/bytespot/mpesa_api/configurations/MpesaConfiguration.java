package tech.bytespot.mpesa_api.configurations;

public class MpesaConfiguration {
  private String shortcode;
  private String appMode;
  private String appKey;
  private String appSecret;
  private String testMsisdn;
  private String stkCallback;
  private String passKey;
  private CallbackAndCredential b2c;
  private CallbackAndCredential b2b;
  private CallbackAndCredential reversal;
  private CallbackAndCredential status;
  private CallbackAndCredential balance;
  private C2B c2b;

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

  public String getPassKey() {
    return passKey;
  }

  public String getTestMsisdn() {
    return testMsisdn;
  }

  public String getStkCallback() {
    return stkCallback;
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

  /**
   * Class builder defination starts here
   */

  public static class MpesaConfigurationBuilder {
    private String shortcode;
    private String appMode;
    private String appKey;
    private String appSecret;
    private String testMsisdn;
    private String stkCallback;
    private String passKey;
    private CallbackAndCredential b2c;
    private CallbackAndCredential b2b;
    private CallbackAndCredential reversal;
    private CallbackAndCredential status;
    private CallbackAndCredential balance;
    private C2B c2b;

    public MpesaConfigurationBuilder() {
    }

    // Shortcode to use
    public MpesaConfiguration.MpesaConfigurationBuilder shortcode(String shortcode) {
      this.shortcode = shortcode;
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

    // Lipa-na-mpesa passkey
    public MpesaConfiguration.MpesaConfigurationBuilder withPassKey(String passKey) {
      this.passKey = passKey;
      return this;
    }

    // Shortcode test phone number
    public MpesaConfiguration.MpesaConfigurationBuilder withTestMsisdn(String testMsisdn) {
      this.testMsisdn = testMsisdn;
      return this;
    }

    // STK Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableSTK(String stkCallback) {
      this.stkCallback = stkCallback;
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

    // C2B Configurations
    public MpesaConfiguration.MpesaConfigurationBuilder enableC2B(
            String validationUrl,
            String confirmationUrl) {
      this.c2b = new C2B(
              validationUrl,
              confirmationUrl);
      return this;
    }

    public MpesaConfiguration build() {
      MpesaConfiguration config = new MpesaConfiguration();
      config.shortcode = this.shortcode;
      config.appMode = this.appMode;
      config.appKey = this.appKey;
      config.appSecret = this.appSecret;
      config.testMsisdn = this.testMsisdn;
      config.stkCallback = this.stkCallback;
      config.passKey = this.passKey;
      config.b2c = this.b2c;
      config.b2b = this.b2b;
      config.reversal = this.reversal;
      config.status = this.status;
      config.balance = this.balance;
      config.c2b = this.c2b;
      return config;
    }

  }

  public static MpesaConfigurationBuilder builder() {
    return new MpesaConfigurationBuilder();
  }


}
