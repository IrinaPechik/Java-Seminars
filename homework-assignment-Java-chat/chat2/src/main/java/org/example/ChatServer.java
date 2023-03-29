package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    // port number for the server
    static final int PORT = 8080;
    // list of clients connected to the server
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public ChatServer() {
        // client socket, a stream that will connect to the server at a specific address and port
        Socket clientSocket = null;
        // server socket
        ServerSocket serverSocket = null;
        try {
            // create a server socket on a specific port
            serverSocket = new ServerSocket(PORT);
            System.out.println("The chat server is running...");
            // start an infinite loop
            while (true) {
                // wait for connections from clients
                clientSocket = serverSocket.accept();
                // create a client handler for the connected client
                // "this" refers to the server object
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                // handle each client connection in a new thread
                new Thread(client).start();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                // close the connection
                clientSocket.close();
                System.out.println("The chat server has stopped");
                serverSocket.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // send a message to all clients
    public void sendMessageToAllClients(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    // remove a client from the list when they exit the chat
    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}