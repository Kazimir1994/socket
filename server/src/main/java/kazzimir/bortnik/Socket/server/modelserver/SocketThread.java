package kazzimir.bortnik.Socket.server.modelserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThread implements Runnable {
    private final Socket socket;
    private final InputStream inputStream;
    private final OutputStream outputStream;
    private final String id;

    SocketThread(Socket socket, String id) throws IOException {
        this.socket = socket;
        this.id = id;
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
    }

    @Override
    public void run() {
        try {
            BufferedReader result = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(result.readLine());

            String data = "Server1\n";
            outputStream.write(data.getBytes());
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }
}
