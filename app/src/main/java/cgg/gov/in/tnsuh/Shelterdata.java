package cgg.gov.in.tnsuh;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import cgg.gov.in.tnsuh.Model.AmenityDetail;
import cgg.gov.in.tnsuh.Model.ShelterDetail;
import cgg.gov.in.tnsuh.Model.ShelterinMainBean;
import cgg.gov.in.tnsuh.retrofit.ApiClient;
import cgg.gov.in.tnsuh.retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static cgg.gov.in.tnsuh.Progressing.hideProgressDialog;
import static cgg.gov.in.tnsuh.Progressing.showProgressDialog;

public class Shelterdata extends AppCompatActivity {

    RecyclerView rv_workinitiationlist;
    Button btn_addwork;
    List<ShelterDetail> shelterinMainBeanList;
    shelterdataadapter shelterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelterdata);
        rv_workinitiationlist = (RecyclerView) findViewById(R.id.rv_workinitiationlist);
        callamenity(GlobalDeclaration.shelterid);
    }

    private void callamenity(String shelterid) {


        final ProgressDialog progressDiaLogss = showProgressDialog(new ProgressDialog(this), this);
        ApiInterface apiServiceSession = ApiClient.getClient().create(ApiInterface.class);


        Call<ShelterinMainBean> call = apiServiceSession.getshelterinfo(shelterid);
        Log.e("apiServiceSession_url: ", "" + call.request().url());
        call.enqueue(new Callback<ShelterinMainBean>() {
            @Override
            public void onResponse(Call<ShelterinMainBean> call, Response<ShelterinMainBean> response) {
                hideProgressDialog(progressDiaLogss);
                try {
                    ShelterinMainBean body = response.body();
                    if (body.getAmenityDetails().size()>0) {
                        shelterinMainBeanList = body.getShelterDetails();
                        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        rv_workinitiationlist.setLayoutManager(layoutManager);
                        shelterAdapter = new shelterdataadapter(shelterinMainBeanList, getApplicationContext(), Shelterdata.this);
                        rv_workinitiationlist.setAdapter(shelterAdapter);
                        shelterAdapter.notifyDataSetChanged();
                    } else {
                        showResponseAlert();
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong" + e.toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error", e.toString());
                }
            }

            @Override
            public void onFailure(Call<ShelterinMainBean> call, Throwable t) {
                hideProgressDialog(progressDiaLogss);

                Log.e("Exp", t.toString());

            }
        });

    }
    private void showResponseAlert() {
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(Shelterdata.this);
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
