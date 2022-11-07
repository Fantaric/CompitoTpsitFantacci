package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;



public class ThreadComunicazione extends Thread{
    
    public Socket socket;
    Messaggio mes = new Messaggio();
    ArrayList<Biglietto> tickets;

    public ThreadComunicazione(){}

    public ThreadComunicazione(Socket s){
        this.socket = s;
    }

    public void comunica() throws IOException {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("");

            for (;;) {
                
                
                //invio array vuoto
               /* try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonStr = objectMapper.writeValueAsString(mes);
                    
                    out.writeBytes(jsonStr + "\n");
    
                }catch(Exception e){
                    System.out.println("Errore durante la serializzazione del client");
                }
                */ 


                try { 
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonStr = objectMapper.writeValueAsString(mes);
                    
                    out.writeBytes(jsonStr + "\n");
    
                }catch(Exception e){
                    System.out.println("Errore durante la serializzazione del client");
                }

                System.out.println("Inserisci biglietti che vuoi acquistare");

                out.writeBytes(tastiera.readLine()); 
                

            }

        } catch (Exception e) {
            System.out.println("Errore di comunicazione");
        }
    }
    


    public void run() {
        try {
            comunica();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione con il server");
        }
    }
}
