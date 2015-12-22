package com.company;

import java.io.IOException;
import java.net.*;

/**
 * Created by zzt124 on 12/21/15.
 */
public class UDPServer {
    private static DatagramSocket serverSocket;
    private static int server_port = 8550;
    private static int clientId = 0;

    public static void main(String[] argv) throws IOException {
        // Main function
        System.out.println("Server Start !");
        byte[] buffer = new byte[256];
        serverSocket = new DatagramSocket(server_port);
        while (true) {
            try {
                DatagramPacket initialPk = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(initialPk);
                System.out.println("SERVER: Accepted Connection");
                DatagramSocket threadSocket = new DatagramSocket();
                Thread t = new Thread(new ServerThread(threadSocket, initialPk, clientId));
            } catch (Exception e) {
                // Catch Exception
                e.printStackTrace();
            } finally {
                // Prevent from resource leak
                serverSocket.close();
            }

        }
    }

}
