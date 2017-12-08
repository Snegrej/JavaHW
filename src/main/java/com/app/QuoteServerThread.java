package com.app;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class QuoteServerThread extends Thread {

    protected DatagramSocket socket = null;
    protected PrintWriter out = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String reply;

    public QuoteServerThread() throws IOException {
	this("QuoteServerThread");
        this.reply = "Recieved";
    }

    public QuoteServerThread(String name) throws IOException {
        super(name);
        this.reply = "Recieved";
        socket = new DatagramSocket(4445);
        try {
            out = new PrintWriter(new FileWriter("src/main/resources/sensorData.dat"));
        } catch (FileNotFoundException e) {
            System.err.println("Could not open output file.");
        }
    }

    @Override
    public void run() {
        int i = 20; //Arbitrary while loop stopping condition
        while (i>0) {
            try {
                byte[] buf = new byte[256];

                // receive request
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                buf = packet.getData();
                out.print(new String(buf,0,packet.getLength()) + " "); 
                out.println(dateFormat.format(new Date())); 

                buf = reply.getBytes();

		// send the response to the client at "address" and "port"
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            } catch (IOException e) {
		i = 0;
            }
            i--;
        }
        socket.close();
        out.close();
    }
}