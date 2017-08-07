package com.mycompany.app;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientThread extends Thread {

    private Socket client;
    private int clientCount;

    public ClientThread(Socket client, int clientCount) {

        this.client = client;
        this.clientCount = clientCount;
    }

    public void run(){
        try {
            DataInputStream dataInputStream = new DataInputStream(this.client.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(this.client.getOutputStream());

            String cMessage = dataInputStream.readUTF();
            dataOutputStream.writeUTF("Hello " + cMessage);
            System.out.println("Client Name is " + cMessage);
            System.out.println("Client " + clientCount +  " Processed");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                this.client.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
