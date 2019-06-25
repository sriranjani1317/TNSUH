package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class AttendanceMainbean {


    @Expose
    private List<AttendanceBean> personasDetails = null;

    public List<AttendanceBean> getPersonasDetails() {
        return personasDetails;
    }

    public void setPersonasDetails(List<AttendanceBean> personasDetails) {
        this.personasDetails = personasDetails;
    }
}

