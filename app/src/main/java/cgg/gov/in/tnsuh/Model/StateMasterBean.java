package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StateMasterBean {

    @SerializedName("state_id")
    @Expose
    private String stateId;
    @SerializedName("state_name")
    @Expose
    private String stateName;

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

}
