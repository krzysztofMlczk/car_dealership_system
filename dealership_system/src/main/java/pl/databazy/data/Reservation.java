package pl.databazy.data;

import java.sql.Date;

public class Reservation {

    int reservationId;
    String imieKlienta;
    String nazwiskoKlienta;
    Date dataRezerwacji;
    String marka;
    String model;
    double pojemnoscSilnika;
    int mocSilnika;
    Date rokProdukcji;
    String kolor;
    String nazwaPakietu;
    int cenaCalkowita;
    int iloscSztuk;
    
    public Reservation(int reservationId, String imieKlienta, String nazwiskoKlienta, Date dataRezerwacji, String marka, String model, 
    double pojemnoscSilnika, int mocSilnika, Date rokProdukcji, String kolor, String nazwaPakietu, int cenaCalkowita, int iloscSztuk) {
        this.reservationId = reservationId;
        this.imieKlienta = imieKlienta;
        this.nazwiskoKlienta = nazwiskoKlienta;
        this.dataRezerwacji = dataRezerwacji;
        this.marka = marka;
        this.model = model;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.mocSilnika = mocSilnika;
        this.rokProdukcji = rokProdukcji;
        this.kolor = kolor;
        this.nazwaPakietu = nazwaPakietu;
        this.cenaCalkowita = cenaCalkowita;
        this.iloscSztuk = iloscSztuk;
    }

    public int getReservationId() {
        return this.reservationId;
    }

    @Override
    public String toString() {
        return this.imieKlienta+" | "+this.nazwiskoKlienta +" | "+this.dataRezerwacji +" | "+this.marka
         +" | "+this.model +" | "+this.pojemnoscSilnika +" | "+this.mocSilnika +" | "+this.rokProdukcji +" | "+this.kolor 
         +" | "+this.nazwaPakietu +" | "+this.cenaCalkowita +" | "+this.iloscSztuk;
    }

}