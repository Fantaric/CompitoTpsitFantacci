package it.fi.meucci;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ThreadClient extends Thread {

    ServerSocket portaServer;
    Socket client;
    ArrayList<Socket> S;
    ArrayList<Biglietto> tickets;

    public ThreadClient(Socket client, ArrayList<Socket> S, ArrayList<Biglietto> tickets, ServerSocket server) {
        this.client = client;
        this.portaServer = server;
        this.S = S;
        this.tickets = tickets;
    }

    public void comunica() throws IOException {

        Messaggio mes = new Messaggio(tickets);

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        
        
        for (;;) {

            String stringaclient = in.readLine();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonStr = objectMapper.writeValueAsString(mes);
                
                out.writeBytes(jsonStr + "\n");
            }catch(Exception e){}
            

            tickets = mes.getTickets();
            for (Biglietto i : tickets) {
                if (stringaclient.equals(i.getTicketNumber()))
                {
                    tickets.remove(i);
                }
           }

           

           



            
                
            
            
        }

    }

    public void run() {
        try {
            comunica();
        } catch (Exception e) {
            System.out.println("Errore durante la comunicazione");
        }

    }
}
