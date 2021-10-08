package ru.job4j.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    /**
     * out.write(answer.getBytes()); - отправка сообщений клиенту
     * @param args
     */
    public static void main(String[] args) {
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
                    if (part2.length == 2) {
                        answer = part2[1].replace("%20", " ");
                    }
                    if (str.contains("Exit")) {
                        answer = "Shutdown server!";
                        isActive = false;
                        server.close();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                }
            }
        } catch (Exception e) {
            LOG.error("IOException in logger:", e);
        }
    }
}
