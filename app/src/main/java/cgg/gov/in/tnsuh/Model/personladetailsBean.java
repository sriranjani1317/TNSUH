package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class personladetailsBean {


    @SerializedName("personasDetails")
    @Expose
    private List<PersonasDetail> personasDetails = null;

    public List<PersonasDetail> getPersonasDetails() {
        return personasDetails;
    }

    public void setPersonasDetails(List<PersonasDetail> personasDetails) {
        this.personasDetails = personasDetails;
    }

}
