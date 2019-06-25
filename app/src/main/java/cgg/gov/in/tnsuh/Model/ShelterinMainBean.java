package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShelterinMainBean {

    @SerializedName("amenityDetails")
    @Expose
    private List<AmenityDetail> amenityDetails;
    @SerializedName("shelterDetails")
    @Expose
    private List<ShelterDetail> shelterDetails;
    @SerializedName("inmatesDetails")
    @Expose
    private List<InmatesDetail> inmatesDetails;
    @SerializedName("registerDetails")
    @Expose
    private List<RegisterDetail> registerDetails ;
    @SerializedName("locationDetails")
    @Expose
    private List<LocationDetail> locationDetails ;

    public List<AmenityDetail> getAmenityDetails() {
        return amenityDetails;
    }

    public void setAmenityDetails(List<AmenityDetail> amenityDetails) {
        this.amenityDetails = amenityDetails;
    }

    public List<ShelterDetail> getShelterDetails() {
        return shelterDetails;
    }

    public void setShelterDetails(List<ShelterDetail> shelterDetails) {
        this.shelterDetails = shelterDetails;
    }

    public List<InmatesDetail> getInmatesDetails() {
        return inmatesDetails;
    }

    public void setInmatesDetails(List<InmatesDetail> inmatesDetails) {
        this.inmatesDetails = inmatesDetails;
    }

    public List<RegisterDetail> getRegisterDetails() {
        return registerDetails;
    }

    public void setRegisterDetails(List<RegisterDetail> registerDetails) {
        this.registerDetails = registerDetails;
    }

    public List<LocationDetail> getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(List<LocationDetail> locationDetails) {
        this.locationDetails = locationDetails;
    }

}
