package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InmatesDetail {
    @SerializedName("inmates_id")
    @Expose
    private String inmatesId;
    @SerializedName("shelter_id")
    @Expose
    private String shelterId;
    @SerializedName("female")
    @Expose
    private String female;
    @SerializedName("male")
    @Expose
    private String male;
    @SerializedName("inmates_name")
    @Expose
    private String inmatesName;

    public String getInmatesId() {
        return inmatesId;
    }

    public void setInmatesId(String inmatesId) {
        this.inmatesId = inmatesId;
    }

    public String getShelterId() {
        return shelterId;
    }

    public void setShelterId(String shelterId) {
        this.shelterId = shelterId;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getInmatesName() {
        return inmatesName;
    }

    public void setInmatesName(String inmatesName) {
        this.inmatesName = inmatesName;
    }
}
