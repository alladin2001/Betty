package com.company.server.abstractions;

import com.company.server.abstractions.protocolutils.ProtocolIdentifier;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author yarovitchukpo
 * @version $
 */
public abstract class Server {
    private static final int DEFAULT_PORT = 80;

    protected final ServerSocket serverSocket;
    protected final ProtocolIdentifier identifier;

    private final int port;

    public Server(ProtocolIdentifier identifier) throws IOException {
        this.identifier = identifier;
        this.port = DEFAULT_PORT;
        serverSocket = new ServerSocket(this.port);
    }

    public Server(ProtocolIdentifier identifier, int port) throws IOException {
        this.identifier = identifier;
        this.port = port;
        serverSocket = new ServerSocket(this.port);
    }

    public abstract void start();
}
