package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShelterResponseBean {

    @SerializedName("personasDetails")
    @Expose
    private String personasDetails;

    public String getPersonasDetails() {
        return personasDetails;
    }

    public void setPersonasDetails(String personasDetails) {
        this.personasDetails = personasDetails;
    }
}
