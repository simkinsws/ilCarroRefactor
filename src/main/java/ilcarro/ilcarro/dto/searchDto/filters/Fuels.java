package ilcarro.ilcarro.dto.searchDto.filters;

public class Fuels {
    private String fuel;
    private Gears[] gears;

    public Fuels(String fuel, Gears[] gears) {
        this.fuel = fuel;
        this.gears = gears;
    }

    public Fuels() {
    }

    public Fuels(String fuel2, Gears gears) {
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Gears[] getGears() {
        return gears;
    }

    public void setGears(Gears[] gears) {
        this.gears = gears;
    }
}
