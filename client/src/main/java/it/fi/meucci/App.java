package it.fi.meucci;

import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Socket mySocket;
        GestioneClient client = new GestioneClient();
        try {
            mySocket = client.connetti();
            ThreadComunicazione tCom = new ThreadComunicazione(mySocket);
            Thread tRic = new ThreadRicezione(mySocket);
            tCom.start();
            tRic.start();
            
        } catch (Exception e) {
            System.out.println("Errore durante la connessione");
        }

        
    }
}
