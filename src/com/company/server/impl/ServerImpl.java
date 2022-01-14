package com.company.server.impl;

import com.company.server.abstractions.protocolutils.ProtocolHandler;
import com.company.server.abstractions.protocolutils.ProtocolIdentifier;
import com.company.server.abstractions.Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yarovitchukpo
 * @version $
 */
public class ServerImpl extends Server {

    public ServerImpl(ProtocolIdentifier identifier) throws IOException {
        super(identifier);
    }

    public ServerImpl(ProtocolIdentifier identifier, int port) throws IOException {
        super(identifier, port);
    }

    @Override
    public void start() {
        try (serverSocket) {
            while (true) {
                try (Socket accept = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()))) {
                    List<String> request = getRequest(reader);
                    ProtocolHandler handlerForRequest = identifier.getHandlerForRequest(request);
                    handlerForRequest.interactive(accept, request);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getRequest(BufferedReader reader) {
        try {
            while (!reader.ready()) ;
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
