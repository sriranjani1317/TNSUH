package cgg.gov.in.tnsuh;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import cgg.gov.in.tnsuh.Model.RegisterMasterBean;
import cgg.gov.in.tnsuh.Model.Registersheltermainbean;
import cgg.gov.in.tnsuh.Model.ShelterDetailsBean;
import cgg.gov.in.tnsuh.Model.ShelterDetailsmainbean;
import cgg.gov.in.tnsuh.retrofit.ApiClient;
import cgg.gov.in.tnsuh.retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static cgg.gov.in.tnsuh.Progressing.hideProgressDialog;
import static cgg.gov.in.tnsuh.Progressing.showProgressDialog;

public class Registrationinspectionlist extends AppCompatActivity {
    RecyclerView rv_workinitiationlist;

    Button btn_addwork;
    List<RegisterMasterBean> shelterDetailsBeanList;
    RegisterInspectionAdapter registerInspectionAdapter;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationinspectionlist);
        rv_workinitiationlist = (RecyclerView) findViewById(R.id.rv_workinitiationlist);
        callinspectionregistraiton();
    }

    private void callinspectionregistraiton() {


        final ProgressDialog progressDiaLogss = showProgressDialog(new ProgressDialog(this), this);
        ApiInterface apiServiceSession = ApiClient.getClient().create(ApiInterface.class);


        Call<Registersheltermainbean> call = apiServiceSession.registermaster();
        Log.e("apiServiceSession_url: ", "" + call.request().url());
        call.enqueue(new Callback<Registersheltermainbean>() {
            @Override
            public void onResponse(Call<Registersheltermainbean> call, Response<Registersheltermainbean> response) {
                hideProgressDialog(progressDiaLogss);
                try {
                    Registersheltermainbean body = response.body();
                    if (body.getRegisterDetails().size()>0) {
                        shelterDetailsBeanList = body.getRegisterDetails();
                        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        rv_workinitiationlist.setLayoutManager(layoutManager);
                        registerInspectionAdapter = new RegisterInspectionAdapter(shelterDetailsBeanList, getApplicationContext(), Registrationinspectionlist.this);
                        rv_workinitiationlist.setAdapter(registerInspectionAdapter);
                        registerInspectionAdapter.notifyDataSetChanged();
                    } else {
                        showResponseAlert();
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong" + e.toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error", e.toString());
                }
            }

            @Override
            public void onFailure(Call<Registersheltermainbean> call, Throwable t) {
                hideProgressDialog(progressDiaLogss);

                Log.e("Exp", t.toString());

            }
        });

    }
    private void showResponseAlert() {
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(Registrationinspectionlist.this);
        alertDialogBuilder.setMessage("No Data Available");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
        android.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

}
