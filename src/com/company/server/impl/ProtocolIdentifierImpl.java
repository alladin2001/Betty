package com.company.server.impl;

import com.company.server.abstractions.protocolutils.ProtocolHandler;
import com.company.server.abstractions.protocolutils.ProtocolIdentifier;
import com.company.server.impl.handlers.HttpEchoHandler;
import com.company.server.impl.handlers.TcpEchoHandler;
import com.company.server.Protocol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yarovitchukpo
 * @version $
 */
public class ProtocolIdentifierImpl implements ProtocolIdentifier {

    private final Map<Protocol, ProtocolHandler> handlers;

    public ProtocolIdentifierImpl() {
        handlers = new HashMap<>() {{
            put(Protocol.HTTP, new HttpEchoHandler());
            put(Protocol.TCP, new TcpEchoHandler());
        }};
    }

    @Override
    public ProtocolHandler getHandlerForRequest(List<String> request) {
        return handlers.values().stream()
                .filter((vale) -> vale.isSupported(request) &&
                        !(vale instanceof TcpEchoHandler))
                .findAny()
                .orElse(handlers.get(Protocol.TCP));
    }
}
