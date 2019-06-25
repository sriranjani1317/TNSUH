package cgg.gov.in.tnsuh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GradeReport extends AppCompatActivity {
TextView capacitymarks,medicalcamp,festival,skilltraining,councilfacility,infrafacility,excecutivecommitee,shetermanagement,assesment,college;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_report);

        capacitymarks=(TextView)findViewById(R.id.capacitymarks);
        medicalcamp=(TextView)findViewById(R.id.medicalcamp);
        festival=(TextView)findViewById(R.id.festival);
        skilltraining=(TextView)findViewById(R.id.skilltraining);
        councilfacility=(TextView)findViewById(R.id.councilfacility);
        infrafacility=(TextView)findViewById(R.id.infrafacility);
        excecutivecommitee=(TextView)findViewById(R.id.excecutivecommitee);
        shetermanagement=(TextView)findViewById(R.id.shetermanagement);
        assesment=(TextView)findViewById(R.id.assesment);
        college=(TextView)findViewById(R.id.college);
        try {
            capacitymarks.setText(String.valueOf(MarksObtained.capacity));
            medicalcamp.setText(String.valueOf(MarksObtained.medicalcamp));
            festival.setText(String.valueOf(MarksObtained.festival));
            skilltraining.setText(String.valueOf(MarksObtained.skilltraining));
            infrafacility.setText(String.valueOf(MarksObtained.infra));
            councilfacility.setText(String.valueOf(MarksObtained.councelling));
            excecutivecommitee.setText(String.valueOf(MarksObtained.exccomitee));
            shetermanagement.setText(String.valueOf(MarksObtained.shelter));
            assesment.setText(String.valueOf(MarksObtained.assessment));
            college.setText(String.valueOf(MarksObtained.interaction
            ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
