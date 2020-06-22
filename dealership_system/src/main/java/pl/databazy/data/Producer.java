package pl.databazy.data;

public class Producer {

    private String producer; 
    
    public Producer (String producer) {
        this.producer = producer;
    }

    public String getName() {
        return producer;
    }

    @Override
    public String toString() {
        return producer;
    }
}