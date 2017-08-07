package com.client.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

    private static int port = 1234;
    private static String host = "localhost";
    private static Socket connection;

    public static void main(String[] args) throws IOException {
        connection = new Socket(host, port);

        DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter your name: ");
        String name = scanner.next();
        dataOutputStream.writeUTF(name);
        System.out.println("Server Response: " + dataInputStream.readUTF());
    }
}