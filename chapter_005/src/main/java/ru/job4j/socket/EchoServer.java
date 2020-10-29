package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isActive = true;
            while (isActive) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String msg = "HTTP/1.1 200 OKK\r\n\\";
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            msg = "HTTP/1.1 200 Shutdown!\r\n\\";
                            isActive = false;
                            server.close();
                        }
                    }
                    out.write(msg.getBytes());
                }
            }
        }
    }
}
