package ilcarro.ilcarro.dto.searchDto;

import ilcarro.ilcarro.dto.carDto.CarResponseDto;

import java.util.List;

public class SearchDto {
    private int currentPage;
    private int itemsOnPage;
    private int itemsTotal;
    private List<CarResponseDto> cars;

    public SearchDto(Integer currentPage, Integer itemsOnPage, Integer itemsTotal, List<CarResponseDto> cars) {
        this.currentPage = currentPage;
        this.itemsOnPage = itemsOnPage;
        this.itemsTotal = itemsTotal;
        this.cars = cars;
    }

    public SearchDto() {
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getItemsOnPage() {
        return itemsOnPage;
    }

    public void setItemsOnPage(Integer itemsOnPage) {
        this.itemsOnPage = itemsOnPage;
    }

    public Integer getItemsTotal() {
        return itemsTotal;
    }

    public void setItemsTotal(Integer itemsTotal) {
        this.itemsTotal = itemsTotal;
    }

    public List<CarResponseDto> getCars() {
        return cars;
    }

    public void setCars(List<CarResponseDto> cars) {
        this.cars = cars;
    }
}
