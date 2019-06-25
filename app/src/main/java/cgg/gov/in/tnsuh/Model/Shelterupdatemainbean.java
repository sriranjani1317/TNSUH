package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import cgg.gov.in.tnsuh.ShelterupdateBean;

public class Shelterupdatemainbean {
    @SerializedName("personasDetails")
    @Expose
    private List<ShelterupdateBean> personasDetails = null;

    public List<ShelterupdateBean> getPersonasDetails() {
        return personasDetails;
    }

    public void setPersonasDetails(List<ShelterupdateBean> personasDetails) {
        this.personasDetails = personasDetails;
    }
}
