package com.example.ex4;


import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import static android.content.ContentValues.TAG;

public class TcpClient {

    private String ip;
    private int port;
    private Socket socket;
    private Map<String, String> paths = new HashMap<>();
    private static TcpClient tcpClientInstance = null;

    /**
     * Constructor.
     */
    public TcpClient() {
        this.paths.put("Aileron", "/controls/flight/aileron");
        this.paths.put("Elevator", "/controls/flight/elevator");
    }

    /**
     * Singleton.
     * @return the instance.
     */
    public static TcpClient Instance() {
        if (tcpClientInstance == null){
            tcpClientInstance = new TcpClient();
        }
        return tcpClientInstance;
    }

    /**
     * Connects to the server.
     * @param tempIp
     * @param tempPort
     */
    public void connect(String tempIp, int tempPort) {
        this.ip = tempIp;
        this.port = tempPort;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    InetAddress serverAddress = InetAddress.getByName(ip);
                    socket = new Socket(serverAddress, port);
                } catch (IOException e) {
                    Log.e("TCP", "C: Error", e);
                    System.out.println((e.toString()));
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }


    /**
     * Sends the command to the flight simulator.
     * @param command
     */
    public void sendCommand(final String command) {
        try {
            System.out.println(command);
            Runnable runnable = new Runnable() {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

                @Override
                public void run() {
                    if (printWriter != null) {
                        Log.d(TAG, "Sending: " + command);
                        printWriter.println(command);
                        printWriter.flush();
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        } catch (Exception e) {
            Log.e("TCP", "C: Error", e);
            close();
        }
    }

    /**
     * Closes the connection.
     */
    public void close() {
        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (IOException e) {
                Log.e("TCP", "C: Error", e);
                System.out.println((e.toString()));
            }
        }
    }
}
