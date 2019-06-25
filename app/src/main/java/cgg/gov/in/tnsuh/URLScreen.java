package cgg.gov.in.tnsuh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class URLScreen extends AppCompatActivity {
    EditText serverurl;
Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.urllayout);
        serverurl=(EditText)findViewById(R.id.serverurl);
        Submit=(Button)findViewById(R.id.submit_url);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              GlobalDeclaration.Serverurl=serverurl.getText().toString();
                Intent i=new Intent(URLScreen.this,LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
