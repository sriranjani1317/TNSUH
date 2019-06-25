package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Personaldetails {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone_no")
    @Expose
    private String phoneNo;
    @SerializedName("alternative_phone_no")
    @Expose
    private String alternativePhoneNo;
    @SerializedName("to_char")
    @Expose
    private String toChar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAlternativePhoneNo() {
        return alternativePhoneNo;
    }

    public void setAlternativePhoneNo(String alternativePhoneNo) {
        this.alternativePhoneNo = alternativePhoneNo;
    }

    public String getToChar() {
        return toChar;
    }

    public void setToChar(String toChar) {
        this.toChar = toChar;
    }

}

