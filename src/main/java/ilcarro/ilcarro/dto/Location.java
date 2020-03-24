package ilcarro.ilcarro.dto;

public class Location {
    private String placeId;
    private float latitude;
    private float longitude;

    public Location(String placeId, float latitude, float longitude) {
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "placeId='" + placeId + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

