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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

import cgg.gov.in.tnsuh.Model.ShelterDetailsBean;
import cgg.gov.in.tnsuh.Model.ShelterDetailsmainbean;
import cgg.gov.in.tnsuh.retrofit.ApiClient;
import cgg.gov.in.tnsuh.retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static cgg.gov.in.tnsuh.Progressing.hideProgressDialog;
import static cgg.gov.in.tnsuh.Progressing.showProgressDialog;

public class RelieveActivity extends AppCompatActivity {
    RecyclerView rv_workinitiationlist;
    Button btn_addwork;
    List<ShelterDetailsBean> shelterDetailsBeanList;
    ShelterAdapter shelterAdapter;
    ImageButton home;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shelteractivity);
        rv_workinitiationlist=(RecyclerView)findViewById(R.id.rv_workinitiationlist);
        callshelterdata();
    }
    private void callshelterdata() {


        final ProgressDialog progressDiaLogss = showProgressDialog(new ProgressDialog(this), this);
        ApiInterface apiServiceSession = ApiClient.getClient().create(ApiInterface.class);


        Call<ShelterDetailsmainbean> call = apiServiceSession.getshelte5rdetails();
        Log.e("apiServiceSession_url: ", "" + call.request().url());
        call.enqueue(new Callback<ShelterDetailsmainbean>() {
            @Override
            public void onResponse(Call<ShelterDetailsmainbean> call, Response<ShelterDetailsmainbean> response) {
                hideProgressDialog(progressDiaLogss);
                try {
                    ShelterDetailsmainbean body = response.body();
                    if (body.getShelterDetails().size()>0) {
                        shelterDetailsBeanList = body.getShelterDetails();
                        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        rv_workinitiationlist.setLayoutManager(layoutManager);
                        shelterAdapter = new ShelterAdapter(shelterDetailsBeanList, getApplicationContext(), RelieveActivity.this);
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
            public void onFailure(Call<ShelterDetailsmainbean> call, Throwable t) {
                hideProgressDialog(progressDiaLogss);

                Log.e("Exp", t.toString());

            }
        });

    }
    private void showResponseAlert() {
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(RelieveActivity.this);
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
