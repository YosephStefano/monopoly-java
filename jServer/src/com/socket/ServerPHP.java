/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socket;

/**
 *
 * @author antookedeh
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPHP {
static ServerSocket socket;
static final int port = 12000;
static Socket connection;
static String command = new String();
static String responseString = new String();

    public static void main(String args[]) throws IOException {
        


socket = new ServerSocket(port);


while(true)
{
    // open socket
    connection = socket.accept();
    // get input reader
    InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
    BufferedReader input = new BufferedReader(inputStream);
    // get output handler
    DataOutputStream response = new DataOutputStream(connection.getOutputStream());

    // get input
    command = input.readLine();

    // process input
    //Logger.log("Command: " + command);
    responseString = command + " <br> Dari Server";

    // send response
    response.writeBytes(responseString);
    response.flush();
    response.close();
}    
    }
}