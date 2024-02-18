package WorkingWithAbstraction.greedyTimes;

public enum Type {
    GOLD,
    GEM,
    CASH;

    public static Type parse(String itemName) {
        if (itemName.length() == 3) {
           return Type.valueOf("CASH");
        } else if (itemName.length() >= 4 && itemName.toLowerCase().endsWith("gem")) {
            return Type.valueOf("GEM");
        } else if(itemName.equalsIgnoreCase("Gold")) {
            return Type.valueOf("GOLD");
        } else {
            throw new IllegalArgumentException("Unknown type!");
        }
    }
}
