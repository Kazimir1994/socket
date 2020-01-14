package kazzimir.bortnik.Socket.server.servise.impl;

import kazzimir.bortnik.Socket.server.modelserver.ServerSocketThread;
import kazzimir.bortnik.Socket.server.servise.ClientService;

import java.io.IOException;
import java.net.ServerSocket;

public class ClientServiceImpl implements ClientService {
    private static ClientServiceImpl clientService = null;

    private ClientServiceImpl() {
    }

    public static ClientServiceImpl getInstance() {
        if (clientService == null) {
            clientService = new ClientServiceImpl();
        }
        return clientService;
    }

    @Override
    public ServerSocket createServerSocket(int port, String host) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        ServerSocketThread serverSocketThread = new ServerSocketThread(serverSocket);
        Thread thread = new Thread(serverSocketThread);
        thread.start();
        return serverSocket;
    }
}
