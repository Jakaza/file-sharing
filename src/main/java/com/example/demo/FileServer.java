package com.example.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    private static DataInputStream dataInputStream = null;
    private static DataOutputStream dataOutputStream = null;

    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket socket = null;
        int port = 9000;
        String filePath;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Listening For Requests...");
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            if(socket != null){
                System.out.println("Closing Socket Connection....");
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public static void receiveFile(String filePath) throws IOException {
        int bytes = 0;
        long size = dataInputStream.readLong();
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        // break into chunk
        byte[] buffer = new byte[4*1024];

        while((bytes = dataInputStream.read(buffer, 0, (int) Math.max(size,buffer.length))) != -1){

        }
    }
}
