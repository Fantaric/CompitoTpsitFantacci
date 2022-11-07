package it.fi.meucci;

import java.net.*;
import java.io.*;

public class GestioneClient {
    
    public GestioneClient(){}

    public Socket connetti() throws IOException {
        System.out.println("Client in esecuzione");

        Socket mySocket = new Socket("localhost", 2754);
        return mySocket;
    }
}
