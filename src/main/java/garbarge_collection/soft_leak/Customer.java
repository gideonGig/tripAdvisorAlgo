package garbarge_collection.soft_leak;

public class Customer {
    private int id;
    private final String name;

    public Customer(String name) {
        super();
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return id + " : " + name;
    }
}
