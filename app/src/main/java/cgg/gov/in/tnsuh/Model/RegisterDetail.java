package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterDetail {
    @SerializedName("register_avail_notavail")
    @Expose
    private String registerAvailNotavail;
    @SerializedName("shelter_id")
    @Expose
    private String shelterId;
    @SerializedName("register_name")
    @Expose
    private String registerName;
    @SerializedName("register_id")
    @Expose
    private String registerId;

    public String getRegisterAvailNotavail() {
        return registerAvailNotavail;
    }

    public void setRegisterAvailNotavail(String registerAvailNotavail) {
        this.registerAvailNotavail = registerAvailNotavail;
    }

    public String getShelterId() {
        return shelterId;
    }

    public void setShelterId(String shelterId) {
        this.shelterId = shelterId;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }
}
