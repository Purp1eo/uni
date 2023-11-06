public class ArtObject {
    
    private char status;
    private double price;

    ArtObject(char status, double price) {
        this.status = status;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public char getStatus() {
        return status;
    }

    public String toString() {
        String description = "Kunstobjekt, Preis: " + price + ", Status: " + status;
        return description;
    }
}
