package pl.databazy.data;

import java.sql.Date;

public class Car {

    private int ofertaId;
    private int id;
    private String producer;
    private String model;
    private float capacity;
    private int power;
    private String color;
    private String pack;
    private Date date;
    private int price;
    private int amount;

    public Car(int ofertaId, int id, String producer, String model, float capacity, int power, String color, String pack, Date date, int price, int amount) {
        this.ofertaId = ofertaId;
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.capacity = capacity;
        this.power = power;
        this.color = color;
        this.pack = pack;
        this.date = date;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public void setAmount(int amount) {
        this.amount = this.amount - amount;
    }

    @Override 
    public String toString() {
        return producer+" | "+model+" | "+capacity+" | "+power+" | "+color+" | "+pack+" | "+date+" | "+price+" | "+amount;
    }
}