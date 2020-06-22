package pl.databazy.data;

public class Client {

    private int id;
    private String firstname;
    private String lastname;
    private String phoneNumber; 
    
    public Client (int id, String firstname, String lastname, String phoneNumber) {
        
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return firstname+" "+lastname+" "+phoneNumber;
    }

}