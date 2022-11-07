package it.fi.meucci;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class GestioneServer {
    
    ServerSocket server = null;
    

    public Socket avvia() throws IOException {

        ServerSocket portaServer = new ServerSocket(2754);
        ArrayList<Socket> S = new ArrayList<>();

        ArrayList<Biglietto> tickets = new ArrayList<>();

        Biglietto b1 = new Biglietto("palco-1b");
        Biglietto b2 = new Biglietto("giardino-1a");
        Biglietto b3 = new Biglietto("palco-1c");
        Biglietto b4 = new Biglietto("tribuna-2e");

        tickets.add(b1);
        tickets.add(b2);
        tickets.add(b3);
        tickets.add(b4);

        for (;;) {
            
            Socket client = portaServer.accept();
            ThreadClient t1 = new ThreadClient(client, S, tickets, portaServer);
            S.add(client);
            t1.start();

        }
    }
}
