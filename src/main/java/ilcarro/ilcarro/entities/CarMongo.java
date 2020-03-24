package ilcarro.ilcarro.entities;

import ilcarro.ilcarro.dto.Location;
import ilcarro.ilcarro.dto.carDto.CarRequestDto;
import ilcarro.ilcarro.dto.carDto.OwnerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarMongo {

    private String serialNumber;
    private String make;
    private String model;
    private int year;
    private String engine;
    private String fuel;
    private String gear;
    private String wheelsDrive;
    private int doors;
    private int seats;
    private float fuelConsumption;
    private List<String> features;
    private String carClass;
    private float pricePerDay;
    private float distance;
    private String about;
    private Location pickUpPlace;
    private List<String> imageUrl;
    private List<OwnerBookedPeriod> bookedPeriod;

    public CarMongo(String serialNumber, String make, String model, int year, String engine, String fuel,
                    String gear, String wheelsDrive, int doors, int seats, float fuelConsumption, List<String> features,
                    String carClass, float pricePerDay, float distance, String about, Location pickUpPlace,
                    List<String> imageUrl, List<OwnerBookedPeriod> bookedPeriod) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.fuel = fuel;
        this.gear = gear;
        this.wheelsDrive = wheelsDrive;
        this.doors = doors;
        this.seats = seats;
        this.fuelConsumption = fuelConsumption;
        this.features = features;
        this.carClass = carClass;
        this.pricePerDay = pricePerDay;
        this.distance = distance;
        this.about = about;
        this.pickUpPlace = pickUpPlace;
        this.imageUrl = imageUrl;
        this.bookedPeriod = bookedPeriod;
    }

    public CarMongo(String serialNumber, String make, String model, int year, String engine, String fuel, String gear,
                    String wheelsDrive, int doors, int seats, float fuelConsumption,
                    List<String> features, String carClass, float pricePerDay, float distance, String about,
                    Location pickUpPlace, List<String> imageUrl) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.fuel = fuel;
        this.gear = gear;
        this.wheelsDrive = wheelsDrive;
        this.doors = doors;
        this.seats = seats;
        this.fuelConsumption = fuelConsumption;
        this.features = features;
        this.carClass = carClass;
        this.pricePerDay = pricePerDay;
        this.distance = distance;
        this.about = about;
        this.pickUpPlace = pickUpPlace;
        this.imageUrl = imageUrl;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getWheelsDrive() {
        return wheelsDrive;
    }

    public void setWheelsDrive(String wheelsDrive) {
        this.wheelsDrive = wheelsDrive;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Location getPickUpPlace() {
        return pickUpPlace;
    }

    public void setPickUpPlace(Location pickUpPlace) {
        this.pickUpPlace = pickUpPlace;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }


    public List<OwnerBookedPeriod> getBookedPeriod() {
        return bookedPeriod;
    }

    public void setBookedPeriod(List<OwnerBookedPeriod> bookedPeriod) {
        this.bookedPeriod = bookedPeriod;
    }

    public CarMongo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMongo carMongo = (CarMongo) o;
        return year == carMongo.year &&
                doors == carMongo.doors &&
                seats == carMongo.seats &&
                Float.compare(carMongo.fuelConsumption, fuelConsumption) == 0 &&
                Float.compare(carMongo.pricePerDay, pricePerDay) == 0 &&
                Float.compare(carMongo.distance, distance) == 0 &&
                Objects.equals(serialNumber, carMongo.serialNumber) &&
                Objects.equals(make, carMongo.make) &&
                Objects.equals(model, carMongo.model) &&
                Objects.equals(engine, carMongo.engine) &&
                Objects.equals(fuel, carMongo.fuel) &&
                Objects.equals(gear, carMongo.gear) &&
                Objects.equals(wheelsDrive, carMongo.wheelsDrive) &&
                Objects.equals(features, carMongo.features) &&
                Objects.equals(carClass, carMongo.carClass) &&
                Objects.equals(about, carMongo.about) &&
                Objects.equals(pickUpPlace, carMongo.pickUpPlace) &&
                Objects.equals(imageUrl, carMongo.imageUrl) &&
                Objects.equals(bookedPeriod, carMongo.bookedPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, make, model, year, engine, fuel, gear, wheelsDrive, doors, seats, fuelConsumption, features, carClass, pricePerDay, distance, about, pickUpPlace, imageUrl, bookedPeriod);
    }
}
