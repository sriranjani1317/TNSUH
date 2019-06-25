package cgg.gov.in.tnsuh;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.customlib.ToasterMessage;

import java.util.logging.Level;

import cgg.gov.in.tnsuh.Model.Loginresponse;
import cgg.gov.in.tnsuh.retrofit.ApiClient;
import cgg.gov.in.tnsuh.retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static cgg.gov.in.tnsuh.Progressing.hideProgressDialog;
import static cgg.gov.in.tnsuh.Progressing.showProgressDialog;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button) findViewById(R.id.login);

        et_username = (EditText) findViewById(R.id.userid);
        et_password = (EditText) findViewById(R.id.password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                callLoginService(et_username.getText().toString(), et_password.getText().toString());


            }


        });


    }

    private void callLoginService(String username, String password) {
        // Intent i = new Intent(LoginActivity.this, DashBoardActivity.class);
        //startActivity(i);
        final ProgressDialog progressDialog = showProgressDialog(new ProgressDialog(this), this);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Loginresponse> call = apiInterface.getlogin(username, password);
        Log.e("", "apiServiceSession url : " + call.request().url());

        call.enqueue(new Callback<Loginresponse>() {
            @Override
            public void onResponse(Call<Loginresponse> call, Response<Loginresponse> response) {
                hideProgressDialog(progressDialog);
                try {

                    Loginresponse body = response.body();
                    if (body.getUserDetails().size() > 0) {
                        GlobalDeclaration.username = body.getUserDetails().get(0).getUserName().toString();
                        GlobalDeclaration.mobile = body.getUserDetails().get(0).getPhoneNo().toString();
                        GlobalDeclaration.ROLE_NAME = body.getUserDetails().get(0).getRoleName().toString();
                        ToasterMessage.showToast(LoginActivity.this,"working fine");
                        Intent i = new Intent(LoginActivity.this, Profile.class);
                        startActivity(i);

                    } else
                        Toast.makeText(LoginActivity.this, "Invalid username/password", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(LoginActivity.this, ""+body.getFlag()+"//"+body.getMemid(), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<Loginresponse> call, Throwable t) {
                hideProgressDialog(progressDialog);
                Log.e("Error", t.toString());
            }
        });


    }

    private boolean validateFields() {
        boolean valid = true;
        if (et_username.getText().toString().trim().length() == 0) {
            setFocus(et_username, "Please enter username");
            valid = false;
        } else if (et_password.getText().toString().trim().length() == 0) {
            setFocus(et_password, "Please enter password");
            valid = false;
        }

        return valid;
    }

    private void setFocus(EditText editText, String string) {
        editText.requestFocus();
        ((EditText) editText).setError(Html.fromHtml("<font color='red'>" + string + "</font>"));
    }


}
