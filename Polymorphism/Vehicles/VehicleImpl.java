package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    public VehicleImpl(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(Double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        Double neededFuel = distance * getFuelConsumption();
        if (getFuelQuantity() >= neededFuel) {
            setFuelQuantity(getFuelQuantity() - neededFuel);
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
        } else {
            return this.getClass().getSimpleName() + " needs refueling";
        }
    }

    @Override
    public void refuel(Double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}
