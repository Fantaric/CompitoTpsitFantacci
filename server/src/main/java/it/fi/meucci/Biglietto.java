package it.fi.meucci;

public class Biglietto {
    
    public int id;
    public String ticketNumber;

    public Biglietto() {}


    public Biglietto(String ticketNumber) {
        this.id++;
        this.ticketNumber = ticketNumber;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
