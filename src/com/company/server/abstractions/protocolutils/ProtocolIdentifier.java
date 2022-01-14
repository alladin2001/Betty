package com.company.server.abstractions.protocolutils;

import java.util.List;

/**
 * @author yarovitchukpo
 * @version $
 */
public interface ProtocolIdentifier {
    ProtocolHandler getHandlerForRequest(List<String> request);
}
