package mastercard;

public class Person {
    private String firstName;
    private String lastName;
    private boolean hideAddress;
    private Address address;

    public Person(String firstName, String lastName, boolean hideAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hideAddress = hideAddress;
        this.address = address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public class Address {
        private String street;
        private String city;
        private int houseNumber;

        public Address(String street, String city, int houseNumber) {
            this.street = street;
            this.city = city;
            this.houseNumber = houseNumber;
        }

        public String getPublicAddress() {
            if (hideAddress) {
                return "Hidden";
            }
            return String.format("%d %s, %s", houseNumber, street, city);
        }
    }
}