package tech.bytespot.mpesa_api.templates;


import tech.bytespot.mpesa_api.configurations.MpesaConfiguration;
import tech.bytespot.mpesa_api.utils.MpesaException;

import java.util.Map;

/**
 * @author eli_muraya on 15/10/2019 .
 */
public interface ProcessorsTemplate {

  Map<String, Object> processFields(MpesaConfiguration mpesaConfiguration) throws MpesaException, IllegalAccessException, InstantiationException;


}
