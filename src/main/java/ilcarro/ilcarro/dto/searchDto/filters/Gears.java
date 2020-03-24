package ilcarro.ilcarro.dto.searchDto.filters;

public class Gears {
    private String gear;
    private WheelsDrives[] wheelsDrives;

    public Gears(String gear, WheelsDrives[] wheelsDrives) {
        this.gear = gear;
        this.wheelsDrives = wheelsDrives;
    }

    public Gears() {
    }

    public Gears(String gear1, WheelsDrives wheelsDrives) {
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public WheelsDrives[] getWheelsDrives() {
        return wheelsDrives;
    }

    public void setWheelsDrives(WheelsDrives[] wheelsDrives) {
        this.wheelsDrives = wheelsDrives;
    }
}
