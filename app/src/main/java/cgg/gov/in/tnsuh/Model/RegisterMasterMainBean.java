package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterMasterMainBean {

    @SerializedName("registerDetails")
    @Expose
    private List<RegisterDetail> registerDetails = null;

    public List<RegisterDetail> getRegisterDetails() {
        return registerDetails;
    }

    public void setRegisterDetails(List<RegisterDetail> registerDetails) {
        this.registerDetails = registerDetails;
    }
}
