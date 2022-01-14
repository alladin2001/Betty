package com.company.server.abstractions.protocolutils;

import java.net.Socket;
import java.util.List;

/**
 * @author yarovitchukpo
 * @version $
 */
public interface ProtocolHandler {
    void interactive(Socket socket, List<String> request);
    boolean isSupported(List<String> request);
}
