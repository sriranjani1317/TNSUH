package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShelterDetail {

    @SerializedName("shelter_executive_committee_date")
    @Expose
    private String shelterExecutiveCommitteeDate;
    @SerializedName("municipality_corporation_name")
    @Expose
    private String municipalityCorporationName;
    @SerializedName("district_name")
    @Expose
    private String districtName;
    @SerializedName("shelter_executive_committee")
    @Expose
    private String shelterExecutiveCommittee;
    @SerializedName("shelter_id")
    @Expose
    private String shelterId;
    @SerializedName("shelter_location")
    @Expose
    private String shelterLocation;
    @SerializedName("shelter_management_committee")
    @Expose
    private String shelterManagementCommittee;
    @SerializedName("shelter_management_committee_date")
    @Expose
    private String shelterManagementCommitteeDate;
    @SerializedName("shelter_type")
    @Expose
    private String shelterType;
    @SerializedName("shelter_bank_account_formed")
    @Expose
    private String shelterBankAccountFormed;
    @SerializedName("shelter_start_date")
    @Expose
    private String shelterStartDate;
    @SerializedName("shelter_no_inmates")
    @Expose
    private String shelterNoInmates;
    @SerializedName("shelter_extend")
    @Expose
    private String shelterExtend;

    public String getShelterExecutiveCommitteeDate() {
        return shelterExecutiveCommitteeDate;
    }

    public void setShelterExecutiveCommitteeDate(String shelterExecutiveCommitteeDate) {
        this.shelterExecutiveCommitteeDate = shelterExecutiveCommitteeDate;
    }

    public String getMunicipalityCorporationName() {
        return municipalityCorporationName;
    }

    public void setMunicipalityCorporationName(String municipalityCorporationName) {
        this.municipalityCorporationName = municipalityCorporationName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getShelterExecutiveCommittee() {
        return shelterExecutiveCommittee;
    }

    public void setShelterExecutiveCommittee(String shelterExecutiveCommittee) {
        this.shelterExecutiveCommittee = shelterExecutiveCommittee;
    }

    public String getShelterId() {
        return shelterId;
    }

    public void setShelterId(String shelterId) {
        this.shelterId = shelterId;
    }

    public String getShelterLocation() {
        return shelterLocation;
    }

    public void setShelterLocation(String shelterLocation) {
        this.shelterLocation = shelterLocation;
    }

    public String getShelterManagementCommittee() {
        return shelterManagementCommittee;
    }

    public void setShelterManagementCommittee(String shelterManagementCommittee) {
        this.shelterManagementCommittee = shelterManagementCommittee;
    }

    public String getShelterManagementCommitteeDate() {
        return shelterManagementCommitteeDate;
    }

    public void setShelterManagementCommitteeDate(String shelterManagementCommitteeDate) {
        this.shelterManagementCommitteeDate = shelterManagementCommitteeDate;
    }

    public String getShelterType() {
        return shelterType;
    }

    public void setShelterType(String shelterType) {
        this.shelterType = shelterType;
    }

    public String getShelterBankAccountFormed() {
        return shelterBankAccountFormed;
    }

    public void setShelterBankAccountFormed(String shelterBankAccountFormed) {
        this.shelterBankAccountFormed = shelterBankAccountFormed;
    }

    public String getShelterStartDate() {
        return shelterStartDate;
    }

    public void setShelterStartDate(String shelterStartDate) {
        this.shelterStartDate = shelterStartDate;
    }

    public String getShelterNoInmates() {
        return shelterNoInmates;
    }

    public void setShelterNoInmates(String shelterNoInmates) {
        this.shelterNoInmates = shelterNoInmates;
    }

    public String getShelterExtend() {
        return shelterExtend;
    }

    public void setShelterExtend(String shelterExtend) {
        this.shelterExtend = shelterExtend;
    }

}
