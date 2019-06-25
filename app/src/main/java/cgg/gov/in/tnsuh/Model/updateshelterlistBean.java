package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class updateshelterlistBean {

    public class SubmitworkMapBean {

        @SerializedName("personasDetails")
        @Expose
        private List<Updateshelter> personasDetails = null;

        public List<Updateshelter> getPersonasDetails() {
            return personasDetails;
        }

        public void setPersonasDetails(List<Updateshelter> personasDetails) {
            this.personasDetails = personasDetails;
        }

    }
}
