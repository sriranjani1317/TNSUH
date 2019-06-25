package cgg.gov.in.tnsuh;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_inspection=(Button)findViewById(R.id.btn_inspection);
        Button btn_Auditor=(Button)findViewById(R.id.btn_Auditor);
        btn_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Dashboard_OfficerIncharge.class);
                startActivity(i);
            }
        });

        btn_Auditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,DashboardAuditorOfficer.class);
                startActivity(i);
            }
        });


    }
}
