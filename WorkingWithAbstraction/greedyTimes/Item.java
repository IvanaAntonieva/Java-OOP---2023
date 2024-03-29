package WorkingWithAbstraction.greedyTimes;

public class Item {
    private Type itemType;
    private String itemName;
    private long amount;

    public Item(Type itemType, String itemName, long amount) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.amount = amount;
    }

    public Type getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public long getAmount() {
        return amount;
    }
}
