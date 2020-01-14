package kazzimir.bortnik.Socket.server.servise;

import java.io.IOException;
import java.net.ServerSocket;

public interface ClientService {

    ServerSocket createServerSocket(int port, String host) throws IOException;
}
