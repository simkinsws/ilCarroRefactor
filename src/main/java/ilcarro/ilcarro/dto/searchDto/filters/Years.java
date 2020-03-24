package ilcarro.ilcarro.dto.searchDto.filters;

public class Years {
    private String year;
    private Engines[] engines;

    public Years(String year, Engines[] engines) {
        this.year = year;
        this.engines = engines;
    }

    public Years() {
    }

    public Years(String year, Engines engines) {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Engines[] getEngines() {
        return engines;
    }

    public void setEngines(Engines[] engines) {
        this.engines = engines;
    }
}
