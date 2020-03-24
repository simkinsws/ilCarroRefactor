package ilcarro.ilcarro.dto.searchDto.filters;

public class WheelsDrives {
    private String wheelsDrive;
    private FuelConsumptions fuelConsumptions;

    public WheelsDrives(String wheelsDrive, FuelConsumptions fuelConsumptions) {
        this.wheelsDrive = wheelsDrive;
        this.fuelConsumptions = fuelConsumptions;
    }

    public WheelsDrives() {
    }

    public String getWheelsDrive() {
        return wheelsDrive;
    }

    public void setWheelsDrive(String wheelsDrive) {
        this.wheelsDrive = wheelsDrive;
    }

    public FuelConsumptions getFuelConsumptions() {
        return fuelConsumptions;
    }

    public void setFuelConsumptions(FuelConsumptions fuelConsumptions) {
        this.fuelConsumptions = fuelConsumptions;
    }
}
