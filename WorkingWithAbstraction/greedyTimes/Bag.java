package WorkingWithAbstraction.greedyTimes;

import java.util.*;

import static WorkingWithAbstraction.greedyTimes.Type.*;

public class Bag {
    private List<Item> items;
    private long capacity;

    public Bag(long capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public void put(Item item) {
        if(weCanStore(item)) {
            items.add(item);
        }
    }

    private boolean weCanStore(Item item) {
        if (capacity < getTotalAmount() + item.getAmount()) {
            return false;
        }
        switch (item.getItemType()) {
            case GEM:
                if (getAmount(GEM) + item.getAmount() > getAmount(GOLD)) {
                    return false;
                }
                break;
            case CASH:
                if (getAmount(CASH) + item.getAmount() > getAmount(GEM)) {
                    return false;
                }
                break;
            }
        return true;
    }

    public long getAmount(Type itemType) {
        return this.items.stream()
                .filter(e -> e.getItemType().equals(itemType))
                .mapToLong(e -> e.getAmount())
                .sum();
    }

    public long getCount(Type itemType) {
        return this.items.stream()
                .filter(e -> e.getItemType().equals(itemType))
                .mapToLong(e -> e.getAmount())
                .count();
    }

    public long getTotalAmount() {
        return getAmount(GEM) + getAmount(CASH) + getAmount(GOLD);
    }

    private void printByItemType(Type itemType) {
        Map<String, Long> valueByName = new TreeMap<>();
        items.stream().filter(e -> e.getItemType().equals(itemType))
                .forEach(e -> {
                    String name = e.getItemName();
                    valueByName.putIfAbsent(name, 0L);
                    valueByName.put(name, valueByName.get(name) + e.getAmount());
                });
        Map<String, Long> sortedByAmount = new TreeMap<>(Collections.reverseOrder());
        valueByName.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> sortedByAmount.put(e.getKey(), e.getValue()));

        sortedByAmount.forEach((key, value) -> System.out.printf("##%s - %s%n", key, value));
    }

    public void printContent() {
        if (getCount(GOLD) > 0) {
            System.out.printf("<Gold> $%s%n", getAmount(GOLD));
            printByItemType(GOLD);
        }
        if (getCount(GEM) > 0) {
            System.out.printf("<Gem> $%s%n", getAmount(GEM));
            printByItemType(GEM);
        }
        if (getCount(CASH) > 0) {
            System.out.printf("<Cash> $%s%n", getAmount(CASH));
            printByItemType(CASH);
        }
    }
}
