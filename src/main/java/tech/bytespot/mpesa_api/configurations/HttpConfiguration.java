package tech.bytespot.mpesa_api.configurations;

import java.util.concurrent.TimeUnit;

/**
 * Configure http connection and read timeouts.
 * Time is in seconds
 */
public class HttpConfiguration {
  private Integer connectionTimeout;
  private Integer readTimeout;
  private TimeUnit timeUnit;

  public HttpConfiguration() {
  }

  public HttpConfiguration(Integer connectionTimeout, Integer readTimeout, TimeUnit timeUnit) {
    this.connectionTimeout = connectionTimeout;
    this.readTimeout = readTimeout;
    this.timeUnit = timeUnit;
  }

  public Integer getConnectionTimeout() {
    return connectionTimeout;
  }

  public Integer getReadTimeout() {
    return readTimeout;
  }

  public TimeUnit getTimeUnit() {
    return timeUnit;
  }
}
