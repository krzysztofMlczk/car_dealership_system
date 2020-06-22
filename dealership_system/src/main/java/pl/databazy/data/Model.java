package pl.databazy.data;


public class Model {
	private int id;
    private String producer;
    private String model;
    private float capacity;
    private int power;
    private int basicPrice;

    public Model(int id, String producer, String model, float capacity, int power, int basicPrice) {
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.capacity = capacity;
        this.power = power;
        this.basicPrice = basicPrice;
    }

    public int getId() {
        return id;
    }

    @Override 
    public String toString() {
        return model+" | "+producer+" | "+capacity+" | "+power+" | "+basicPrice;
    }
}
