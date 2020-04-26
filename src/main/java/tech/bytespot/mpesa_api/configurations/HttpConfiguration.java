package tech.bytespot.mpesa_api.configurations;

/**
 * Configure http connection and read timeouts.
 * Time is in seconds
 */
public class HttpConfiguration {
  private Integer connectionTimeout;
  private Integer readTimeout;

  public HttpConfiguration() {
  }

  public HttpConfiguration(Integer connectionTimeout, Integer readTimeout) {
    this.connectionTimeout = connectionTimeout;
    this.readTimeout = readTimeout;
  }

  public Integer getConnectionTimeout() {
    return connectionTimeout;
  }

  public Integer getReadTimeout() {
    return readTimeout;
  }
}
