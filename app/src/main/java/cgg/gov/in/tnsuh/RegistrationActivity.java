package cgg.gov.in.tnsuh;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.customlib.ToasterMessage;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cgg.gov.in.tnsuh.Model.DistrictMainBean;
import cgg.gov.in.tnsuh.Model.DistrictMasterBean;
import cgg.gov.in.tnsuh.Model.PersonasDetail;
import cgg.gov.in.tnsuh.Model.RegistrationResponse;
import cgg.gov.in.tnsuh.Model.StateMasterBean;
import cgg.gov.in.tnsuh.Model.StateMasterMainBean;
import cgg.gov.in.tnsuh.Model.personladetailsBean;
import cgg.gov.in.tnsuh.retrofit.ApiClient;
import cgg.gov.in.tnsuh.retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static cgg.gov.in.tnsuh.Common.Progressing.hideProgressDialog;
import static cgg.gov.in.tnsuh.Common.Progressing.showProgressDialog;
import static java.security.AccessController.getContext;

public class RegistrationActivity extends AppCompatActivity {
    private Bitmap bmp, processedBitmap;
    private String result;
    ProgressDialog progressDialog;
    RadioButton Married, Single, male_rb, female_rb, others_rb, normal_rb;
    RadioButton lunatic_rb, violent_rb, outsted_rb, stained_decision_rb, destitute_rb, intentional_rb;
    String married, single, male, female, others, normal, lunatic, violent, outsted, stained, destitude, international;
    LinearLayout lt_married;
    LinearLayout lt_single;
    StateAdapter stateAdapter;

