package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InspectionResponse {

    @SerializedName("inspectionDetails")
    @Expose
    private String inspectionDetails;

    public String getInspectionDetails() {
        return inspectionDetails;
    }

    public void setInspectionDetails(String inspectionDetails) {
        this.inspectionDetails = inspectionDetails;
    }
}
