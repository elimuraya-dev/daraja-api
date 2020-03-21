package tech.bytespot.mpesa_api.wrappers.responses.errors.bases;

/**
 * @author eli_muraya on 12/11/2019 .
 */
public class detail {
  private source source;

  public detail(tech.bytespot.mpesa_api.wrappers.responses.errors.bases.source source) {
    this.source = source;
  }

  public detail() {
  }

  public tech.bytespot.mpesa_api.wrappers.responses.errors.bases.source getSource() {
    return source;
  }

  public void setSource(tech.bytespot.mpesa_api.wrappers.responses.errors.bases.source source) {
    this.source = source;
  }
}
