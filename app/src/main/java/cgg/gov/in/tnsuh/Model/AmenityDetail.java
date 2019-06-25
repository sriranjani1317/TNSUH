package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AmenityDetail {
    @SerializedName("amenity_id")
    @Expose
    private String amenityId;
    @SerializedName("shelter_id")
    @Expose
    private String shelterId;
    @SerializedName("amenity_name")
    @Expose
    private String amenityName;
    @SerializedName("amenity_avail_notavail")
    @Expose
    private String amenityAvailNotavail;

    public String getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(String amenityId) {
        this.amenityId = amenityId;
    }

    public String getShelterId() {
        return shelterId;
    }

    public void setShelterId(String shelterId) {
        this.shelterId = shelterId;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public String getAmenityAvailNotavail() {
        return amenityAvailNotavail;
    }

    public void setAmenityAvailNotavail(String amenityAvailNotavail) {
        this.amenityAvailNotavail = amenityAvailNotavail;
    }
}
