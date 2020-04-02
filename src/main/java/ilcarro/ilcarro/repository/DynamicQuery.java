package ilcarro.ilcarro.repository;

public class DynamicQuery {
    String makeLike;
    String modelLike;
    Integer yearLike;
    String engineLike;
    String fuelLike;
    String gearLike;
    String wheelsDriveLike;
    Float fuelConsumptionGreaterThan;
    Float fuelConsumptionLessThan;

    public String getMakeLike() {
        return makeLike;
    }

    public void setMakeLike(String makeLike) {
        this.makeLike = makeLike;
    }

    public String getModelLike() {
        return modelLike;
    }

    public void setModelLike(String modelLike) {
        this.modelLike = modelLike;
    }

    public Integer getYearLike() {
        return yearLike;
    }

    public void setYearLike(Integer yearLike) {
        this.yearLike = yearLike;
    }

    public String getEngineLike() {
        return engineLike;
    }

    public void setEngineLike(String engineLike) {
        this.engineLike = engineLike;
    }

    public String getFuelLike() {
        return fuelLike;
    }

    public void setFuelLike(String fuelLike) {
        this.fuelLike = fuelLike;
    }

    public String getGearLike() {
        return gearLike;
    }

    public void setGearLike(String gearLike) {
        this.gearLike = gearLike;
    }

    public String getWheelsDriveLike() {
        return wheelsDriveLike;
    }

    public void setWheelsDriveLike(String wheelsDriveLike) {
        this.wheelsDriveLike = wheelsDriveLike;
    }

    public Float getFuelConsumptionGreaterThan() {
        return fuelConsumptionGreaterThan;
    }

    public void setFuelConsumptionGreaterThan(Float fuelConsumptionGreaterThan) {
        this.fuelConsumptionGreaterThan = fuelConsumptionGreaterThan;
    }

    public Float getFuelConsumptionLessThan() {
        return fuelConsumptionLessThan;
    }

    public void setFuelConsumptionLessThan(Float fuelConsumptionLessThan) {
        this.fuelConsumptionLessThan = fuelConsumptionLessThan;
    }
}
