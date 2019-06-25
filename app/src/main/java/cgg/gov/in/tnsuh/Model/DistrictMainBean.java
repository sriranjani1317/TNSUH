package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DistrictMainBean {


    @SerializedName("districtDetails")
    @Expose
    private List<DistrictMasterBean> districtDetails = null;

    public List<DistrictMasterBean> getDistrictDetails() {
        return districtDetails;
    }

    public void setDistrictDetails(List<DistrictMasterBean> districtDetails) {
        this.districtDetails = districtDetails;
    }
}
