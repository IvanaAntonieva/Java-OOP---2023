package Polymorphism.Vehicles;

public class Truck extends VehicleImpl {
    private final static Double AC_ADDITIONAL_CONSUMPTION = 1.6;
    private final static Double LOST_FUEL_AFTER_DEDUCTION = 0.95;

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(Double liters) {
        super.refuel(liters * LOST_FUEL_AFTER_DEDUCTION);
    }
}
