package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShelterDetailsmainbean {

    @SerializedName("shelterDetails")
    @Expose
    private List<ShelterDetailsBean> shelterDetails = null;

    public List<ShelterDetailsBean> getShelterDetails() {
        return shelterDetails;
    }

    public void setShelterDetails(List<ShelterDetailsBean> shelterDetails) {
        this.shelterDetails = shelterDetails;
    }
}
