package cgg.gov.in.tnsuh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView user_profile_name, mobile;
    ImageButton user_profile_photo;
    Button btn_inspection;
    ImageView logout;
    Button btn_registration, btn_relive, btn_attendance, btn_stock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        logout = (ImageView) findViewById(R.id.iv_logout);
        user_profile_photo=(ImageButton)findViewById(R.id.user_profile_photo);
        user_profile_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Profile.this,Profiledetail.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Profile.this,LoginActivity.class);
                startActivity(i);
            }
        });
        user_profile_name = (TextView) findViewById(R.id.user_profile_name);
        mobile = (TextView) findViewById(R.id.mobile);
        LinearLayout btn_incharge = (LinearLayout) findViewById(R.id.btn_incharge);
        LinearLayout btn_Auditor = (LinearLayout) findViewById(R.id.btn_Auditor);
        if(GlobalDeclaration.ROLE_NAME.equalsIgnoreCase("SHELTER")){
            btn_incharge.setVisibility(View.VISIBLE);
            btn_Auditor.setVisibility(View.GONE);
        }else
        {
            btn_incharge.setVisibility(View.GONE);
            btn_Auditor.setVisibility(View.VISIBLE);
        }
        btn_inspection=(Button)findViewById(R.id.btn_inspection);
        btn_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Profile.this,InspectionForm.class);
                startActivity(i);
            }
        });
        btn_attendance = (Button) findViewById(R.id.btn_attendance);
        btn_registration = (Button) findViewById(R.id.btn_registration);
        btn_relive = (Button) findViewById(R.id.btn_relive);
        btn_stock = (Button) findViewById(R.id.btn_stock);
        user_profile_name.setText(GlobalDeclaration.username);
        mobile.setText(GlobalDeclaration.mobile);
        btn_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, AttendanceActivity.class);
                startActivity(i);
            }
        });
        btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
        btn_relive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, RelieveActivity.class);
                startActivity(i);
            }
        });
        btn_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, StockActivity.class);
                startActivity(i);
            }
        });
    }
}
