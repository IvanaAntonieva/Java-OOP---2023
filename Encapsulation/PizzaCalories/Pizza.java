package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public double getOverallCalories() {
        return dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }

    public Pizza(String name, int count) {
        setName(name);
        setToppings(count);
    }

    public void addTopping (Topping topping) {
        toppings.add(topping);
    }

    private void setName(String name) {
        if (name.trim().length() >= 1 && name.length() <= 15) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppings(int count) {
        if (count >= 0 && count <= 10) {
        toppings = new ArrayList<>(count);
    } else {
        throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }
    public String getName() {
        return name;
    }
}
