package fruit.entity;

public class Fruit {
    private static long idCounter = 0;

    private final long id;
    private final FruitType type;
    private int quantity;
    private int price;

    public Fruit(FruitType type, int quantity, int price) {
        this.id = ++idCounter;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public FruitType getType() {
        return type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", type=" + type +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
