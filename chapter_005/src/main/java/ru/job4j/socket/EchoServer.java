package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isActive = true;
            String str;
            String answer = null;
            while (isActive) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    str = in.readLine();
                    System.out.println(str);
                    String[] part1 = str.split("HTTP/");
                    String[] part2 = part1[0].split("msg=");
                    System.out.println(part2.length);
                    if (part2.length == 2) {
                        answer = part2[1];
                    }
                    if (str.contains("Bye")) {
                        answer = "Shutdown!";
                        isActive = false;
                        server.close();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                }
            }
        }
    }
}
