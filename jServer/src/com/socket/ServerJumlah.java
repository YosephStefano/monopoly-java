package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJumlah {
static ServerSocket socket;
static final int port = 12000;
static Socket connection;
static String command = new String();
static String responseString = new String();
static int hasil,cc;
    
    public static void main(String args[]) throws IOException {
        


socket = new ServerSocket(port);
cc=0;

while(true)
{  cc++;
    connection = socket.accept();
    InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
    BufferedReader input = new BufferedReader(inputStream);
    DataOutputStream response = new DataOutputStream(connection.getOutputStream());

    command = input.readLine();
    String [] pisah = command.split(" ");
    if(pisah[0].trim().equals("T")){
      hasil=Integer.parseInt(pisah[1])+Integer.parseInt(pisah[2]);
    }
    responseString =Integer.toString(hasil);
    System.out.println(Integer.toString(cc)+":"+responseString);
    
    response.writeBytes(responseString);
    response.flush();
    response.close();
}    
    }
}