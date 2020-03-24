package ilcarro.ilcarro.dto.searchDto.filters;

public class FilterDto {
    private String make;
    private Models models;

    public FilterDto(String make, Models models) {
        this.make = make;
        this.models = models;
    }

    public FilterDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Models getModels() {
        return models;
    }

    public void setModels(Models models) {
        this.models = models;
    }
}
