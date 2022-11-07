package it.fi.meucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GestioneServer g = new GestioneServer();
        try{
            g.avvia();
        }catch(Exception e){}
        
    }
}
