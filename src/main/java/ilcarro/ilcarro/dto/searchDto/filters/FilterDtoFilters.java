package ilcarro.ilcarro.dto.searchDto.filters;

public class FilterDtoFilters {
   FuelConsumptions fuel = new FuelConsumptions("MUEL");
   FilterDto filterDto = new FilterDto("make", new Models("model1",new Years("1996",
           new Engines("engine Toyota",new Fuels("Fuel2",new Gears("Gear1",new WheelsDrives("String",
                   new FuelConsumptions("Nir"))))))));
}
