package com.mycompany.app;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket client;

    public ClientThread(Socket client) {
        this.client = client;
    }

    public void run(){
        try {
            DataInputStream dataInputStream = new DataInputStream(this.client.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(this.client.getOutputStream());

            int number = dataInputStream.readInt();
            dataOutputStream.writeInt(number);
            System.out.println("Client Processed");
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
