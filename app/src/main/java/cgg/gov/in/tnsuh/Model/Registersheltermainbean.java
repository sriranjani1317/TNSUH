package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Registersheltermainbean
{

    @SerializedName("registerDetails")
    @Expose
    private List<RegisterMasterBean> registerDetails = null;

    public List<RegisterMasterBean> getRegisterDetails() {
        return registerDetails;
    }

    public void setRegisterDetails(List<RegisterMasterBean> registerDetails) {
        this.registerDetails = registerDetails;
    }
}
