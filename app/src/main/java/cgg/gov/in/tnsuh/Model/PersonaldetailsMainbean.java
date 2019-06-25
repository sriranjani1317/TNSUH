package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonaldetailsMainbean {

    @SerializedName("personalDetails")
    @Expose
    private List<Personaldetails> personalDetails = null;

    public List<Personaldetails> getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(List<Personaldetails> personalDetails) {
        this.personalDetails = personalDetails;
    }
}
