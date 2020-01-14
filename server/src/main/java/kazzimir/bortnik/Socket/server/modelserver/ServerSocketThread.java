package kazzimir.bortnik.Socket.server.modelserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerSocketThread implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(ServerSocketThread.class);
    private final ServerSocket serverSocket;

    public ServerSocketThread(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        logger.info("Starting server socket: -> {} | Thread: -> {}", serverSocket, Thread.currentThread());
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                logger.info("client connection -> {}", socket);
                createAndStartSocketThread(socket);
            }
        } catch (IOException e) {
            logger.error("Server socket: -> {} stopped because of error. Error: -> {}", serverSocket, e);
            e.printStackTrace();
        }
    }

    private void createAndStartSocketThread(Socket socket) {
        try {
            String uuid = getUUID();
            logger.info("id client[{}] : -> {}", socket, uuid);
            SocketThread socketThread = new SocketThread(socket, uuid);
            Thread thread = new Thread(socketThread);
            thread.start();
        } catch (IOException e) {
            logger.error("an error occurred while creating the client: -> {}. Error: -> {}", socket, e);
            e.printStackTrace();
        }
    }

    private String getUUID() {
        return UUID.randomUUID().toString();
    }
}
