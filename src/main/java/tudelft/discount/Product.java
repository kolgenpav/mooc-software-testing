package tudelft.discount;

public class Product {

    private final String name;
    private double price;
    private final String category;

    public Product (String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName () {
        return name;
    }

    public double getPrice () {
        return price;
    }

    public String getCategory () {
        return category;
    }

    public void setPrice (double price) {
        this.price = price;
    }
}
