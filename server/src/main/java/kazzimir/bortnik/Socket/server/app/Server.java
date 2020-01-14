package kazzimir.bortnik.Socket.server.app;

import kazzimir.bortnik.Socket.server.servise.ClientService;
import kazzimir.bortnik.Socket.server.servise.impl.ClientServiceImpl;

import java.io.IOException;

public class Server {
    private final static ClientService clientService = ClientServiceImpl.getInstance();

    public static void main(String[] args) throws IOException {
        clientService.createServerSocket(8888, null);
    }
}