    DistrictAdapter districtAdapter;
    Button btn_submit;
    String state_id, district_id, status_id,Sp_condition;
    ArrayList<StateMasterBean> stateMasterMainBeanArrayList;
    ArrayList<DistrictMasterBean> districtMasterBeanArrayList;
    ImageView iv_cam_one;
    EditText et_Name, et_Age, et_indivualidentified, et_town, et_wife, et_childcount, et_father, et_MotherName, et_nosibling,et_Ddistrict,et_Dstate,et_mobile;
    Spinner et_state, et_district, sp_status,sp_condition;
    EditText et_laststayed, et_longerstay, et_comlaug, et_Read, et_write, et_speak, et_Quatlification, et_placestudy, et_healthcondition, et_Physical_Alignment;
    RadioGroup rg_m_f_o, rg_n_l_v, rg_o_s_d_i, rg_m_u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationform);
        Married = (RadioButton) findViewById(R.id.married);
        Single = (RadioButton) findViewById(R.id.single);
        male_rb = (RadioButton) findViewById(R.id.male_rb);
        female_rb = (RadioButton) findViewById(R.id.female_rb);
        others_rb = (RadioButton) findViewById(R.id.others_rb);
        normal_rb = (RadioButton) findViewById(R.id.normal_rb);
        lunatic_rb = (RadioButton) findViewById(R.id.lunatic_rb);
        violent_rb = (RadioButton) findViewById(R.id.violent_rb);
        outsted_rb = (RadioButton) findViewById(R.id.outsted_rb);
        stained_decision_rb = (RadioButton) findViewById(R.id.stained_decision_rb);
        intentional_rb = (RadioButton) findViewById(R.id.intentional_rb);
        destitute_rb = (RadioButton) findViewById(R.id.destitute_rb);

        rg_m_f_o = (RadioGroup) findViewById(R.id.rg_m_f_o);
        rg_n_l_v = (RadioGroup) findViewById(R.id.rg_n_l_v);
        rg_o_s_d_i = (RadioGroup) findViewById(R.id.rg_o_s_d_i);
        rg_m_u = (RadioGroup) findViewById(R.id.rg_m_u);

        lt_married = (LinearLayout) findViewById(R.id.lt_married);
        lt_single = (LinearLayout) findViewById(R.id.lt_single);
        iv_cam_one = (ImageView) findViewById(R.id.iv_cam_one);
        et_Name = (EditText) findViewById(R.id.et_Name);
        et_Age = (EditText) findViewById(R.id.et_Age);
        et_Ddistrict = (EditText) findViewById(R.id.et_DDistrict);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_Dstate = (EditText) findViewById(R.id.et_DState);
        et_indivualidentified = (EditText) findViewById(R.id.et_indivualidentified);
        et_state = (Spinner) findViewById(R.id.et_state);
        et_district = (Spinner) findViewById(R.id.et_district);
        sp_status = (Spinner) findViewById(R.id.sp_spinner);
        sp_condition = (Spinner) findViewById(R.id.sp_condition);
        et_wife = (EditText) findViewById(R.id.et_wife);
        et_childcount = (EditText) findViewById(R.id.et_childcount);
        et_father = (EditText) findViewById(R.id.et_father);
        et_town = (EditText) findViewById(R.id.et_town);
        et_MotherName = (EditText) findViewById(R.id.et_MotherName);
        et_nosibling = (EditText) findViewById(R.id.et_nosibling);
        et_laststayed = (EditText) findViewById(R.id.et_laststayed);
        et_longerstay = (EditText) findViewById(R.id.et_longerstay);
        et_comlaug = (EditText) findViewById(R.id.et_comlaug);
        et_Read = (EditText) findViewById(R.id.et_Read);
        et_write = (EditText) findViewById(R.id.et_write);
        et_speak = (EditText) findViewById(R.id.et_speak);
        et_Quatlification = (EditText) findViewById(R.id.et_Quatlification);
        et_placestudy = (EditText) findViewById(R.id.et_placestudy);
        et_healthcondition = (EditText) findViewById(R.id.et_healthcondition);
        et_Physical_Alignment = (EditText) findViewById(R.id.et_Physical_Alignment);

        callState();
        sp_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                status_id= String.valueOf(parent.getSelectedItemId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_condition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Sp_condition= String.valueOf(parent.getSelectedItemId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        et_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                state_id = stateMasterMainBeanArrayList.get(position).getStateId();


                    CallDistrict(state_id);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        et_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                district_id = districtMasterBeanArrayList.get(position).getDistrictId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        rg_m_f_o.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (male_rb.isChecked()) {
                    male = male_rb.getText().toString();
                } else if (female_rb.isChecked()) {
                    female = female_rb.getText().toString();
                } else {
                    others = others_rb.getText().toString();
                }
            }
        });

        rg_n_l_v.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (normal_rb.isChecked()) {
                    normal = normal_rb.getText().toString();
                } else if (lunatic_rb.isChecked()) {
                    lunatic = lunatic_rb.getText().toString();
                } else {
                    violent = violent_rb.getText().toString();
                }
            }
        });

        rg_o_s_d_i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (outsted_rb.isChecked()) {
                    outsted = outsted_rb.getText().toString();
                } else if (stained_decision_rb.isChecked()) {
                    stained = stained_decision_rb.getText().toString();
                } else if (destitute_rb.isChecked()) {
                    destitude = destitute_rb.getText().toString();
                } else {
                    international = intentional_rb.getText().toString();
                }
            }
        });

        rg_m_u.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (Married.isChecked()) {
                    married = Married.getText().toString();
                } else if (Single.isChecked()) {
                    single = Single.getText().toString();
                }

            }
        });
        iv_cam_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
        btn_submit = (Button) findViewById(R.id.submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Registrationrequest();
            }
        });


     /*   Married.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lt_married.setVisibility(View.VISIBLE);
            }
        });
        Single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lt_married.setVisibility(View.VISIBLE);
            }
        });*/

    }

    private void showResponseAlert(String message, final Boolean Flag) {
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(RegistrationActivity.this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (Flag) {
                            Intent i = new Intent(RegistrationActivity.this, Profile.class);
                            startActivity(i);
                        }
                    }
                });
        android.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    public void openCamera() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 5);
            }
        } else {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, 100);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 5) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 100);

            } else {
                Toast.makeText(RegistrationActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (requestCode == 100 && resultCode == RESULT_OK) {

                bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();


                iv_cam_one.setImageBitmap(bmp);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] arr = baos.toByteArray();
                result = Base64.encodeToString(arr, Base64.DEFAULT);


            } else if (requestCode == 200 && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(RegistrationActivity.this.getContentResolver(), uri);

                    iv_cam_one.setImageBitmap(bitmap);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            Log.e("ExpCam", e.toString());
        }

    }


    private void Registrationrequest() {

        personladetailsBean personasDetail = new personladetailsBean();
        PersonasDetail pp = new PersonasDetail();
        pp.setName(et_Name.getText().toString());
        pp.setAge(et_Age.getText().toString());
        pp.setDateOfBirth("");
        pp.setPhoneNo("");

        pp.setIndividualIdentified(et_indivualidentified.getText().toString());
        pp.setDistrict(district_id);
        pp.setState(state_id);
        pp.setPhoneNo(et_mobile.getText().toString());
        pp.setAlternativePhoneNo("");
        pp.setAddress("");
        pp.setCondition(Sp_condition);
        pp.setStatus(status_id);
        pp.setDomicileState(et_Ddistrict.getText().toString());
        pp.setDomicileDistrict(et_Dstate.getText().toString());
        pp.setDomicileVillage(et_town.getText().toString());
        if (Married.isChecked()) {
            pp.setMaritalStatus(married);
        } else if (Single.isChecked()) {
            pp.setMaritalStatus(single);
        }


        pp.setLastStayedPlace(et_laststayed.getText().toString());
        pp.setPeriodStayedPlace(et_placestudy.getText().toString());
        pp.setConnonLanguage(et_comlaug.getText().toString());
        pp.setLanguageRead(et_Read.getText().toString());
        pp.setLanguageWrite(et_write.getText().toString());
        pp.setLanguageSpeak(et_speak.getText().toString());
        pp.setQualification(et_Quatlification.getText().toString());
        pp.setStudyPlace(et_placestudy.getText().toString());
        pp.setHealthCondition(et_healthcondition.getText().toString());
        pp.setMedicalAilment(et_Physical_Alignment.getText().toString());
        pp.setFirCopy(result);
        pp.setShelterId("1");
        List<PersonasDetail> personasDetaildata = new ArrayList<>();
        personasDetaildata.add(pp);
        personasDetail.setPersonasDetails(personasDetaildata);


        Registrationresponse(personasDetail);
        String objectsting = new Gson().toJson(personasDetail);
        Log.e("request", objectsting);


    }

    private void Registrationresponse(final personladetailsBean personasDetail) {

        //  progressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<RegistrationResponse> call = apiInterface.InsertPersonalDetails(personasDetail);
        Log.i("retro_request", call.request().url() + "");

        call.enqueue(new Callback<RegistrationResponse>() {

            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {

//                progressDialog.dismiss();
                try {
                    RegistrationResponse registrationResponse = response.body();
                    if (registrationResponse != null) {
                        showResponseAlert(registrationResponse.getPersonasDetails(), true);
                    } else {
                        showResponseAlert("Please try again", false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("rrr", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                //  progressDialog.dismiss();
                Toast.makeText(RegistrationActivity.this, "Please try again", Toast.LENGTH_LONG).show();

            }
        });
    }

    /* @Override
     public void onBackPressed() {
         Intent intent = new Intent(AcceptRejectActivity.this, DriverLandingActivity.class);
         intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
         startActivity(intent);
         finish();
     }*/
    private void callState() {

        final ProgressDialog progressDiaLogss = showProgressDialog(new ProgressDialog(RegistrationActivity.this), RegistrationActivity.this);
        ApiInterface apiServiceSession = ApiClient.getClient().create(ApiInterface.class);


        Call<StateMasterMainBean> call = apiServiceSession.getStateMaster();
        Log.e("apiServiceSession_url: ", "" + call.request().url());
        call.enqueue(new Callback<StateMasterMainBean>() {
            @Override
            public void onResponse(Call<StateMasterMainBean> call, Response<StateMasterMainBean> response) {
                hideProgressDialog(progressDiaLogss);
                try {
                    StateMasterMainBean body = response.body();
                    if (body != null) {
                        if (body.getStateDetails() != null) {
                            stateMasterMainBeanArrayList = (ArrayList<StateMasterBean>) body.getStateDetails();
                            final LinearLayoutManager layoutManager = new LinearLayoutManager(RegistrationActivity.this);
                            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                            stateAdapter = new StateAdapter(stateMasterMainBeanArrayList, RegistrationActivity.this);
                            et_state.setAdapter(stateAdapter);
                            stateAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(RegistrationActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Log.e("Error", e.toString());
                }
            }

            @Override
            public void onFailure(Call<StateMasterMainBean> call, Throwable t) {
                hideProgressDialog(progressDiaLogss);

                Log.e("Exp", t.toString());

            }
        });
    }

    private void CallDistrict(String state_id) {

        final ProgressDialog progressDiaLogss = showProgressDialog(new ProgressDialog(RegistrationActivity.this), RegistrationActivity.this);
        ApiInterface apiServiceSession = ApiClient.getClient().create(ApiInterface.class);


        Call<DistrictMainBean> call = apiServiceSession.getDistrictMaster(state_id);
        Log.e("apiServiceSession_url: ", "" + call.request().url());
        call.enqueue(new Callback<DistrictMainBean>() {
            @Override
            public void onResponse(Call<DistrictMainBean> call, Response<DistrictMainBean> response) {
                hideProgressDialog(progressDiaLogss);
                try {
                    DistrictMainBean body = response.body();
                    if (body != null) {
                        if (body.getDistrictDetails() != null) {
                            districtMasterBeanArrayList = (ArrayList<DistrictMasterBean>) body.getDistrictDetails();
                            final LinearLayoutManager layoutManager = new LinearLayoutManager(RegistrationActivity.this);
                            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                            districtAdapter = new DistrictAdapter(districtMasterBeanArrayList, RegistrationActivity.this);
                            et_district.setAdapter(districtAdapter);
                            districtAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(RegistrationActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Log.e("Error", e.toString());
                }
            }

            @Override
            public void onFailure(Call<DistrictMainBean> call, Throwable t) {
                hideProgressDialog(progressDiaLogss);

                Log.e("Exp", t.toString());

            }
        });
    }

}
