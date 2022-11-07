package it.fi.meucci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ThreadRicezione extends Thread{
    
    Socket mySocket;
    ArrayList<Biglietto> tickets;
    Messaggio mes;
    
    public ThreadRicezione(){}

    public ThreadRicezione(Socket s){
        this.mySocket = s;
    }

    public void ricevi() throws IOException {
        
        
        while (true) {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            String json = in.readLine();
            

            ObjectMapper objectMapper = new ObjectMapper();
             mes = objectMapper.readValue(json, Messaggio.class);
            
            tickets = mes.getTickets();
            for (Biglietto i : tickets) {
                 System.out.println(i.getTicketNumber());
            }

            
        
        }
    }

    public void run()
    {
        try{
            ricevi();
        }catch(Exception e){System.out.println("errore durante la ricezione");}
    }
}
