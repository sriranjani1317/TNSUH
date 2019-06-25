package cgg.gov.in.tnsuh;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Shelterin extends AppCompatActivity {

    Button btn_Amenity, btn_shelter, btn_Inmates, btn_Location, btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelterin);

        btn_Amenity = (Button) findViewById(R.id.btn_Amenity);
        btn_shelter = (Button) findViewById(R.id.btn_shelter);
        btn_Location = (Button) findViewById(R.id.btn_Location);
        btn_Inmates = (Button) findViewById(R.id.btn_Inmates);
        btn_Register = (Button) findViewById(R.id.btn_Register);

        btn_Amenity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shelterin.this, Amenity.class);
                startActivity(i);
            }
        });
        btn_shelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shelterin.this, Shelterdata.class);
                startActivity(i);
            }
        });
        btn_Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shelterin.this, Locationdata.class);
                startActivity(i);
            }
        });
        btn_Inmates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shelterin.this, Inmates.class);
                startActivity(i);
            }
        });
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shelterin.this, Register.class);
                startActivity(i);
            }
        });
    }
}
