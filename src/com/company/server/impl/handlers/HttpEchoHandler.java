package com.company.server.impl.handlers;

import com.company.server.abstractions.protocolutils.ProtocolHandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

/**
 * @author yarovitchukpo
 * @version $
 */
public class HttpEchoHandler implements ProtocolHandler {

    @Override
    public void interactive(Socket socket, List<String> request) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String s = String.format("HTTP/1.1 200 OK\r\n" +
                        "Server: Betty\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: %s\r\n" +
                        "Connection: close\r\n\r\n" +
                        "<html><body><h1>Hello</h1></body></html>", "<html><body><h1>Hello</h1></body></html>".length());
                writer.write(s);
                writer.newLine();
                writer.flush();
                writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isSupported(List<String> request) {
        return false;
    }
}
