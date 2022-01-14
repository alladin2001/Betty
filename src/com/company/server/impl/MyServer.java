package com.company.server.impl;

import com.company.server.abstractions.Server;

import java.io.*;

/**
 * @author yarovitchukpo
 * @version $
 */
public class MyServer {

    private final Server server;

    public MyServer() throws IOException {
        server = new ServerImpl(new ProtocolIdentifierImpl());
    }

    public MyServer(int port) throws IOException {
        this.server = new ServerImpl(new ProtocolIdentifierImpl(), port);
    }

    public void start() {
        server.start();
    }
}
