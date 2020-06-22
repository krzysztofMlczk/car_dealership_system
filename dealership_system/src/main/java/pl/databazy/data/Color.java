package pl.databazy.data;

public class Color {

    String name;
    int price;
    
    public Color(String name, int price) {
        
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +" | "+ price;
    }

}