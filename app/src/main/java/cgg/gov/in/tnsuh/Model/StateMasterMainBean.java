package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StateMasterMainBean {

    @SerializedName("stateDetails")
    @Expose
    private List<StateMasterBean> stateDetails = null;

    public List<StateMasterBean> getStateDetails() {
        return stateDetails;
    }

    public void setStateDetails(List<StateMasterBean> stateDetails) {
        this.stateDetails = stateDetails;
    }

}
