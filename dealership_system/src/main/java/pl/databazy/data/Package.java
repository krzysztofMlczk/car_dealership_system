package pl.databazy.data;

public class Package {

    String name;
    int price;
    
    public Package(String name, int price) {
        
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