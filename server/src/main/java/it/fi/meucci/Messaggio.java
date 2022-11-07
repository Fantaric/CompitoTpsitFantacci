package it.fi.meucci;

import java.util.ArrayList;

public class Messaggio {
    
    public ArrayList<Biglietto> tickets = new ArrayList<>();

    public Messaggio(){}

    public Messaggio(ArrayList<Biglietto> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<Biglietto> getTickets() {
        return this.tickets;
    }

    public void setTickets(ArrayList<Biglietto> tickets) {
        this.tickets = tickets;
    }


}
