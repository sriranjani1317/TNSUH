package cgg.gov.in.tnsuh.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonasDetail {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("individual_identified")
    @Expose
    private String individualIdentified;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("phone_no")
    @Expose
    private String phoneNo;
    @SerializedName("alternative_phone_no")
    @Expose
    private String alternativePhoneNo;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("domicile_state")
    @Expose
    private String domicileState;
    @SerializedName("domicile_district")
    @Expose
    private String domicileDistrict;
    @SerializedName("domicile_village")
    @Expose
    private String domicileVillage;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("last_stayed_place")
    @Expose
    private String lastStayedPlace;
    @SerializedName("period_stayed_place")
    @Expose
    private String periodStayedPlace;
    @SerializedName("connon_language")
    @Expose
    private String connonLanguage;
    @SerializedName("language_read")
    @Expose
    private String languageRead;
    @SerializedName("language_write")
    @Expose
    private String languageWrite;
    @SerializedName("language_speak")
    @Expose
    private String languageSpeak;
    @SerializedName("qualification")
    @Expose
    private String qualification;
    @SerializedName("study_place")
    @Expose
    private String studyPlace;
    @SerializedName("health_condition")
    @Expose
    private String healthCondition;
    @SerializedName("medical_ailment")
    @Expose
    private String medicalAilment;
    @SerializedName("physical_ailment")
    @Expose
    private String physicalAilment;
    @SerializedName("fir_copy")
    @Expose
    private String firCopy;
    @SerializedName("shelter_id")
    @Expose
    private String shelterId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIndividualIdentified() {
        return individualIdentified;
    }

    public void setIndividualIdentified(String individualIdentified) {
        this.individualIdentified = individualIdentified;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDomicileState() {
        return domicileState;
    }

    public void setDomicileState(String domicileState) {
        this.domicileState = domicileState;
    }

    public String getDomicileDistrict() {
        return domicileDistrict;
    }

    public void setDomicileDistrict(String domicileDistrict) {
        this.domicileDistrict = domicileDistrict;
    }

    public String getDomicileVillage() {
        return domicileVillage;
    }

    public void setDomicileVillage(String domicileVillage) {
        this.domicileVillage = domicileVillage;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getLastStayedPlace() {
        return lastStayedPlace;
    }

    public void setLastStayedPlace(String lastStayedPlace) {
        this.lastStayedPlace = lastStayedPlace;
    }

    public String getPeriodStayedPlace() {
        return periodStayedPlace;
    }

    public void setPeriodStayedPlace(String periodStayedPlace) {
        this.periodStayedPlace = periodStayedPlace;
    }

    public String getConnonLanguage() {
        return connonLanguage;
    }

    public void setConnonLanguage(String connonLanguage) {
        this.connonLanguage = connonLanguage;
    }

    public String getLanguageRead() {
        return languageRead;
    }

    public void setLanguageRead(String languageRead) {
        this.languageRead = languageRead;
    }

    public String getLanguageWrite() {
        return languageWrite;
    }

    public void setLanguageWrite(String languageWrite) {
        this.languageWrite = languageWrite;
    }

    public String getLanguageSpeak() {
        return languageSpeak;
    }

    public void setLanguageSpeak(String languageSpeak) {
        this.languageSpeak = languageSpeak;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public void setStudyPlace(String studyPlace) {
        this.studyPlace = studyPlace;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getMedicalAilment() {
        return medicalAilment;
    }

    public void setMedicalAilment(String medicalAilment) {
        this.medicalAilment = medicalAilment;
    }

    public String getPhysicalAilment() {
        return physicalAilment;
    }

    public void setPhysicalAilment(String physicalAilment) {
        this.physicalAilment = physicalAilment;
    }

    public String getFirCopy() {
        return firCopy;
    }

    public void setFirCopy(String firCopy) {
        this.firCopy = firCopy;
    }

    public String getShelterId() {
        return shelterId;
    }

    public void setShelterId(String shelterId) {
        this.shelterId = shelterId;
    }

}
