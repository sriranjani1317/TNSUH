package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictMasterBean {

    @SerializedName("district_name")
    @Expose
    private String districtName;
    @SerializedName("district_id")
    @Expose
    private String districtId;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }
}
