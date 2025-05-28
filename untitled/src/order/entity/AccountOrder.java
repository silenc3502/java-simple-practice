package order.entity;

public class AccountOrder {
    private static long idCounter = 1;

    private final long id;
    private final long accountId;
    private final long fruitId;
    private final int quantity;

    public AccountOrder(long accountId, long fruitId, int quantity) {
        this.id = idCounter++;
        this.accountId = accountId;
        this.fruitId = fruitId;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getFruitId() {
        return fruitId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "AccountOrder {" +
                "id=" + id +
                ", accountId=" + accountId +
                ", fruitId=" + fruitId +
                ", quantity=" + quantity +
                '}';
    }
}
