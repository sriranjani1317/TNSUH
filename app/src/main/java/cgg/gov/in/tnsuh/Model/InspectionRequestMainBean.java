package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InspectionRequestMainBean {

    @SerializedName("inspectionDetails")
    @Expose
    private inspectionrequest inspectionDetails = null;

    public inspectionrequest getInspectionDetails() {
        return inspectionDetails;
    }

    public void setInspectionDetails(inspectionrequest inspectionrequest) {
        this.inspectionDetails = inspectionrequest;
    }



}
