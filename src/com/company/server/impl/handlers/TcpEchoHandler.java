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
public class TcpEchoHandler implements ProtocolHandler {

    @Override
    public void interactive(Socket socket, List<String> request) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            StringBuilder builder = new StringBuilder();

            for (String str :
                    request) {
                builder.append(str);
                builder.append("\n");
            }

            writer.write("Echo: " + builder);
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
