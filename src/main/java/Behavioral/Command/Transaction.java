package Behavioral.Command;

public class Transaction {
    private int amount;
    private String type;

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public Transaction(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }
}
