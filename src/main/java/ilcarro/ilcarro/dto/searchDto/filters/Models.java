package ilcarro.ilcarro.dto.searchDto.filters;

public class Models {
    private String model;
    private Years[] years;

    public Models(String model, Years[] years) {
        this.model = model;
        this.years = years;
    }

    public Models(String model1, Years years) {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Years[] getYears() {
        return years;
    }

    public void setYears(Years[] years) {
        this.years = years;
    }
}
