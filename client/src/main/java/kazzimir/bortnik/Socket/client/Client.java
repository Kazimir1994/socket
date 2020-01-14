package kazzimir.bortnik.Socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private static final int PORT = 8888;

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", PORT)) {
            try (OutputStream out = socket.getOutputStream();
                 InputStream inp = socket.getInputStream()) {

                String word = "33\n";
                out.write(word.getBytes());
                out.flush();
                BufferedReader result = new BufferedReader(new InputStreamReader(inp));
                System.out.println(result.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}