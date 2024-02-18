package Polymorphism.WildFarm;

import java.text.DecimalFormat;

public class Tiger extends Felime {
   private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            setFoodEaten(0 + getFoodEaten());
            System.out.printf("%ss are not eating that type of food!%n", getAnimalType());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
