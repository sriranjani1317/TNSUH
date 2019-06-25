package cgg.gov.in.tnsuh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard_OfficerIncharge extends AppCompatActivity {

    Button btn_registration, btn_relive, btn_attendance, btn_stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_attendance = (Button) findViewById(R.id.btn_attendance);
        btn_registration = (Button) findViewById(R.id.btn_registration);
        btn_relive = (Button) findViewById(R.id.btn_relive);
        btn_stock = (Button) findViewById(R.id.btn_stock);

        btn_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_OfficerIncharge.this, AttendanceActivity.class);
                startActivity(i);
            }
        });
        btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_OfficerIncharge.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
        btn_relive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_OfficerIncharge.this, RelieveActivity.class);
                startActivity(i);
            }
        });
        btn_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_OfficerIncharge.this, StockActivity.class);
                startActivity(i);
            }
        });
    }
}
