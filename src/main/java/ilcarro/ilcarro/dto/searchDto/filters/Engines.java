package ilcarro.ilcarro.dto.searchDto.filters;

public class Engines {
    private String engine;
    private Fuels[] fuels;

    public Engines(String engine, Fuels[] fuels) {
        this.engine = engine;
        this.fuels = fuels;
    }

    public Engines() {
    }

    public Engines(String engine_toyota, Fuels fuels) {
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Fuels[] getFuels() {
        return fuels;
    }

    public void setFuels(Fuels[] fuels) {
        this.fuels = fuels;
    }
}
