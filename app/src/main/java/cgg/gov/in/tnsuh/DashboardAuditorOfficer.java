package cgg.gov.in.tnsuh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardAuditorOfficer extends AppCompatActivity {

    Button btn_inspection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_auditor_officer);
        btn_inspection=(Button)findViewById(R.id.btn_inspection);
        btn_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardAuditorOfficer.this,InspectionForm.class);
                startActivity(i);
            }
        });
    }
}
