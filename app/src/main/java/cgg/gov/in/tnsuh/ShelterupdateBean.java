package cgg.gov.in.tnsuh;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShelterupdateBean {

    @SerializedName("shelter_id")
    @Expose
    private String shelterId;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

    public String getShelterId() {
        return shelterId;
    }

    public void setShelterId(String shelterId) {
        this.shelterId = shelterId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
