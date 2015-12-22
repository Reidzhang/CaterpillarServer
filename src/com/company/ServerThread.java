package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by zzt124 on 12/21/15.
 */
public class ServerThread extends Thread{
    // fields keeping track of client addr and port
    private int clientPort;
    private InetAddress clientAddr;
    private int clientID;
    private DatagramSocket socket;
    public ServerThread(DatagramSocket socket, DatagramPacket pk, int clientID){

        this.clientPort = pk.getPort();
        this.clientAddr = pk.getAddress();
        this.clientID = clientID;
        this.socket = socket;
    }

    public void run () {}





}
