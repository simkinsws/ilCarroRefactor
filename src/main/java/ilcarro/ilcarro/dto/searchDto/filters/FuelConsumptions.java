package ilcarro.ilcarro.dto.searchDto.filters;

public class FuelConsumptions {
    private String fuelConsumption;

    public FuelConsumptions(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
