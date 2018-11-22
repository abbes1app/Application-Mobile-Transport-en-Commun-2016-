package com.example.getgpslocation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.getgpslocation.activity.LoginActivity;
import com.example.getgpslocation.activity.RegisterActivity;

public class Main2Activity extends Activity {
    Button Login;
    Button Register ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);


        Login = (Button) findViewById(R.id.Login);
        Register = (Button) findViewById(R.id.Register);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Main2Activity.this,LoginActivity.class);
                startActivity(i1);
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Main2Activity.this,RegisterActivity.class);
                startActivity(i2);
            }
        });



    }
}
