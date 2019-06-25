package cgg.gov.in.tnsuh.retrofit;


import java.util.List;

import cgg.gov.in.tnsuh.Model.AttendanceMainbean;
import cgg.gov.in.tnsuh.Model.DistrictMainBean;
import cgg.gov.in.tnsuh.Model.InspectionRequestMainBean;
import cgg.gov.in.tnsuh.Model.InspectionResponse;
import cgg.gov.in.tnsuh.Model.Loginresponse;

import cgg.gov.in.tnsuh.Model.PersonaldetailsMainbean;
import cgg.gov.in.tnsuh.Model.Registersheltermainbean;
import cgg.gov.in.tnsuh.Model.RegistrationResponse;
import cgg.gov.in.tnsuh.Model.ShelterDetailsmainbean;
import cgg.gov.in.tnsuh.Model.ShelterMainBean;
import cgg.gov.in.tnsuh.Model.ShelterResponseBean;
import cgg.gov.in.tnsuh.Model.ShelterinMainBean;
import cgg.gov.in.tnsuh.Model.StateMasterBean;
import cgg.gov.in.tnsuh.Model.StateMasterMainBean;
import cgg.gov.in.tnsuh.Model.Updateshelter;
import cgg.gov.in.tnsuh.Model.inspectionrequest;
import cgg.gov.in.tnsuh.Model.personladetailsBean;
import cgg.gov.in.tnsuh.Model.updateshelterlistBean;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("srs/login/Authentication/{user_id}/{Password}")
    Call<Loginresponse> getlogin(@Path("user_id") String userid,
                                 @Path("Password") String password);
    @GET("srs/ShelterDetails")
    Call<ShelterDetailsmainbean> getshelte5rdetails();

    @GET("srs/ShelterDetails/{shelter_Id}")
    Call<ShelterinMainBean> getshelterinfo(@Path("shelter_Id") String userid);

    @GET("srs/Masters/StateMaster")
    Call<StateMasterMainBean> getStateMaster();

    @GET("srs/Masters/DistrictMaster/{State_id}")
    Call<DistrictMainBean> getDistrictMaster(@Path("State_id") String userid );

    @GET("srs/PersonalDetails/getPersonalDetails/{shelter_Id}")
    Call<PersonaldetailsMainbean> getpersonaldata(@Path("shelter_Id") String userid);

    @GET("srs/Attendance/AttendanceEntry/{shelter_Id}")
    Call<AttendanceMainbean> getAttendance(@Path("shelter_Id") String userid);

    @POST("srs/ShelterUpdate")
    Call<ShelterResponseBean> updatelocation(@Body ShelterMainBean checkInRequest);


    @POST("srs/InpsectionEntry/InsertInpsection")
    Call<InspectionResponse> InsertInspection(@Body inspectionrequest checkInRequest);

    @POST("srs/PersonalDetails/InsertPersonalDetails")
    Call<RegistrationResponse> InsertPersonalDetails(@Body personladetailsBean checkInRequest);

    @POST("srs/Masters/RegisterMaster")
    Call<Registersheltermainbean> registermaster();
}
